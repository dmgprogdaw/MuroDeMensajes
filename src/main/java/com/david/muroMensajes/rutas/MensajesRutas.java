package com.david.muroMensajes.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MensajesRutas {

	@GetMapping("/")
	public String principal() {
				
		
		return "index";
	}
}
