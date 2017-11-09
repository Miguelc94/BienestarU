package co.edu.uelbosque.swii.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uelbosque.swii.entidades.Categoria;
import co.edu.uelbosque.swii.persistencia.CategoriaPersistense;

@RestController
@RequestMapping("/api")
public class CategoriaController {

	@Autowired
	CategoriaPersistense cp;
	
	//GET all Categorias
	@RequestMapping(value="/categorias", method=RequestMethod.GET)
	public List<Categoria> getAllCategorias() {
		return cp.findAll();
	}
	
	//create a new Categoria
	@RequestMapping(value="/categoria/add", method=RequestMethod.POST)
	public Categoria createCategoria(@RequestParam String categoria) {
		return cp.save(new Categoria(categoria));
	}
	
	//GET a Single Categoria
	@RequestMapping(value="/categoria/single", method=RequestMethod.GET)
	public ResponseEntity<Categoria> getCategoriaById(@RequestParam Long id){
		Categoria categoria = cp.findOne(id);
		if(categoria == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(categoria);
	}
	
	//Update a Categoria
	@PutMapping("/categoria/{id}")
	public ResponseEntity<Categoria> updateCategoria(@PathVariable(value="id") Long id,
			@Valid @RequestBody Categoria categoria) {
		Categoria c = cp.findOne(id);
		if(c == null) {
			return ResponseEntity.notFound().build();
		}
		c.setNombre(categoria.getNombre());
		
		Categoria updateCategoria = cp.save(c);
		return ResponseEntity.ok(updateCategoria);
	}
	
	//Delete a Categoria
	@RequestMapping(value="/categoria/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Categoria> deleteCategoria(@RequestParam Long id) {
		Categoria categoria = cp.findOne(id);
		if(categoria == null) {
			return ResponseEntity.notFound().build();
		}		
		cp.delete(categoria);
		return ResponseEntity.ok().build();
	}
}

