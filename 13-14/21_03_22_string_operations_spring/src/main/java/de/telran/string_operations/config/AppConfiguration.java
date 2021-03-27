package de.telran.string_operations.config;

import de.telran.string_operations.OperationContext;
import de.telran.string_operations.service.operation.IStringOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AppConfiguration {

    @Bean
    public PrintWriter printWriter(@Value("${de.telran.string_operation.output.file.path}") String fileName) throws FileNotFoundException {
        return new PrintWriter(fileName);
    }

    @Bean
    public OperationContext operationContext(List<IStringOperation> operationList) {
        return new OperationContext(operationList);
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(3600); // wait an hour if necessary
        executor.setThreadNamePrefix("StringOperations-");
        executor.initialize();
        return executor;
    }
}
