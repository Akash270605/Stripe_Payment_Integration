/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.stripe.controller;

import com.example.stripe.dto.ProductRequest;
import com.example.stripe.dto.StripeResponse;
import com.example.stripe.service.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/v1")
public class ProductCheckoutController {
    
    @Autowired
    private StripeService stripeService;
    
    
    
    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkoutProducts(@RequestBody ProductRequest productRequest){
        StripeResponse stripeResponse = stripeService.checkoutProducts(productRequest);
        
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(stripeResponse);
    }
}
