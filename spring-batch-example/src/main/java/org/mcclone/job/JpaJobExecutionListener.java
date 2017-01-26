package org.mcclone.job;

import org.mcclone.domain.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Created by mcclone on 16-8-27.
 */
public class JpaJobExecutionListener implements JobExecutionListener {

    private final UserDetailsRepository userDetailsRepository;

    private static final Logger logger = LoggerFactory.getLogger(JpaJobExecutionListener.class);

    public JpaJobExecutionListener(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("job success");
            int count = userDetailsRepository.findAll().size();
            logger.info(count > 0 ? String.valueOf(count) : "0");
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            logger.error("job failure");
        }
    }
}
