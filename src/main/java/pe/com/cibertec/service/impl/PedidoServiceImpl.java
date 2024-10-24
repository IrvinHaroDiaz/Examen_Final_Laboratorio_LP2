package pe.com.cibertec.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.model.entity.PedidoEntity;
import pe.com.cibertec.repository.PedidoRepository;
import pe.com.cibertec.service.PedidoService;


@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService{

	private final PedidoRepository pedidoRepository;
	
	@Override
	public void crearPedido(PedidoEntity pedidoEntity) {
		// TODO Auto-generated method stub
		pedidoRepository.save(pedidoEntity);
		
	}

}