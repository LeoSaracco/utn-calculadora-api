package ar.com.cdt.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.calculadora.service.FuncionesService;

@RestController
@RequestMapping("/api/funciones")
public class FuncionesController {

	@Autowired
	FuncionesService funcionesService;

	// http://localhost:8080/api/funciones/suma/10/5
	@GetMapping("/suma/{val1}/{val2}")
	public String suma(@PathVariable("val1") int val1, @PathVariable("val2") int val2) {
		String msgFinal = "La suma total es: " + funcionesService.suma(val1, val2);
		return msgFinal;
	}
}
