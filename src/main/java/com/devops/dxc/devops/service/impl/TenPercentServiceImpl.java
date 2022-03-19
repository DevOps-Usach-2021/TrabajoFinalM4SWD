package com.devops.dxc.devops.service.impl;

import org.springframework.stereotype.Service;

import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Resultado;
import com.devops.dxc.devops.service.TenPercentService;

@Service
public class TenPercentServiceImpl implements TenPercentService {

	public Resultado calculateTenPercent(String saldo, String sueldo) {
		try {
			Dxc calculo = new Dxc(Integer.parseInt(saldo), Integer.parseInt(sueldo));
			return new Resultado(calculo.getDxc(), true, "OK");
		} catch (Exception e) {
			return new Resultado(0, false,e.getMessage());
		}
	}

}
