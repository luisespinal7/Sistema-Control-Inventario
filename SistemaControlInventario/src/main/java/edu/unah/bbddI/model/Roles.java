package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class Roles {
	@Id
	private int Id_Roles;
	private String role;
	
	@OneToMany(mappedBy="roles", fetch=FetchType.LAZY)
	private List<Usuario> usuario;
	
	public Roles() {}

	public Roles(int id_Roles, String role, List<Usuario> usuario) {
		super();
		Id_Roles = id_Roles;
		this.role = role;
		this.usuario = usuario;
	}

	public int getId_Roles() {
		return Id_Roles;
	}

	public void setId_Roles(int id_Roles) {
		Id_Roles = id_Roles;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	
}
