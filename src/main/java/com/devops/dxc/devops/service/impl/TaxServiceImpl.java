package com.devops.dxc.devops.service.impl;

import org.springframework.stereotype.Service;

import com.devops.dxc.devops.service.TaxService;

@Service
public class TaxServiceImpl implements TaxService {

	public String calculateTax(String tenPercent) {
		// llamar calculo impuesto
		return "12000";
	}

}
