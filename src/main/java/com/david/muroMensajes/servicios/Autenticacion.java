package com.david.muroMensajes.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.david.muroMensajes.datos.usuarios.Usuario;
import com.david.muroMensajes.datos.usuarios.UsuarioDAO;

@Service
public class Autenticacion implements UserDetailsService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> user = usuarioDAO.findById(username);
		if(usuarioDAO.findById(username).isPresent()) {

			return user.get();
		}
		else throw new UsernameNotFoundException(""+username);
	}	
}
