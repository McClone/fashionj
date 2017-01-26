package org.mcclone.job;

import org.mcclone.domain.UserDetails;
import org.mcclone.domain.UserDetailsRepository;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by mcclone on 16-8-27.
 */
public class UserDetailsDeleteWrite implements ItemWriter<UserDetails> {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsDeleteWrite(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public void write(List<? extends UserDetails> items) throws Exception {
        this.userDetailsRepository.delete(items);
    }
}
