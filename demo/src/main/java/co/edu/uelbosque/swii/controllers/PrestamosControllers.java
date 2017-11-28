package co.edu.uelbosque.swii.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uelbosque.swii.entidades.Reporte;
import co.edu.uelbosque.swii.persistencia.IPrestamosPersistence;

@Controller
@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = {"http:\\localhost:4200"})
public class PrestamosControllers {
	
	@Autowired
	private IPrestamosPersistence pp;
	
	// Obtener todos el reporte
	@GetMapping("/all-reporte")
	public ResponseEntity<List<Reporte>> getAllReporte() {
		List<Reporte> list = pp.getReportes();
		return new ResponseEntity<List<Reporte>>(list, HttpStatus.OK);
	}
	
	// Post
	@PostMapping("/reporte")
	public ResponseEntity<Void> prestar(@RequestParam String idSolicitante, @RequestParam String idProducto){
		pp.prestar(Integer.parseInt(idSolicitante), Integer.parseInt(idProducto));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// Put
	@PutMapping("/reporte")
	public ResponseEntity<Void> devolver(@RequestParam String idSolicitante, @RequestParam String idProducto){
		pp.devolver(Integer.parseInt(idSolicitante), Integer.parseInt(idProducto));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
