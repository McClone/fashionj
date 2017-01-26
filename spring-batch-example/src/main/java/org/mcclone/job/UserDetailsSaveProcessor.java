package org.mcclone.job;

import org.mcclone.domain.User;
import org.mcclone.domain.UserDetails;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author zhengsd
 */
public class UserDetailsSaveProcessor implements ItemProcessor<User, UserDetails> {

    @Override
    public UserDetails process(User item) throws Exception {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(item.getUserId());
        userDetails.setUserName(item.getUserName());
        return userDetails;
    }
}
