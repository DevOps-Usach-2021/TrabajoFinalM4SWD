package com.devops.dxc.devops.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devops.dxc.devops.model.Resultado;
import com.devops.dxc.devops.service.BalanceService;
import com.devops.dxc.devops.service.TaxService;
import com.devops.dxc.devops.service.TenPercentService;

@Controller
public class DevopsApplicationController {
	
	@Autowired
	TenPercentService _tenPercentService;
	
	@Autowired
	BalanceService _balanceService;
	
	@Autowired
	TaxService _taxService;
	
	@GetMapping("/")
	public String index(Model model) throws IOException {
		return "form";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/calculateTenPercent", method = RequestMethod.POST)
	public void calculateTenPercent(@RequestParam String saldo, @RequestParam String sueldo,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		JSONObject json = new JSONObject();
		
		//calculo 10 por ciento y paso el valor de resultado a calculo de saldo restante
		Resultado tenPercent = _tenPercentService.calculateTenPercent(saldo, sueldo);
		if(!tenPercent.getValido()){
			try {
				json.put("hasError", "true");
				json.put("msgError", tenPercent.getMensaje());
			}catch(Exception e) {
				System.out.println(e);
			}		
			out.print(json);
			return;
		}
		//calculo saldo
		Resultado balance = _balanceService.calculateBalance(saldo, 
				String.valueOf(tenPercent.getValor()));
		if(!balance.getValido()){
			try {
				json.put("hasError", "true");
				json.put("msgError", tenPercent.getMensaje());
			}catch(Exception e) {
				System.out.println(e);
			}		
			out.print(json);
			return;
		}
		//calculo impuesto
		Resultado tax = _taxService.calculateTax(sueldo, 
				String.valueOf(tenPercent.getValor()));
		if(!tax.getValido()){
			try {
				json.put("hasError", "true");
				json.put("msgError", tenPercent.getMensaje());
			}catch(Exception e) {
				System.out.println(e);
			}		
			out.print(json);
			return;
		}
		
		json.put("hasError", "false");
		json.put("tenPercent", tenPercent.getValor());
		json.put("balance", balance.getValor());
		json.put("tax", tax.getValor());
		
		out.print(json);
		
	}

}
