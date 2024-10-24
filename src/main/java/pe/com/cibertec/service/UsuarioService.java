package pe.com.cibertec.service;

import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.model.entity.UsuarioEntity;

public interface UsuarioService {
	void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto);
	boolean validarUsuario(UsuarioEntity usuarioEntity);

}
