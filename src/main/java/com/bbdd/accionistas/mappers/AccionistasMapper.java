package com.bbdd.accionistas.mappers;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.bbdd.accionistas.modelos.AccionistaModelo;

public class AccionistasMapper {
	private SqlSessionFactory sqlSessionFactory;

	public AccionistasMapper() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public List<AccionistaModelo> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Utilizar la consulta AccionistasSQL.getAll de AccionistasMapper.xml
			List<AccionistaModelo> list = session.selectList("com.bbdd.accionistas.mappers.AccionistasSQL.getAll");
			return list;
		} finally {
			session.close();
		}
	}

	public AccionistaModelo selectByIda(long ida) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Utilizar la consulta AccionistasSQL.getByIda de AccionistasMapper.xml
			AccionistaModelo fila = (AccionistaModelo) session
					.selectOne("com.bbdd.accionistas.mappers.AccionistaSQL.getByIda", ida);
			return fila;
		} finally {
			session.close();
		}
	}

	public void update(AccionistaModelo fila) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Utilizar la sentencia AccionistasSQL.update de AccionistasMapper.xml
			session.update("com.bbdd.accionistas.mappers.AccionistaSQL.update", fila);
			session.commit();
		} finally {
			session.close();
		}
	}

	public void insert(AccionistaModelo fila) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Utilizar la sentencia AccionistasSQL.insert de AccionistasMapper.xml
			session.insert("com.bbdd.accionistas.mappers.AccionistasSQL.insert", fila);
			session.commit();
		} catch (Exception e) {
			// Si ocurre alguna excepción, simplemente la lanzamos para que la aplicación se
			// encargue de manejarla
			throw e;
		} finally {
			session.close();
		}
	}

	public void delete(long ida) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// Utilizar la sentencia AccionistasSQL.delete de AccionistasMapper.xml
			session.delete("com.bbdd.accionistas.mappers.AccionistasSQL.deleteByIda", ida);
			session.commit();
		} finally {
			session.close();
		}
	}
}