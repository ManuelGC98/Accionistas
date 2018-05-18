package com.bbdd.accionistas.modelos;

public class AccionistaModelo {
	
	private long dni;
	private String nombre;
	private String apellidos;

	public AccionistaModelo() {
		this.dni = 0;
		this.nombre = "";
		this.apellidos = "";
	}

	public AccionistaModelo(long dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}