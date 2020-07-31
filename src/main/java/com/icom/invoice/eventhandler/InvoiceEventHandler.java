package com.icom.invoice.eventhandler;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.icom.invoice.feign.IOrderFeignClient;
import com.icom.invoice.model.Invoice;
import com.icom.invoice.repository.InvoiceRepository;


@Component
@RepositoryEventHandler(Invoice.class)
public class InvoiceEventHandler {
	Logger logger = LoggerFactory.getLogger(InvoiceEventHandler.class);
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	IOrderFeignClient iOrderFeignClient;

	/**
	 * @param invoice
	 * Calling iOrder service to create shipment if status is confirmed
	 * Assume that each invoice only confirmed one time
	 */
	@HandleBeforeSave
	public void handlerInvoiceConfirmStatus(Invoice invoice) {
		logger.info("Invoice {}", invoice.getInvoiceNumber());
		
		if (invoice.getStatus().equalsIgnoreCase("confirmed")) {
			logger.info("Trigger calling iOrder to confirm invoice {}", invoice.getInvoiceId());
			iOrderFeignClient.invoiceToShipment(UUID.fromString(invoice.getOrderId()), invoice.getInvoiceNumber());
		}
	}
}
