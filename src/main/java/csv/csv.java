package csv;


import com.csvreader.CsvReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class csv {

   
    public static void main(String[] args) {
        List<Productos> productos = new ArrayList<Productos>();
        
        productos = importarCSV();
        
        insertarMySQL(productos);
    }
    
    public static List<Productos> importarCSV() {
        List<Productos> productos = new ArrayList<Productos>();
        
        try {
            CsvReader leerProductos = new CsvReader("productos.csv");
            leerProductos.readHeaders();
            
            while(leerProductos.readRecord()) {
            	String código_producto = leerProductos.get(0);
                String nombre_producto = leerProductos.get(1);
                String nitproveedor = leerProductos.get(2);
                String precio_compra = leerProductos.get(3);
                String ivacompra = leerProductos.get(4);
                String precio_venta = leerProductos.get(5);
                
                productos.add(new Productos(código_producto, nombre_producto, nitproveedor, precio_compra, ivacompra, precio_venta));
            }
            
            leerProductos.close();
            
            System.out.println("LISTA DE USUARIOS DEL CSV\n");
            for(Productos user : productos) {
                System.out.println(
                        user.getCódigo_producto()+", "+
                        user.getNombre_producto()+", "+
                        user.getNitproveedor()+", "+
                        user.getIvacompra()+", "+
                        user.getIvacompra()+", "+
                        user.getPrecio_compra()
                );
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return productos;
        
    }
    
    public static void insertarMySQL(List<Productos> productos) {
      
        
        ConexionMySQL sql = new ConexionMySQL();
        Connection con = sql.conectarMySQL();
        
        String query = "INSERT INTO usuarios(código_producto, nombre_producto, nitproveedor, precio_compra, ivacompra, precio_venta) VALUES(?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            
            for(int i = 0 ; i < productos.size() ; i++) {
                ps.setString(1, productos.get(i).getCódigo_producto());
                ps.setString(2, productos.get(i).getNombre_producto());
                ps.setString(3, productos.get(i).getNitproveedor());
                ps.setString(4, productos.get(i).getPrecio_compra());
                ps.setString(5, productos.get(i).getIvacompra());
                ps.setString(6, productos.get(i).getPrecio_compra());
                ps.executeUpdate();
                
              
            }
            
            ps.close();
            con.close();
        } catch(SQLException e) {
            
        }
    }
}