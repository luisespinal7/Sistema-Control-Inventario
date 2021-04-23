/*
//Spring security requiere una implemetación de la interfaz UserDetails para saber acerca 
//de la autenticación de la información del usuario
package edu.unah.bbddI.user;

import java.util.*;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.unah.bbddI.model.Roles;
import edu.unah.bbddI.model.Usuario;
 
public class MyUserDetails implements UserDetails {
 
    private Usuario usuario;
     
    public MyUserDetails(Usuario usuario) {
        this.usuario = usuario;
    }
 
    //El siguiente método retorna los roles que utiliza Spring security en el proceso de autenticación
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Roles roles = usuario.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
            authorities.add(new SimpleGrantedAuthority(roles.getRole()));
         
        return authorities;
    }
 
    @Override
    public String getPassword() {
        return usuario.getContrasena();
    }
 
    @Override
    public String getUsername() {
        return usuario.getNomUsuario();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return usuario.isEnabled();
    }
 
}
*/