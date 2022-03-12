package com.devops.dxc.devops.service.impl;

import org.springframework.stereotype.Service;

import com.devops.dxc.devops.service.TenPercentService;

@Service
public class TenPercentServiceImpl implements TenPercentService {

	public String calculateTenPercent(String saldo, String sueldo) {
		//llamar calculo 10%
		return "100000";
	}

}
