package com.devops.dxc.devops.service;

import com.devops.dxc.devops.model.Resultado;

public interface TaxService {
	
	public Resultado calculateTax(String sueldo, String tenPercent);
}
