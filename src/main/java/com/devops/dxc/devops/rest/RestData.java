package com.devops.dxc.devops.rest;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Resultado;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class RestData {
	
	private final static Logger LOGGER = Logger.getLogger("devops.subnivel.Control");

	@GetMapping(path = "/dxc", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resultado get10Porciento(@RequestParam(name = "sueldo") String sueldo, @RequestParam(name = "ahorro") String ahorro){
		
		LOGGER.log(Level.INFO, "<Trabajo DevOps - DXC> <Consultado Diez por ciento>");
		try {
			Dxc calculo = new Dxc(Integer.parseInt(ahorro), Integer.parseInt(sueldo));
			return new Resultado(calculo.getDxc(), true, "OK");
		} catch (Exception e) {
			return new Resultado(0, false,e.getMessage());
		}
	}

	@GetMapping(path = "/saldo", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resultado getSaldo(@RequestParam(name = "ahorro") String ahorro, @RequestParam(name = "retiro") String retiro){
		
		LOGGER.log(Level.INFO, "<Trabajo DevOps - DXC> <Consultado Saldo>");
		try {
			Dxc calculo = new Dxc(Integer.parseInt(retiro), Integer.parseInt(ahorro), false, true);
			return new Resultado(calculo.getSaldo(), true, "OK");
		} catch (Exception e) {
			return new Resultado(0, false,e.getMessage());
		}
	}

	@GetMapping(path = "/impuesto", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resultado getImpuesto(@RequestParam(name = "sueldo") String sueldo, @RequestParam(name = "retiro") String retiro){
		
		LOGGER.log(Level.INFO, "<Trabajo DevOps - DXC> <Consultado Impuesto>");
		try {
			Dxc calculo = new Dxc(Integer.parseInt(retiro), Integer.parseInt(sueldo), true);
			return new Resultado(calculo.getImpuesto(), true, "OK");
		} catch (Exception e) {
			return new Resultado(0, false,e.getMessage());
		}
	}
}