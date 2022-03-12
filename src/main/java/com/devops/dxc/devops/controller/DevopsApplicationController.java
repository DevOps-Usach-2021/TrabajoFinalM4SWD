package com.devops.dxc.devops.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devops.dxc.devops.service.BalanceService;
import com.devops.dxc.devops.service.TaxService;
import com.devops.dxc.devops.service.TenPercentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	@RequestMapping(value = "/calculateTenPercent", method = RequestMethod.POST)
	public void calculateTenPercent(@RequestParam String saldo, @RequestParam String sueldo,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		//calculo 10 por ciento y paso el valor a calculo de saldo restante
		String tenPercent = _tenPercentService.calculateTenPercent(saldo, sueldo);
		//TODO:validar si existe error antes de llamar al balance
		//calculo saldo
		String balance = _balanceService.calculateBalance(tenPercent);
		//TODO:validar si existe error antes de llamar al impuesto
		//calculo impuesto
		String impuesto = _taxService.calculateTax(tenPercent);
		//TODO:validar si existe error antes de llamar a la vista
		
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			tenPercent = gson.toJson(tenPercent);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(tenPercent);

	}

}
