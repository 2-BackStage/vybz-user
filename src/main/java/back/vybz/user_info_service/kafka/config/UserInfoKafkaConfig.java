package back.vybz.user_info_service.kafka.config;

import back.vybz.user_info_service.kafka.event.UserInfoEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@RequiredArgsConstructor
public class UserInfoKafkaConfig {

    private final CommonKafkaConfig commonKafkaConfig;

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
