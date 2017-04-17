package com.techmahindra.controllers;

/**
 * Created by sameh.hanna on 17/4/17.
 *
 * @author sameh.hanna
 */

import com.techmahindra.services.TruncateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SubscriptionController {

    @Autowired
    private TruncateService truncateService;

    @RequestMapping(value = "/subscribe", method = RequestMethod.GET)
    public String subscribe(HttpServletRequest request) {

        String orderDetails = getOrderDetails(request);

        String truncatedOrderDetails = truncateService.truncate(orderDetails, 250);

        log(truncatedOrderDetails);

        return truncatedOrderDetails;

    }

    private void log(String truncatedOrderDetails) {

        System.out.println(truncatedOrderDetails);
    }

    private String getOrderDetails(HttpServletRequest request) {
        return "";
    }

}
