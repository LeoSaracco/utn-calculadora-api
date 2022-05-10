package ar.com.cdt.calculadora.service.impl;

import org.springframework.stereotype.Service;

import ar.com.cdt.calculadora.service.FuncionesService;

@Service
public class FuncionesServiceImpl implements FuncionesService {

	public int suma(int val1, int val2) {
		return val1 + val2;
	}
}