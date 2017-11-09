package co.edu.uelbosque.swii.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uelbosque.swii.entidades.Producto;
import co.edu.uelbosque.swii.persistencia.ProductoPersistence;

@RestController
public class ProductoController {
	
	@Autowired
	ProductoPersistence pp;
	
	//GET all Productos
	@RequestMapping(value="/productos", method=RequestMethod.GET)
	public List<Producto> getAllProductos() {
		return pp.findAll();
	}
	
	//POST para crear
	@RequestMapping(value="/producto/add", method=RequestMethod.POST)
	public Producto addProducto(@RequestParam String producto, @RequestParam Long categoria) {
		return pp.save(new Producto(producto, categoria));
	}
	
	//Get a Single Producto
	@RequestMapping(value="/producto/{id}", method=RequestMethod.GET)
	public ResponseEntity<Producto> getProductoById(@RequestParam Long id){
		Producto producto = pp.findOne(id);
		if(producto == null) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(producto);
	}
	
	//Update
	@RequestMapping(value="/producto/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Producto> updateProducto(@RequestParam Producto producto) {
		Producto p = pp.findOne(producto.getId());
		if(p == null) {
			return ResponseEntity.notFound().build();
		}
		p.setNombre(producto.getNombre());
		Producto updateProducto = pp.save(p);
		return ResponseEntity.ok(updateProducto);
	}
	
	//Delete
	@RequestMapping(value="/producto/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Producto> deleteProducto(@RequestParam Long id) {
		Producto producto = pp.findOne(id);
		if(producto == null) {
			return ResponseEntity.notFound().build();
		}
		pp.delete(producto);
		return ResponseEntity.ok().build();
	}
	
}
