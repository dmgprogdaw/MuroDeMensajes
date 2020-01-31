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

import com.david.muroMensajes.datos.roles.Roles;
import com.david.muroMensajes.datos.roles.RolesDAO;

@Controller
public class RutasUsuarios {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private RolesDAO rolesDAO;
	
	
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
	
	
	@GetMapping("/usuarios/editarUsuario")
	public String editarAutor(@PathVariable String nombreUsuario, @ModelAttribute Usuario usuario) {
			
		ListaUsuarios lista = ListaUsuarios.getLista();
		Usuario user = lista.getUsuario(nombreUsuario);
		usuarioDAO.save(usuario);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/{nombreUsuario}")
	public ModelAndView verUsuario(@PathVariable String nombreUsuario) {
		
		ModelAndView mav = new ModelAndView();
		
		if (!(usuarioDAO.findById(nombreUsuario) != null)) {
			
			mav.setViewName(nombreUsuario);
			mav.addObject("usuarios", nombreUsuario);
		}
		return mav;
			
	}
	
	@PostMapping("/usuarios/roles")
	public String usuarioAniadirRoles(@ModelAttribute Roles rol) {
		
		
		rolesDAO.save(rol);
		
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
