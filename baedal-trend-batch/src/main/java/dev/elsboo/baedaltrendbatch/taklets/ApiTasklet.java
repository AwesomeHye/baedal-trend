package dev.elsboo.baedaltrendbatch.taklets;

import dev.elsboo.openapi.OpenApiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class ApiTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        OpenApiUtil.main();
        return RepeatStatus.CONTINUABLE;
    }
}
