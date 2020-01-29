package com.david.muroMensajes.datos.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RutasUsuarios {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	@GetMapping("/usuarios")
	public ModelAndView todosLosUsuarios() {
				
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuarios");
		mav.addObject("usuario", new Usuario());
		
		List<Usuario> listaUsuario = (List<Usuario>) usuarioDAO.findAll();
		mav.addObject("usuarios", listaUsuario);
		
		return mav;
	}
	
	@PostMapping("/usuarios/aniadir")
	public String usuarioAniadir(@ModelAttribute Usuario usuario) {
		
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuarioDAO.save(usuario);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/borrar/{nombreUsuario}")
	public String usuarioBorrar(@PathVariable String nombreUsuario) {
		
		// Version 1
		// Usuario usuario = usuarioDAO.findById(nombreUsuario).get();
		// usuarioDAO.delete(usuario);
		
		// Version 2
		usuarioDAO.deleteById(nombreUsuario);
		
		return "redirect:/usuarios";
	}
}
