package pe.com.cibertec.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.model.entity.ProductoEntity;
import pe.com.cibertec.repository.ProductoRepository;
import pe.com.cibertec.service.ProductoService;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
	
	private final ProductoRepository productoRepository;

	@Override
	public List<ProductoEntity> buscarTodosProductos() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public ProductoEntity buscarProductoPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<ProductoEntity> producto = productoRepository.findById(id);
		return producto.orElseThrow(() -> new RuntimeException("Producto no encontrado"));
	}

	@Override
	public ProductoEntity crear(ProductoEntity producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public ProductoEntity actualizar(Integer id, ProductoEntity producto) {
		// TODO Auto-generated method stub
		if (!productoRepository.existsById(id)) {
			throw new RuntimeException("Producto no encontrado");
		}
		producto.setProductoId(id); // Asegúrate de que el ID esté establecido
		return productoRepository.save(producto);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		if (!productoRepository.existsById(id)) {
			throw new RuntimeException("Producto no encontrado");
		}
		productoRepository.deleteById(id);
	}
}