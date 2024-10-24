package pe.com.cibertec.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.model.entity.DetallePedidoEntity;
import pe.com.cibertec.model.entity.Pedido;
import pe.com.cibertec.model.entity.PedidoEntity;
import pe.com.cibertec.model.entity.ProductoEntity;
import pe.com.cibertec.model.entity.UsuarioEntity;
import pe.com.cibertec.service.PedidoService;

@Controller
@RequiredArgsConstructor
public class PedidoController {
	
	private final PedidoService pedidoService;
	
	@GetMapping("/guardar_factura")
	public String guardarFactura(HttpSession session) {
		String correoUsuario = session.getAttribute("usuario").toString();
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setCorreo(correoUsuario);
		
		//Setear parte del pedido
		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setFechaCompra(LocalDate.now());//obtener fecha actual
		pedidoEntity.setUsuarioEntity(usuarioEntity);
		
		// Formar el detallepedido
		List<DetallePedidoEntity>detallePedidoEntityList = new ArrayList<DetallePedidoEntity>();
		
		List<Pedido>productoSesion = null;
		if(session.getAttribute("carrito") == null) {
			productoSesion = new ArrayList<Pedido>();
		}else {
			productoSesion = (List<Pedido>)session.getAttribute("carrito");
		}
		//cargar detalle pedido entity
		for(Pedido ped: productoSesion) {
			DetallePedidoEntity detallePedidoEntity = new DetallePedidoEntity();
			ProductoEntity productoEntity = new ProductoEntity();
			productoEntity.setProductoId(ped.getProductoId());
			
			detallePedidoEntity.setProductoEntity(productoEntity);
			detallePedidoEntity.setCantidad(ped.getCantidad());
			detallePedidoEntity.setPedidoEntity(pedidoEntity);
			detallePedidoEntityList.add(detallePedidoEntity);
		}
		
		pedidoEntity.setDetallePedido(detallePedidoEntityList);
		pedidoService.crearPedido(pedidoEntity);
		session.removeAttribute("carrito");
		return "redirect:/menu";
		
	}
}
