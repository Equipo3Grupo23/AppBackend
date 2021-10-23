package nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.api;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.DAO.ProveedoresDAO;
import nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.model.Proveedores;

@RestController
@RequestMapping("proveedores")
public class ProveedoresAPI {
	
	@Autowired
	private ProveedoresDAO proveedoresDAO;
	
	@PostMapping("/guardar")
	public void registrarProveedor(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);
	}

	@GetMapping("/listar")
	public ArrayList<Proveedores> listar(){
		return (ArrayList<Proveedores>) proveedoresDAO.findAll();		
	}

	@GetMapping("/buscar/{nit_proveedor}")
	public Optional<Proveedores> buscar(@PathVariable ("nit_proveedor") long nit_proveedor){
		return proveedoresDAO.findById(nit_proveedor);	
	}
	
	@DeleteMapping("/eliminar/{nit_proveedor}")
	public void eliminarProveedores(@PathVariable("nit_proveedor") long nit_proveedor) {
		proveedoresDAO.deleteById(nit_proveedor);
	}
		
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);
	}
}



