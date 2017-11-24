package co.edu.uelbosque.swii.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import co.edu.uelbosque.swii.entidades.Categoria;
import co.edu.uelbosque.swii.persistencia.ICategoriaPersistense;

@Controller
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class CategoriaController {

	@Autowired
	private ICategoriaPersistense cp;

	// Obtener una sola categoria
	@GetMapping("/categorias/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@RequestParam("id") String id) {
		Categoria categoria = cp.getCategoriaById(Integer.parseInt(id));
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}

	// Obterner todas las categorias
	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> getAllCategoria() {
		List<Categoria> list = cp.getCategorias();
		return new ResponseEntity<List<Categoria>>(list, HttpStatus.OK);
	}

	// Crear una nueva categoria
	@PostMapping("/categorias")
	public ResponseEntity<Void> createCategoria(@RequestBody Categoria categoria, UriComponentsBuilder builder) {
		boolean flag = cp.createCategoria(categoria);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/categoria?id={id}").buildAndExpand(categoria.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Actualizar una categoria
	@PutMapping("/categorias")
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria) {
		cp.updateCategoria(categoria);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}

	// Borrar una categoria
	@DeleteMapping("/categorias")
	public ResponseEntity<Void> deleteCategoria(@RequestParam("id") String id) {
		cp.deleteCategoria(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
