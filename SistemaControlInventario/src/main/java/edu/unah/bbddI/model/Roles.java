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
	private int Id_Role;
	private String role;
	
	@OneToMany(mappedBy="roles", fetch=FetchType.LAZY)
	private List<Usuario> usuario;
	
	public Roles() {}

	public Roles(int id_Role, String role, List<Usuario> usuario) {
		super();
		Id_Role = id_Role;
		this.role = role;
		this.usuario = usuario;
	}

	public int getId_Role() {
		return Id_Role;
	}

	public void setId_Roles(int id_Role) {
		Id_Role = id_Role;
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
