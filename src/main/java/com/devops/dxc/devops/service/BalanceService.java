package com.devops.dxc.devops.service;

import com.devops.dxc.devops.model.Resultado;

public interface BalanceService {
	public Resultado calculateBalance(String saldo, String tenPercent);
}
