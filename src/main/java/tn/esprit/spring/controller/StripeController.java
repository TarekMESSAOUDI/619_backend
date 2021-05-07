package tn.esprit.spring.controller;


import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;


import tn.esprit.spring.entity.Payment;
import tn.esprit.spring.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stripe")
@CrossOrigin(origins = "*")
public class StripeController {

    @Autowired
    PaymentService paymentService;



    @PreAuthorize("hasAuthority('CLIENT') ")

    @PostMapping("/paymentintent")
    public ResponseEntity<String> payment(@RequestBody Payment payment) throws StripeException {
        PaymentIntent paymentIntent = paymentService.paymentIntent(payment);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
    }

    @PostMapping("/confirm/{id}")


    @PreAuthorize("hasAuthority('CLIENT') ")

    public ResponseEntity<String> confirm(@PathVariable("id") String id) throws StripeException {
        PaymentIntent paymentIntent = paymentService.confirm(id);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
    }

    @PostMapping("/cancel/{id}")


    @PreAuthorize("hasAuthority('CLIENT') ")
    public ResponseEntity<String> cancel(@PathVariable("id") String id) throws StripeException {
        PaymentIntent paymentIntent = paymentService.cancel(id);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
    }

}
