package com.bloodbank.sbbm.service;

import com.bloodbank.sbbm.entity.PaymentDetails;

public interface PaymentService {

	PaymentDetails addPayment(PaymentDetails paymentdetails);

	//PaymentDetails addNewPayment(PaymentDetails paymentdetails, int requestId);
	
    PaymentDetails fetchPaymentDetail(int ppId);
}
