package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.entity.ProductoEntity;

public interface ProductoService {
	List<ProductoEntity> buscarTodosProductos();
    ProductoEntity buscarProductoPorId(Integer id);
	ProductoEntity crear(ProductoEntity producto);
	ProductoEntity actualizar(Integer id, ProductoEntity producto);
	void eliminar(Integer id);

}
