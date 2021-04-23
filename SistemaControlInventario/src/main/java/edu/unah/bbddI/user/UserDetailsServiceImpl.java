/*
//Se necesita implementar la interfaz UserDetailsService definido por el Spring security como parte del proceso de autenticación
package edu.unah.bbddI.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

import edu.unah.bbddI.model.Usuario;
import edu.unah.bbddI.repository.RepositoryUsuario;
 
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private RepositoryUsuario repositoryUsuario;
     
    //El siguiente método será invocado por Spring security durante el proceso de autenticación
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario usuario = repositoryUsuario.getUserByUsername(username);
         
        if (usuario == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(usuario);
    }
 
}
*/