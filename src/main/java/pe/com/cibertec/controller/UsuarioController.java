package pe.com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.model.entity.UsuarioEntity;
import pe.com.cibertec.service.UsuarioService;

@Controller
@RequiredArgsConstructor
public class UsuarioController {
    
    private final UsuarioService usuarioService;
    
    @GetMapping("registrar_usuario")
    public String mostrarRegistrarUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "registrar_usuario";
    }

    @PostMapping("registrar_usuario")
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioEntity usuarioFormulario,
           Model model, @RequestParam("foto") MultipartFile foto) {
    	
    	usuarioService.crearUsuario(usuarioFormulario, foto);
    	return "registrar_usuario";
    }
}
