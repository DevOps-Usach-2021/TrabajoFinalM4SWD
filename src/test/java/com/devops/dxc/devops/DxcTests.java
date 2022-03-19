package com.devops.dxc.devops;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.Uf;
import com.devops.dxc.devops.model.Util;

import org.mockito.MockedStatic;
import org.mockito.Mockito;

class DxcTests {

	@Test
	void getSaldoTest() throws Exception {
		int ahorro = 5000000;
		int retiro = 1000000;

		Dxc dxc = new Dxc(retiro, ahorro, false, true);

		assertEquals(4000000, dxc.getSaldo());		
	}

	@Test
	void getInvalidSaldoTest() {
		
		int ahorro = 999999;
		int retiro = 1000000;

		Dxc dxc = new Dxc(retiro, ahorro, false, true);
		
		Assertions.assertThrows(Exception.class, () -> dxc.getSaldo());
	}

	@Test
	void getSinImpuestoTest() {
		int sueldo = 1000000;
		int retiro = 1000000;

		Dxc dxc = new Dxc(retiro, sueldo, true);

		assertEquals(0, dxc.getImpuesto());
	}

	@Test
	void getImpuestoSueldoAltoTest() {
		int sueldo = 2000000;
		int retiro = 1000000;

		Dxc dxc = new Dxc(retiro, sueldo, true);
		
		assertEquals(94532, dxc.getImpuesto());

		retiro = 2000000;
		dxc = new Dxc(retiro, sueldo, true);
		assertEquals(174532, dxc.getImpuesto());

		retiro = 3000000;
		dxc = new Dxc(retiro, sueldo, true);
		assertEquals(254532, dxc.getImpuesto());

		retiro = 4000000;
		dxc = new Dxc(retiro, sueldo, true);
		assertEquals(358532, dxc.getImpuesto());
	}

	@Test
	void getImpuestoSueldoPoliticoTest() {
		int sueldo = 4000000;
		int retiro = 4500000;

		Dxc dxc = new Dxc(retiro, sueldo, true);
		
		assertEquals(656253, dxc.getImpuesto());

		sueldo = 5000000;
		dxc = new Dxc(retiro, sueldo, true);
		assertEquals(1607520, dxc.getImpuesto());

		sueldo = 6000000;
		dxc = new Dxc(retiro, sueldo, true);
		assertEquals(1830292, dxc.getImpuesto());
	}

	@Test
	void getDxcTest() {
		
		try (MockedStatic<Uf> utilities = Mockito.mockStatic(Uf.class)) {
			utilities.when(Uf::getUf).thenReturn(30000);
			
			int ahorro = 50000000;
			int sueldo = 1000000;
	
			Dxc dxc = new Dxc(ahorro, sueldo);
			
			assertEquals(30000, Uf.getUf());			
			assertEquals(4500000, dxc.getDxc());
		}

		// assertEquals(4500000, dxc.getDxc());
	}

}
