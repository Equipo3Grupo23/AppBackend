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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.DAO.UsuariosDAO;
import nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.model.Usuarios;

@RestController
@RequestMapping("usuarios")
public class UsuariosAPI {
	
	@Autowired
	private UsuariosDAO usuariosDAO;
	
	@PostMapping("/guardar")
	public void registrarUsuario(@RequestBody Usuarios usuarios) {
		usuariosDAO.save(usuarios);
	}

	@GetMapping("/listar")
	public ArrayList<Usuarios> listar(){
		return (ArrayList<Usuarios>) usuariosDAO.findAll();		
	}

	@GetMapping("/buscar/{cedula_usuario}")
	public Optional<Usuarios> buscar(@PathVariable ("cedula_usuario") long cedula_usuario){
		return usuariosDAO.findById(cedula_usuario);	
	}
	
		
	@DeleteMapping("/eliminar/{cedula_usuario}")
	public void eliminarUsuarios(@PathVariable("cedula_usuario") long cedula_usuario) {
		usuariosDAO.deleteById(cedula_usuario);
	}
		
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Usuarios usuarios) {
		usuariosDAO.save(usuarios);
	}
	
	@GetMapping("/auth")
	public ArrayList<Usuarios> auth(@RequestParam String usuario, 
			@RequestParam String password){
		return (ArrayList<Usuarios>) usuariosDAO.findByUsuarioAndPassword(usuario, password);
	}
	
	

}



