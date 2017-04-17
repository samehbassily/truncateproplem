package com.techmahindra.conf;

import com.techmahindra.services.TruncateService;
import com.techmahindra.services.TruncateServiceImpl;
import org.springframework.context.annotation.Bean;

/**
 * Created by sameh.hanna on 17/4/17.
 *
 * @author sameh.hanna
 */
public class Configuration {

    @Bean
    public TruncateService truncateService() {
        return new TruncateServiceImpl();
    }
}
