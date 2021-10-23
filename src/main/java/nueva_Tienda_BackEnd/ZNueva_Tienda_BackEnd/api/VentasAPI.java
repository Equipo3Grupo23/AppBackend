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

import nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.DAO.VentasDAO;
import nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.model.Ventas;

@RestController
@RequestMapping("ventas")
public class VentasAPI {
	
	@Autowired
	private VentasDAO ventasDAO;
	
	@PostMapping("/guardar")
	public void registrarVentas(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
	}

	@GetMapping("/listar")
	public ArrayList<Ventas> listar(){
		return (ArrayList<Ventas>) ventasDAO.findAll();		
	}

	@GetMapping("/buscar/{codigo_venta}")
	public Optional<Ventas> buscar(@PathVariable ("codigo_venta") long codigo_venta){
		return ventasDAO.findById(codigo_venta);	
	}
	
		
	@DeleteMapping("/eliminar/{codigo_venta}")
	public void eliminarVentas(@PathVariable("codigo_venta") long codigo_venta) {
		ventasDAO.deleteById(codigo_venta);
	}
		
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
	}
	
	

}



