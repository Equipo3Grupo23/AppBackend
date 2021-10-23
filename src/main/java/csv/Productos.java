package csv;


public class Productos {
	
	private String código_producto;
	
	private String nombre_producto;
	
	private String nitproveedor;
	
	private String precio_compra;
	
	private String ivacompra;
	
	private String precio_venta;

	
	public Productos(String código_producto2, String nombre_producto, String nitproveedor2, String precio_compra2, String ivacompra2, String precio_venta2) {
		super();
		this.código_producto = código_producto2;
		this.nombre_producto = nombre_producto;
		this.nitproveedor = nitproveedor2;
		this.precio_compra = precio_compra2;
		this.ivacompra = ivacompra2;
		this.precio_venta = precio_venta2;
	}



	
	public String getCódigo_producto() {
		return código_producto;
	}




	public void setCódigo_producto(String código_producto) {
		this.código_producto = código_producto;
	}




	public String getNombre_producto() {
		return nombre_producto;
	}




	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}




	public String getNitproveedor() {
		return nitproveedor;
	}




	public void setNitproveedor(String nitproveedor) {
		this.nitproveedor = nitproveedor;
	}




	public String getPrecio_compra() {
		return precio_compra;
	}




	public void setPrecio_compra(String precio_compra) {
		this.precio_compra = precio_compra;
	}




	public String getIvacompra() {
		return ivacompra;
	}




	public void setIvacompra(String ivacompra) {
		this.ivacompra = ivacompra;
	}




	public String getPrecio_venta() {
		return precio_venta;
	}




	public void setPrecio_venta(String precio_venta) {
		this.precio_venta = precio_venta;
	}




	@Override
	public String toString() {
		return "Producto [código_producto=" + código_producto + ", nombre_producto=" + nombre_producto + ", nitproveedor=" + nitproveedor + ", precio_compra=" + precio_compra + ", ivacompra=" + ivacompra + ",precio_venta=" + precio_venta +"]";
	}
	
	


    
}