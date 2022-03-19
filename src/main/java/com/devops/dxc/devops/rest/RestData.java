package com.devops.dxc.devops.rest;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.devops.dxc.devops.model.Resultado;
import com.devops.dxc.devops.service.BalanceService;
import com.devops.dxc.devops.service.TaxService;
import com.devops.dxc.devops.service.TenPercentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class RestData {
	
	private final static Logger LOGGER = Logger.getLogger("devops.subnivel.Control");

	@Autowired
	TenPercentService _tenPercentService;
	
	@Autowired
	BalanceService _balanceService;
	
	@Autowired
	TaxService _taxService;

	@GetMapping(path = "/dxc", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resultado get10Porciento(@RequestParam(name = "sueldo") String sueldo, @RequestParam(name = "ahorro") String ahorro){
		
		LOGGER.log(Level.INFO, "<Trabajo DevOps - DXC> <Consultado Diez por ciento>");
		
		return _tenPercentService.calculateTenPercent(ahorro, sueldo);
	}

	@GetMapping(path = "/saldo", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resultado getSaldo(@RequestParam(name = "ahorro") String ahorro, @RequestParam(name = "retiro") String retiro){
		
		LOGGER.log(Level.INFO, "<Trabajo DevOps - DXC> <Consultado Saldo>");
		
		return _balanceService.calculateBalance(ahorro,retiro);
	}

	@GetMapping(path = "/impuesto", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resultado getImpuesto(@RequestParam(name = "sueldo") String sueldo, @RequestParam(name = "retiro") String retiro){
		
		LOGGER.log(Level.INFO, "<Trabajo DevOps - DXC> <Consultado Impuesto>");
		
		return _taxService.calculateTax(sueldo, retiro);
	}
}