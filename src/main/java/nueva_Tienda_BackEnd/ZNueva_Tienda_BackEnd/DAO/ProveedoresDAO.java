package nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nueva_Tienda_BackEnd.ZNueva_Tienda_BackEnd.model.Proveedores;

@Repository
public interface ProveedoresDAO extends JpaRepository<Proveedores, Long>{
	

	
	
}