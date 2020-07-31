package com.icom.invoice.config;

import com.icom.invoice.model.Invoice;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

@Component
public class RepositoryConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Invoice.class);
	}

	
}
