package co.edu.uelbosque.swii.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uelbosque.swii.persistencia.PrestadoPersistense;

@RestController
public class PrestadoController {

	@Autowired
	PrestadoPersistense pp;
}
