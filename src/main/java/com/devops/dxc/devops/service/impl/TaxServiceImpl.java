package com.devops.dxc.devops.service.impl;

import org.springframework.stereotype.Service;

import com.devops.dxc.devops.model.Resultado;
import com.devops.dxc.devops.rest.RestData;
import com.devops.dxc.devops.service.TaxService;

@Service
public class TaxServiceImpl implements TaxService {

	public Resultado calculateTax(String sueldo, String tenPercent) {
		RestData rest = new RestData();
		return rest.getImpuesto(sueldo, tenPercent);
	}

}
