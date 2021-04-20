package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="USUARIO")
public class Usuario {
	@Id
	private int Id_Usuario;
	private String nomUsuario;
	private String contrasena;
	private int enabled;
	
	@ManyToOne
	@JoinColumn(name="Id_Role")
	@JsonBackReference
	private Roles roles;
	
	public Usuario() {}

	public Usuario(int id_Usuario, String nomUsuario, String contrasena, int enabled, Roles roles) {
		super();
		Id_Usuario = id_Usuario;
		this.nomUsuario = nomUsuario;
		this.contrasena = contrasena;
		this.enabled = enabled;
		this.roles = roles;
	}

	public int getId_Usuario() {
		return Id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		Id_Usuario = id_Usuario;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getEnabled() {
		return enabled;
	}
	
	public boolean isEnabled() {
		if(enabled==0) {
			return false;
		}else {
			return true;
		}
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	
	
}
