package com.devops.dxc.devops.service.impl;

import org.springframework.stereotype.Service;

import com.devops.dxc.devops.model.Resultado;
import com.devops.dxc.devops.rest.RestData;
import com.devops.dxc.devops.service.TenPercentService;

@Service
public class TenPercentServiceImpl implements TenPercentService {

	public Resultado calculateTenPercent(String saldo, String sueldo) {
		RestData rest = new RestData();
		return (rest.get10Porciento(sueldo, saldo));
	}

}
