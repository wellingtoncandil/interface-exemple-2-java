package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractPaymentService;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data: ");
		System.out.println("Number: ");
		int numb = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double cValue = sc.nextDouble();
		System.out.println("Enter number of installments: ");
		int inst = sc.nextInt();
		
		Contract c = new Contract(numb, date, cValue);
		ContractPaymentService cps = new ContractPaymentService();
		cps.processContract(c, inst);
		
		c.getList();
		
		
		sc.close();
	}
}
