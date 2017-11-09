package co.edu.uelbosque.swii.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uelbosque.swii.persistencia.DisponiblePersistense;

@RestController
public class DisponibleController {

	@Autowired
	DisponiblePersistense dp;
	
}
