package ar.gaston.hibernate.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name =  "DIRECCION")
public class Direccion {

	@Id
	@Column(name = "ID_DIRECCION")
	private Long id;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "LOCALIDAD")
	private String localidad;
	
	@Column(name = "PROVINCIA")
	private String provincia;
	
	@Column(name = "PAIS")
	private String pais;

	@OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})//Para que sea bidireccional, "direccion" es el atributo de la CLASE Empleado
	@JoinColumn(name = "ID_EMPLEADO")
	Empleado empleado;										//LAZY es para que no busque el empleado hasta que no se pida
	
	public Direccion() {
		
	}

	public Direccion(Long id, String direccion, String localidad, String provincia, String pais) {
		this.id = id;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia="
				+ provincia + ", pais=" + pais + ", empleado="+ empleado.getCodigo() +"]";
	}
	
	
	
}
