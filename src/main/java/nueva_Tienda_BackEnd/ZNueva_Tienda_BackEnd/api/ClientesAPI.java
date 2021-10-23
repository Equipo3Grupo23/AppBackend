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

import nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.DAO.ClientesDAO;
import nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.model.Clientes;

@RestController
@RequestMapping("clientes")
public class ClientesAPI {
	
	@Autowired
	private ClientesDAO clientesDAO;
	
	@PostMapping("/guardar")
	public void registrarCliente(@RequestBody Clientes clientes) {
		clientesDAO.save(clientes);
	}

	@GetMapping("/listar")
	public ArrayList<Clientes> listar(){
		return (ArrayList<Clientes>) clientesDAO.findAll();		
	}

	@GetMapping("/buscar/{cedula_cliente}")
	public Optional<Clientes> buscar(@PathVariable ("cedula_cliente") long cedula_cliente){
		return clientesDAO.findById(cedula_cliente);	
	}
	
		
	@DeleteMapping("/eliminar/{cedula_cliente}")
	public void eliminarClientes(@PathVariable("cedula_cliente") long cedula_cliente) {
		clientesDAO.deleteById(cedula_cliente);
	}
		
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Clientes clientes) {
		clientesDAO.save(clientes);
	}
	
}



