package com.devops.dxc.devops.service.impl;

import org.springframework.stereotype.Service;

import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Resultado;
import com.devops.dxc.devops.rest.RestData;
import com.devops.dxc.devops.service.BalanceService;

@Service
public class BalanceServiceImpl implements BalanceService {

	public Resultado calculateBalance(String saldo, String tenPercent) {
		try {
			Dxc calculo = new Dxc(Integer.parseInt(tenPercent), Integer.parseInt(saldo), false, true);
			return new Resultado(calculo.getSaldo(), true, "OK");
		} catch (Exception e) {
			return new Resultado(0, false,e.getMessage());
		}
	}

}
