package com.techmahindra.services;

/**
 * Created by sameh.hanna on 17/4/17.
 *
 * @author sameh.hanna
 */
public class TruncateServiceImpl implements TruncateService {

    private static final String TRUNCATE_STRING = " ... (truncated) ... ";

    public String truncate(String input, Integer size) {
        if (input == null)
            return null;
        if (input.length() < size)
            return input;

        if (TRUNCATE_STRING.length() > size)
            return input;

        Integer remainingSize = size - TRUNCATE_STRING.length();

        String output;
        if (remainingSize % 2 == 0)
            output = input.substring(0, remainingSize / 2) + TRUNCATE_STRING + input.substring(input.length() - remainingSize / 2);
        else
            output = input.substring(0, (remainingSize / 2) + 1) + TRUNCATE_STRING + input.substring(input.length() - remainingSize / 2);

        return output;
    }
}
