package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SEXO")
public class Sexo {
	@Id
	private int Id_Sexo;
	private String sexo;
	
	@OneToMany(mappedBy="sexo", fetch=FetchType.LAZY)
	private List<Empleado> empleado;
	
	public Sexo() {}

	public Sexo(int id_Sexo, String sexo) {
		super();
		Id_Sexo = id_Sexo;
		this.sexo = sexo;
	}

	public int getId_Sexo() {
		return Id_Sexo;
	}

	public void setId_Sexo(int id_Sexo) {
		Id_Sexo = id_Sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	

}
