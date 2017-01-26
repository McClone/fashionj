package org.mcclone;

import org.mcclone.domain.User;
import org.mcclone.domain.UserDetails;
import org.mcclone.domain.UserDetailsRepository;
import org.mcclone.job.JpaJobExecutionListener;
import org.mcclone.job.UserDetailsDeleteProcessor;
import org.mcclone.job.UserDetailsDeleteWrite;
import org.mcclone.job.UserDetailsSaveProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

/**
 * @author zhengsd
 */
public class JpaBatchConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final EntityManagerFactory entityManagerFactory;

    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public JpaBatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, EntityManagerFactory entityManagerFactory, UserDetailsRepository userDetailsRepository) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.entityManagerFactory = entityManagerFactory;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Bean
    public JpaPagingItemReader<User> userItemReader() {
        JpaPagingItemReader<User> jpaPagingItemReader = new JpaPagingItemReader<>();
        jpaPagingItemReader.setPageSize(100);
        jpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);
        jpaPagingItemReader.setQueryString("from User user");
        return jpaPagingItemReader;
    }

    @Bean
    public JpaPagingItemReader<UserDetails> userDetailsItemReader() {
        JpaPagingItemReader<UserDetails> jpaPagingItemReader = new JpaPagingItemReader<>();
        jpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);
        jpaPagingItemReader.setQueryString("from UserDetails user");
        return jpaPagingItemReader;
    }

    @Bean
    public JpaItemWriter<UserDetails> userDetailsItemWriter() {
        JpaItemWriter<UserDetails> jdbcBatchItemWriter = new JpaItemWriter<>();
        jdbcBatchItemWriter.setEntityManagerFactory(entityManagerFactory);
        return jdbcBatchItemWriter;
    }

    @Bean
    public UserDetailsDeleteWrite userDetailsDeleteWrite() {
        return new UserDetailsDeleteWrite(userDetailsRepository);
    }

    @Bean
    public UserDetailsSaveProcessor userDetailsSaveProcessor() {
        return new UserDetailsSaveProcessor();
    }

    @Bean
    public UserDetailsDeleteProcessor detailsDeleteProcessor() {
        return new UserDetailsDeleteProcessor();
    }

    @Bean
    public JpaJobExecutionListener jpaJobExecutionListener() {
        return new JpaJobExecutionListener(userDetailsRepository);
    }

    @Bean
    public Step step1(ItemReader<User> userItemReader, ItemProcessor<User, UserDetails> userDetailsSaveProcessor, ItemWriter<UserDetails> userDetailsItemWriter) {
        return stepBuilderFactory
                .get("step1")
                .<User, UserDetails>chunk(5)
                .reader(userItemReader)
                .processor(userDetailsSaveProcessor)
                .writer(userDetailsItemWriter)
                .build();
    }

    @Bean
    public Step step2(ItemReader<UserDetails> userDetailsItemReader, ItemProcessor<UserDetails, UserDetails> detailsDeleteProcessor, ItemWriter<UserDetails> userDetailsDeleteWrite) {
        return stepBuilderFactory
                .get("step2")
                .<UserDetails, UserDetails>chunk(10)
                .reader(userDetailsItemReader)
                .processor(detailsDeleteProcessor)
                .writer(userDetailsDeleteWrite)
                .build();
    }

    @Bean
    public Job job(Step step1, Step step2, JobExecutionListener jpaJobExecutionListener) throws Exception {
        return jobBuilderFactory.get("job1")
                .start(step1).next(step2).listener(jpaJobExecutionListener)
                .build();
    }
}
