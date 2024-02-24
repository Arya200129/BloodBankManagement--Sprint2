package com.bloodbank.sbbm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.sbbm.entity.PaymentDetails;
import com.bloodbank.sbbm.service.PaymentService;

import jakarta.validation.Valid;

@RestController
public class PaymentController {

	@Autowired
	PaymentService pps;
	
	@PostMapping("/savePayment")
	public ResponseEntity<PaymentDetails> savePayment(@Valid @RequestBody PaymentDetails paymentDetails){
		return new ResponseEntity<PaymentDetails>(pps.addPayment(paymentDetails), HttpStatus.CREATED);
	}
	
	/*@PostMapping("/addNewPayment")
	public ResponseEntity<PaymentDetails> addNewPayment(@RequestBody PaymentDetails paymentDetails, @RequestParam int requestId){
		return new ResponseEntity<PaymentDetails>(pps.addNewPayment(paymentDetails, requestId), HttpStatus.CREATED);
	}*/
	
	@GetMapping("/getPaymentDetails/{paymentId}")
    public ResponseEntity<PaymentDetails> fetchPaymentDetail(@PathVariable("paymentId") int ppId) {
        return new ResponseEntity<PaymentDetails>(pps.fetchPaymentDetail(ppId), HttpStatus.OK);
    }
}
