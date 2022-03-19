package com.devops.dxc.devops.service.impl;

import org.springframework.stereotype.Service;

import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Resultado;
import com.devops.dxc.devops.rest.RestData;
import com.devops.dxc.devops.service.TaxService;

@Service
public class TaxServiceImpl implements TaxService {

	public Resultado calculateTax(String sueldo, String tenPercent) {
		try {
			Dxc calculo = new Dxc(Integer.parseInt(tenPercent), Integer.parseInt(sueldo), true);
			return new Resultado(calculo.getImpuesto(), true, "OK");
		} catch (Exception e) {
			return new Resultado(0, false,e.getMessage());
		}
	}

}
