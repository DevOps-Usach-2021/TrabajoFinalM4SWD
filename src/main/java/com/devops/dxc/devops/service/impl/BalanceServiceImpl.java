package com.devops.dxc.devops.service.impl;

import org.springframework.stereotype.Service;

import com.devops.dxc.devops.service.BalanceService;

@Service
public class BalanceServiceImpl implements BalanceService {

	public String calculateBalance(String tenPercent) {
		//llamo calculo de saldo restante
		return "50000";
	}

}
