package com.bbdd.accionistas.mappers;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bbdd.accionistas.modelos.EmpresaModelo;

/**
 * Clase de acceso a datos que se utiliza como medio de intercambio entre
 * nuestra clase Modelo y la Tabla de la base de datos.
 * 
 * Esta clase utiliza las sentencias SQL definidas en su correspondiente archivo
 * XML de mapeo.
 * 
 * @author antonio
 *
 */
public class EmpresasMapper {

	private SqlSessionFactory sqlSessionFactory;

	public EmpresasMapper() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	/**
	 * Devuelve una lista con todas las instancias EmpresaModelo de la base de datos
	 * 
	 * @return la lista de todas las empresas que hay en la base de datos
	 */
	public List<EmpresaModelo> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Utilizar la consulta EmpresasSQL.getAll de EmpresasMapper.xml
			List<EmpresaModelo> list = session.selectList("com.bbdd.accionistas.mappers.EmpresasSQL.getAll");
			return list;
		} finally {
			session.close();
		}
	}

	/**
	 * Recupera una instancia de EmpresaModelo de la base de datos
	 * 
	 * @param ide
	 *            Clave primaria de la tabla
	 *
	 * @return Una instancia de EmpresaModelo que coincida con la clave primaria
	 *         suministrada. null si no hay ninguna fila coincidente.
	 */
	public EmpresaModelo selectByIde(int ide) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Utilizar la consulta EmpresasSQL.getByIde de EmpresasMapper.xml
			EmpresaModelo fila = (EmpresaModelo) session.selectOne("com.bbdd.accionistas.mappers.EmpresasSQL.getByIde", ide);
			return fila;
		} finally {
			session.close();
		}
	}

	/**
	 * Actualiza una instancia de EmpresaModelo en la base de datos
	 * 
	 * @param fila
	 *            la instancia que se desea actualizar.
	 */
	public void update(EmpresaModelo fila) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Utilizar la sentencia EmpresasSQL.update de EmpresasMapper.xml
			session.update("com.bbdd.accionistas.mappers.EmpresasSQL.update", fila);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insertar una instancia de EmpresaModelo en la base de datos.
	 * 
	 * @param fila
	 *            la instancia que deseamos almacenar.
	 * @throws Exception
	 */
	public void insert(EmpresaModelo fila) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Utilizar la sentencia EmpresasSQL.insert de EmpresasMapper.xml
			session.insert("com.bbdd.accionistas.mappers.EmpresasSQL.insert", fila);
			session.commit();
		} catch (Exception e) {
			// Si ocurre alguna excepción, simplemente la lanzamos para que la aplicación se
			// encargue de manejarla
			throw e;
		} finally {
			session.close();
		}
	}

	/**
	 * Eliminar una instancia EmpresaModelo de la base de datos.
	 * 
	 * @param ide
	 *            clave primaria de la instancia a eliminar.
	 */
	public void delete(int ide) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Utilizar la sentencia EmpresasSQL.delete de EmpresasMapper.xml
			session.delete("com.bbdd.accionistas.mappers.EmpresasSQL.deleteByIde", ide);
			session.commit();
		} finally {
			session.close();
		}
	}
}