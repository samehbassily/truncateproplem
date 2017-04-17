package com.techmahindra.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by sameh.hanna on 17/4/17.
 *
 * @author sameh.hanna
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.techmahindra.conf.Configuration.class)
public class TruncateServiceTest {

    private String strLessThanSize = "123456789012345678901234567890";

    private String strLengthGreaterThanTruncateStringSize = "1234567890";

    private String inputStr = "123456789012345678901234567890";

    private String outputStr = "12 ... (truncated) ... 90";

    private String inputStrWithOddRemaining = "1234567890123456789012345678901";

    private String outputStrWithOddRemaining = "123 ... (truncated) ... 01";

    @Autowired
    private TruncateService truncateService;

    @Before
    public void setup() {

    }

    /**
     * It should return null if the input string is null
     */
    @Test
    public void testNullTruncate() {
        String truncatedStr = truncateService.truncate(null, 9);
        assertThat(truncatedStr).isNull();
    }

    /**
     * It should return same string if string length is less than truncate size
     */
    @Test
    public void testTruncateStringLengthLessThanSize() {

        String truncatedStr = truncateService.truncate(strLessThanSize, 31);
        assertThat(truncatedStr).isEqualTo(strLessThanSize);
    }

    /**
     * It should return same input string if the replacing string length is greater than truncate size
     */
    @Test
    public void testTruncateWithGreaterTruncateSize() {

        String truncatedStr = truncateService.truncate(strLengthGreaterThanTruncateStringSize, 31);
        assertThat(truncatedStr).isEqualTo(strLengthGreaterThanTruncateStringSize);
    }

    /**
     * It should return output string included truncated String in the middle
     */
    @Test
    public void testTruncate() {

        String truncatedStr = truncateService.truncate(inputStr, 25);
        assertThat(truncatedStr).isEqualTo(outputStr);
        assertThat(truncatedStr.length()).isEqualTo(25);
    }

    /**
     * It should return output string included truncated String in the middle
     */
    @Test
    public void testTruncate2() {

        String truncatedStr = truncateService.truncate(inputStrWithOddRemaining, 26);
        assertThat(truncatedStr).isEqualTo(outputStrWithOddRemaining);
        assertThat(truncatedStr.length()).isEqualTo(26);
    }
}
