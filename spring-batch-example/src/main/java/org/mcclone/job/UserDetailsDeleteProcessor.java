package org.mcclone.job;

import org.mcclone.domain.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by mcclone on 16-8-27.
 */
public class UserDetailsDeleteProcessor implements ItemProcessor<UserDetails, UserDetails> {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsDeleteProcessor.class);

    @Override
    public UserDetails process(UserDetails item) throws Exception {
        logger.info(item.toString());
        return item;
    }
}
