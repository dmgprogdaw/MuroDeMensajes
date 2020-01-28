package com.david.muroMensajes.datos.mensajes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RutasMensajes {

	@Autowired
	private MensajeDAO mensajeDAO;
	
	@GetMapping("/mensajes")
	public ModelAndView todosLosMensajes() {
				
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mensajes");
		mav.addObject("mensaje", new Mensaje());
		
		List<Mensaje> listaMensajes = (List<Mensaje>) mensajeDAO.findAll();
		mav.addObject("mensajes", listaMensajes);
		
		return mav;
	}
	
	@PostMapping("/mensajes/aniadir")
	public String mensajeAniadir(@ModelAttribute Mensaje mensaje) {
		
		mensajeDAO.save(mensaje);
		
		return "redirect:/mensajes";
	}
	
	@GetMapping("/mensajes/borrar/{id}")
	public String mensajeBorrar(@PathVariable long id) {
		
		// Version 1
		// Mensaje mensaje = mensajeDAO.findById(id).get();
		// mensajeDAO.delete(mensaje);
		
		// Version 2
		mensajeDAO.deleteById(id);
		
		return "redirect:/mensajes";
	}
}
