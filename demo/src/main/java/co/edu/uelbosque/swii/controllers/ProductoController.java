package co.edu.uelbosque.swii.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uelbosque.swii.entidades.Producto;
import co.edu.uelbosque.swii.persistencia.ProductoPersistence;

@Controller
@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	ProductoPersistence pp;
	
	//GET all Productos
	@GetMapping("/productos")
	public List<Producto> getAllProductos() {
		return pp.findAll();
	}
	
	//POST para crear
	@PostMapping("/productos/add")
	public Producto addProducto(@Valid @RequestBody Producto producto) {
		return pp.save(producto);
	}
	
	//Get a Single Producto
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable(value="id") Long id){
		Producto producto = pp.findOne(id);
		if(producto == null) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(producto);
	}
	
	//Update
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable(value="id") Long codPro,
												   @Valid @RequestBody Producto producto) {
		Producto p = pp.findOne(codPro);
		if(p == null) {
			return ResponseEntity.notFound().build();
		}
		p.setNombre(producto.getNombre());
		
		Producto updateProducto = pp.save(p);
		return ResponseEntity.ok(updateProducto);
	}
	
	//Delete
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<Producto> deleteProducto(@PathVariable Long id) {
		Producto producto = pp.findOne(id);
		if(producto == null) {
			return ResponseEntity.notFound().build();
		}
		
		pp.delete(producto);
		return ResponseEntity.ok().build();
	}
	
}
