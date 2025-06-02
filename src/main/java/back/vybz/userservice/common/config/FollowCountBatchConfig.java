package back.vybz.userservice.common.config;

import back.vybz.userservice.follow.domain.mongodb.BuskerFollowerCount;
import back.vybz.userservice.follow.domain.mongodb.Follow;
import back.vybz.userservice.follow.domain.mongodb.UserFollowingCount;
import back.vybz.userservice.follow.infrastructure.mongodb.BuskerFollowerCountRepository;
import back.vybz.userservice.follow.infrastructure.mongodb.UserFollowingCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class FollowCountBatchConfig {

    private final MongoTemplate mongoTemplate;
    private final UserFollowingCountRepository userFollowingCountRepository;
    private final BuskerFollowerCountRepository buskerFollowerCountRepository;

    // 유저 팔로잉 카운트 배치
    @Bean
    public Job userFollowCountJob(JobRepository jobRepository, Step userFollowCountStep) {
        return new JobBuilder("userFollowCountJob", jobRepository)
                .start(userFollowCountStep)
                .build();
    }

    @Bean
    public Step userFollowCountStep(JobRepository jobRepository, PlatformTransactionManager txManager) {
        return new StepBuilder("userFollowCountStep", jobRepository)
                .<Follow, UserFollowingCount> chunk(1000, txManager)
                .reader(userFollowReader())
                .processor(userFollowProcesser())
                .writer(userFollowWriter())
                .build();
    }

    @Bean
    public MongoCursorItemReader<Follow> userFollowReader() {
        MongoCursorItemReader<Follow> reader = new MongoCursorItemReader<>();
        reader.setTemplate(mongoTemplate);
        reader.setCollection("follow");
        reader.setTargetType(Follow.class);
        reader.setQuery("{}");
        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("_id", Sort.Direction.ASC);
        reader.setSort(sorts);
        return reader;
    }

    @Bean
    public ItemProcessor<Follow, UserFollowingCount> userFollowProcesser() {
        return follow -> UserFollowingCount.builder()
                .userUuid(follow.getFollower() != null && !follow.getFollower().isEmpty()
                        ? follow.getFollower().get(0).getUserUuid()
                        : null)
                .totalFollowingCount(follow.getFollower() != null ? follow.getFollower().size() : 0)
                .build();
    }

    @Bean
    public ItemWriter<UserFollowingCount> userFollowWriter() {
        return items -> items.forEach(userFollowingCountRepository::save);
    }

    // 버스커 팔로워 카운트 배치
    @Bean
    public Job buskerFollowerCountJob(JobRepository jobRepository, Step buskerFollowerCountStep) {
        return new JobBuilder("buskerFollowerCountJob", jobRepository)
                .start(buskerFollowerCountStep)
                .build();
    }

    @Bean
    public Step buskerFollowerCountStep(JobRepository jobRepository, PlatformTransactionManager txManager) {
        return new StepBuilder("buskerFollowerCountStep", jobRepository)
                .<Follow, BuskerFollowerCount> chunk(1000, txManager)
                .reader(buskerFollowerReader())
                .processor(buskerFollowerProcessor())
                .writer(buskerFollowerWriter())
                .build();
    }

    @Bean
    public MongoCursorItemReader<Follow> buskerFollowerReader() {
        MongoCursorItemReader<Follow> reader = new MongoCursorItemReader<>();
        reader.setTemplate(mongoTemplate);
        reader.setCollection("follow");
        reader.setTargetType(Follow.class);
        reader.setQuery("{}");
        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("_id", Sort.Direction.ASC);
        reader.setSort(sorts);
        return reader;
    }

    @Bean
    public ItemProcessor<Follow, BuskerFollowerCount> buskerFollowerProcessor() {
        return follower -> BuskerFollowerCount.builder()
                .buskerUuid(follower.getFollowing().get(0).getBuskerUuid())
                .totalFollowerCount(follower.getFollowing() != null ? follower.getFollowing().size() : 0)
                .build();
    }

    @Bean
    public ItemWriter<BuskerFollowerCount> buskerFollowerWriter() {
        return items -> items.forEach(buskerFollowerCountRepository::save);
    }

}
