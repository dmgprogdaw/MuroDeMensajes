package com.david.muroMensajes.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.david.muroMensajes.datos.usuarios.UsuarioDAO;

@Service
public class Autenticacion implements UserDetailsService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return usuarioDAO.findById(username).get();
	}
	
}
