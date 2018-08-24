package br.com.campanha;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
//@AutoConfigureTestDatabase(replace=Replace.NONE)
@EnableAsync
public class CampanhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampanhaApplication.class, args);
	}
	
	
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5000); 
        executor.setMaxPoolSize(10000); 
        executor.setQueueCapacity(500); 
        executor.setThreadNamePrefix("CampanhaTimeCoracaoService-");
        executor.initialize();
        return executor;
    }
	
	
	
}
