package back.vybz.user_info_service.kafka.config;

import back.vybz.user_info_service.kafka.event.UserInfoEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@RequiredArgsConstructor
public class UserInfoKafkaConfig {

    private final CommonKafkaConfig commonKafkaConfig;

    @Bean
    public ProducerFactory<String, UserInfoEvent> userInfoProducerFactory() {
        return new DefaultKafkaProducerFactory<>(commonKafkaConfig.commonProducerConfigs());
    }

    @Bean
    public KafkaTemplate<String, UserInfoEvent> userInfoKafkaTemplate() {
        return new KafkaTemplate<>(userInfoProducerFactory());
    }

    @Bean
    public ProducerFactory<String, String> stringUserInfoProducerFactory() {
        return new DefaultKafkaProducerFactory<>(commonKafkaConfig.commonProducerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> stringUserInfoKafkaTemplate() {
        return new KafkaTemplate<>(stringUserInfoProducerFactory());
    }


    @Bean
    public ConsumerFactory<String, UserInfoEvent> userInfoEventConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                commonKafkaConfig.commonConsumerConfigs(),
                new StringDeserializer(),
                new ErrorHandlingDeserializer<>(new JsonDeserializer<>(UserInfoEvent.class, false))
        );
    }

    @Bean(name = "userInfoKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, UserInfoEvent> userInfoKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserInfoEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userInfoEventConsumerFactory());

        return factory;
    }

}
