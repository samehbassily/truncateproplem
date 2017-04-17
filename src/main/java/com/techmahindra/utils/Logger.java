package com.techmahindra.utils;

import org.springframework.stereotype.Component;

/**
 * Created by sameh.hanna on 17/4/17.
 *
 * @author sameh.hanna
 */
@Component
public class Logger {

    public void log(String truncatedOrderDetails) {

        System.out.println(truncatedOrderDetails);
    }
}
