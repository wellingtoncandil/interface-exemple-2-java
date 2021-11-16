package model.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractPaymentService {
	
	private OnlinePaymentService ops = new PaypalService();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public void processContract(Contract contract, int months) {
		for(int i=0; i<months; i++) {
			Date paymentDate = contract.getDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(paymentDate);
			cal.add(Calendar.MONTH, i+1);
			paymentDate = cal.getTime();
			
			double installmentValue = ops.interest(contract.getTotalValue()/months, i+1) + contract.getTotalValue()/months;
			installmentValue += ops.paymentFee(installmentValue);
			
			Installment inst = new Installment(paymentDate, installmentValue);
			contract.setList(inst);	
		}
	}
}
