package com.innovaturelabs.manager.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 *
 * @author Sreesanth
 */
@RestController
@RequestMapping("/razorpay")
public class RazorPayController {

    @GetMapping()
    public void order() throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient("rzp_test_dnNRnT4daAnSlc", "a7Yg7t9V9HsFjRBc59L0RlO7");
        Order order=createRazorpayOrder(BigInteger.valueOf(1000));
//        OrderResponse response=new OrderResponse();
    }

    private Order createRazorpayOrder(BigInteger amount) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient("rzp_test_dnNRnT4daAnSlc", "a7Yg7t9V9HsFjRBc59L0RlO7");

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount.multiply(new BigInteger("100")));
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "payment_receipt1");

        return razorpay.orders.create(orderRequest);
    }
}
