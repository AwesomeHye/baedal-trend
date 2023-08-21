package dev.elsboo.baedaltrendbatch.taklets;

import dev.elsboo.openapi.OpenApiUtil;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class ApiFailTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        OpenApiUtil.fail();
        return RepeatStatus.CONTINUABLE;
    }
}
