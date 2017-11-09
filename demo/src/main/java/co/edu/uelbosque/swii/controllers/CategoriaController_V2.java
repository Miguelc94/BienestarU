package co.edu.uelbosque.swii.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uelbosque.swii.entidades.Categoria;
import co.edu.uelbosque.swii.persistencia.CategoriaPersistense;

@RestController
@RequestMapping("/api")
public class CategoriaController_V2 {

	@Autowired
	CategoriaPersistense cp;
	
	//Obterner todas las categorias
	@GetMapping("/categorias")
	public List<Categoria> getAllCategoria() {
		return cp.findAll();
	}
	
	//Crear una nueva categoria
	@PostMapping("/categorias")
	public Categoria createCategoria(@Valid @RequestBody Categoria categoria) {
		return cp.save(categoria);
	}
	
	//Obtener una sola categoria
	@GetMapping("/categorias/{i}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable(value="id") Long catId) {
		Categoria categoria = cp.findOne(catId);
		if(categoria == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(categoria);
	}
	
	//Actualizar una categoria
	@PutMapping("/categoria/{id}")
	public ResponseEntity<Categoria> updateCategoria(@PathVariable(value="id") Long catId,
													 @Valid @RequestBody Categoria catDetalles) {
		Categoria categoria = cp.findOne(catId);
		if(categoria == null) {
			return ResponseEntity.notFound().build();
		}
		categoria.setNombre(catDetalles.getNombre());
		
		Categoria updateCat = cp.save(categoria);
		return ResponseEntity.ok(updateCat);
	}
	
	//Borrar una categoria
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<Categoria> deleteCategoria(@PathVariable(value="id") Long catId) {
		Categoria categoria = cp.findOne(catId);
		if(categoria == null) {
			return ResponseEntity.notFound().build();
		}
		
		cp.delete(categoria);
		return ResponseEntity.ok().build();
	}	
}
