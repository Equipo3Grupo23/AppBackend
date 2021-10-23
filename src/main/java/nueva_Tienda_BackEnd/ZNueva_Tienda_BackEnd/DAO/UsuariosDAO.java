package nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.model.Usuarios;

@Repository
public interface UsuariosDAO extends JpaRepository<Usuarios, Long>{
	
	ArrayList<Usuarios> findByUsuarioAndPassword(String Usuario, String password);
	
}