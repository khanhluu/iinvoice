package com.icom.invoice.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Invoice as a resource
 */
@Entity
@Table
public class Invoice {
	
	@Id
	@Column(name = "INVOICE_ID")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID invoiceId;
	
	@Column(name = "ORDER_ID")
	private String orderId;
	
	@Column(name = "INVOICE_NO", unique = true)
	private String invoiceNumber;
	
	@Column(name = "ORDER_DATE")
	private Timestamp createDate;;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
		
	@Column(name = "AMOUNT")
	private double totalAmount;
	
	@Column(name = "STATUS")
	private String status;
	
	@PrePersist
	protected void genInvoiceNumber() {
		this.invoiceNumber = RandomStringUtils.random(15, true, true);
		this.createDate = new Timestamp(System.currentTimeMillis());
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UUID getInvoiceId() {
		return invoiceId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
