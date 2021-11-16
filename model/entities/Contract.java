package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private Integer number;
	private Date date;
	private Double totalValue;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private List<Installment> list = new ArrayList<>();	
	
	
	public Contract() {
	}

	public Contract(Integer number, Date date, Double totalValue) {
		super();
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public void setList(Installment inst) {
		list.add(inst);
	}

	public void getList() {
		for(Installment inst : list) {
			System.out.println("Date: "+sdf.format(inst.getDueDate()));
			System.out.println("Amount: "+inst.getAmount());
		}
	}
	
}
