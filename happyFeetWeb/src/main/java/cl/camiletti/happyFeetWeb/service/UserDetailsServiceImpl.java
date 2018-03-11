package cl.camiletti.happyFeetWeb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


import cl.camiletti.happyFeetWeb.model.Usuario;
import cl.camiletti.happyFeetWeb.repository.UsuarioRepository;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService{
	 @Autowired
	    private UsuarioRepository userRepository;

	    @Override
	    @Transactional(readOnly = true)
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Usuario user = userRepository.findByEmail(email);
	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        grantedAuthorities.add(new SimpleGrantedAuthority(user.getParamTipoUsuario().getValor()));     

	        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
	    }
}
