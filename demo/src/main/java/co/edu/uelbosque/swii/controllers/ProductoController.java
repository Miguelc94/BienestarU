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

import co.edu.uelbosque.swii.entidades.Producto;
import co.edu.uelbosque.swii.persistencia.IProductoPersistence;

@Controller
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ProductoController {

	@Autowired
	private IProductoPersistence pp;

	// Get productos disponibles
	@GetMapping("/disp-productos")
	public ResponseEntity<List<Producto>> productosDisponibles() {
		List<Producto> list = pp.productosDisponibles();
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}
	
	// Get productos prestados
	@GetMapping("/pres-productos")
	public ResponseEntity<List<Producto>> productosPrestados() {
		List<Producto> list = pp.productosPrestados();
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}
	
	// Get a Single Producto
	@GetMapping("/productos")
	public ResponseEntity<Producto> getProductoById(@RequestParam("id") String id) {
		Producto producto = pp.getProductoById(Integer.parseInt(id));
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	// GET all Productos
	@GetMapping("/all-productos")
	public ResponseEntity<List<Producto>> getAllProductos() {
		List<Producto> list = pp.getProductos();
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}

	// POST para crear
	@PostMapping("/productos")
	public ResponseEntity<Void> createProducto(@RequestBody Producto producto, UriComponentsBuilder builder) {
		boolean flag = pp.createProducto(producto);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/productos?id={id}").buildAndExpand(producto.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Update
	@PutMapping("/productos")
	public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
		pp.updateProducto(producto);
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	// Delete
	@DeleteMapping("/productos")
	public ResponseEntity<Void> deleteProducto(@RequestParam("id") String id) {
		pp.deleteProducto(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
