package com.devops.dxc.devops.service.impl;

import org.springframework.stereotype.Service;

import com.devops.dxc.devops.model.Resultado;
import com.devops.dxc.devops.rest.RestData;
import com.devops.dxc.devops.service.BalanceService;

@Service
public class BalanceServiceImpl implements BalanceService {

	public Resultado calculateBalance(String saldo, String tenPercent) {
		RestData rest = new RestData();
		return rest.getSaldo(saldo, tenPercent);
	}

}
