package com.icom.invoice.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign Client for iOrder service
 */
@FeignClient("iorder")
public interface IOrderFeignClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/internalShipping/{orderId}/shipment")
	@SpanName("ConfirmInvoice")
	String invoiceToShipment(@PathVariable UUID orderId, @RequestParam("invoiceNo") String invoiceNo);
}
