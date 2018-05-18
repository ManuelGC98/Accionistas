package com.bbdd.accionistas;

import com.bbdd.accionistas.mappers.AccionistasMapper;
import com.bbdd.accionistas.mappers.EmpresasMapper;
import com.bbdd.accionistas.modelos.AccionistaModelo;
import com.bbdd.accionistas.modelos.EmpresaModelo;
import java.util.List;

/**
 * Aplicación simple para acceder a ORACLE utilizando MyBatis
 *
 * @author antonio
 *
 */
public class App {

	/**
	 * Método para hacer algunas pruebas con empresas
	 */
	private static void trastearConEmpresas() {
		// Obtenermos la lista de todas las empresas
		EmpresasMapper empresaMapper = new EmpresasMapper();
		List<EmpresaModelo> listaEmpresas = empresaMapper.selectAll();

		System.out.println("Listando todas las empresas:\n");
		for (EmpresaModelo e : listaEmpresas) {
			System.out.println(e.getIde() + "\t" + e.getNombre() + "\t" + e.getFactura());
		}

		// Creamos una nueva empresa
		EmpresaModelo nuevaEmpresa = new EmpresaModelo(100, "Nueva", 5000, 1);

		// La intentamos insertar en la base de datos
		try {
			empresaMapper.insert(nuevaEmpresa);
		} catch (Exception e) {
			System.out.println("\n*** ERROR: No se pudo insertar en la BD");
			System.out.println("\t¿Existe ya una fila con la misma PK?\n");
		}

		System.out.println("\n-----\n");

		// Volver a listar todas las empresas
		listaEmpresas = empresaMapper.selectAll();

		System.out.println("Listando todas las empresas, otra vez:\n");
		for (EmpresaModelo e : listaEmpresas) {
			System.out.println(e.getIde() + "\t" + e.getNombre() + "\t" + e.getFactura());
		}
	}

	/**
	 * Método para hacer algunas pruebas con accionistas
	 */
	private static void trastearConAccionistas() {
		// Obtenermos la lista de todas las accionistas
		AccionistasMapper accionistasMapper = new AccionistasMapper();
		List<AccionistaModelo> listaAccionistas = accionistasMapper.selectAll();
		System.out.println("Listando todos los accionistas:\n");
		for (AccionistaModelo a : listaAccionistas) {
			System.out.println(a.getDni() + "\t" + a.getNombre() + "\t" + a.getApellidos());
		}
	}

	/**
	 * Punto de entrada a la aplicación
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		trastearConEmpresas();
		trastearConAccionistas();
	}

}
