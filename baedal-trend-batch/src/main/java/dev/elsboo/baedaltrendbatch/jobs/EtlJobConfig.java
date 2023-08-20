package dev.elsboo.baedaltrendbatch.jobs;

import dev.elsboo.baedaltrendbatch.taklets.ApiTasklet;
import dev.elsboo.baedaltrendbatch.taklets.EsTasklet;
import dev.elsboo.baedaltrendbatch.taklets.S3Tasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class EtlJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job extractJob() {
        return jobBuilderFactory.get("etlJob")
            .start(apiStep())
            .next(s3Step())
            .next(esStep())
            .build();
    }

    @Bean
    public Step apiStep() {
        return stepBuilderFactory.get("apiStep")
            .tasklet(new ApiTasklet())
            .build();
    }

    private Step s3Step() {
        return stepBuilderFactory.get("s3Step")
            .tasklet(new S3Tasklet())
            .build()
            ;
    }

    private Step esStep() {
        return stepBuilderFactory.get("esStep")
            .tasklet(new EsTasklet())
            .build();
    }
}
