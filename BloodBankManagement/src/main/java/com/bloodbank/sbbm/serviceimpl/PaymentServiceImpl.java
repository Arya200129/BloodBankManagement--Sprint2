package com.bloodbank.sbbm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.bloodbank.sbbm.entity.BloodRequest;
import com.bloodbank.sbbm.entity.PaymentDetails;
//import com.bloodbank.sbbm.exception.BloodRequestIdNotFoundException;
import com.bloodbank.sbbm.exception.PaymentIdNotFoundException;
import com.bloodbank.sbbm.repository.BloodRequestRepository;
import com.bloodbank.sbbm.repository.PaymentRepository;
import com.bloodbank.sbbm.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentRepository pprepo;
	
	@Autowired
	BloodRequestRepository requestRepo;
	

	@Override
	public PaymentDetails addPayment(PaymentDetails paymentdetails) {
		return pprepo.save(paymentdetails);
	}
	
	/*@Override
	public PaymentDetails addNewPayment(PaymentDetails paymentdetails, int requestId) {
		
		BloodRequest bloodRequest = requestRepo.findById(requestId).orElseThrow(() -> new BloodRequestIdNotFoundException("Entered Request ID is invalid/incorrect"));
		
		paymentdetails.setBloodRequest(bloodRequest);
		
		return pprepo.save(paymentdetails);
	}*/

	@Override
	public PaymentDetails fetchPaymentDetail(int ppId) {
		return pprepo.findById(ppId).orElseThrow(() -> new PaymentIdNotFoundException("Entered Payment ID is invalid/incorrect"));
	}
}
