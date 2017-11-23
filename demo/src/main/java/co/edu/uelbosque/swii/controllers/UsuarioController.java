package co.edu.uelbosque.swii.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uelbosque.swii.entidades.Users;
import co.edu.uelbosque.swii.persistencia.UsuariosPersistence;

@RestController
public class UsuarioController {

	UsuariosPersistence up;
	
	@RequestMapping(value="/login/user", method=RequestMethod.GET)
	public ResponseEntity<Users> getUsers(@RequestParam String usr){
		Users usuario = up.findOne(usr);
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(usuario);
	}
}
