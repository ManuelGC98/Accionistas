package com.bbdd.accionistas.modelos;

/**
 * Cada objeto de esta clase permite representar una fila de la tabla EMPRESAS
 * 
 * @author antonio
 *
 */
public class EmpresaModelo {

	// Código de empresa (IDE)
	private long ide;
	// Nombre de la empresa
	private String nombre;
	// Cuantía que factura la empresa
	private float factura;
	// Código de actividad
	private long ida;

	/**
	 * Constructor por defecto.
	 * 
	 */
	public EmpresaModelo() {
		this.ide = 0;
		this.nombre = "";
		this.factura = 0;
		this.ida = 0;
	}

	/**
	 * Constructor específico
	 * 
	 * @param ide
	 *            el código de empresa.
	 * @param nombre
	 *            el nombre de la empresa.
	 * @param factura
	 *            la cuantía que factura la empresa.
	 * @param ida
	 *            el código de la actividad.
	 */
	public EmpresaModelo(long ide, String nombre, float factura, long ida) {
		this.ide = ide;
		this.nombre = nombre;
		this.factura = factura;
		this.ida = ida;
	}

	/**
	 * Obtener la clave primaria de EMPRESA
	 * 
	 * @return el código de empresa (IDE)
	 */
	public long getIde() {
		return ide;
	}

	/**
	 * Asignar la clave primaria de EMPRESA
	 * 
	 * @param ide
	 *            el código de empresa (IDE)
	 */
	public void setIde(long ide) {
		this.ide = ide;
	}

	/**
	 * Obtener el nombre de la empresa
	 * 
	 * @return el nombre de la empresa
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asignar el nombre de la empresa
	 * 
	 * @param nombre
	 *            el nombre de la empresa
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtener la cuantía que factura la empresa
	 * 
	 * @return la cuantía que factura la empresa
	 */
	public float getFactura() {
		return factura;
	}

	/**
	 * Asignar la cuantía que factura la empresa
	 * 
	 * @param factura
	 *            la cuantía que factura la empresa
	 */
	public void setFactura(float factura) {
		this.factura = factura;
	}

	/**
	 * Devuelve el código de actividad
	 * 
	 * @return el código de actividad
	 */
	public long getIda() {
		return ida;
	}

	/**
	 * Asignar el código del actividad
	 * 
	 * @param ida
	 *            el código de actividad
	 */
	public void setIda(long ida) {
		this.ida = ida;
	}

}
