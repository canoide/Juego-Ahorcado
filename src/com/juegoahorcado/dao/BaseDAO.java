package com.juegoahorcado.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.juegoahorcado.utils.HibernateUtil;

public abstract class BaseDAO<T> {

	private Session sesion;
	private Transaction tx;
	Class<T> tipoClase;
	
	@SuppressWarnings("unchecked")
	public BaseDAO() {
		tipoClase = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public long guardar(T obj) throws HibernateException {
		int id = 0;
		
		try {
			
			this.iniciarOperacion();
			id = (int) sesion.save(obj);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new HibernateException("No se ha podido guardar el objeto: " + obj.toString());
		} finally {
			sesion.close();
		}
		
		return id;
	}

	public void actualizar(T obj) throws HibernateException {
		try {
			this.iniciarOperacion();
			this.sesion.update(obj);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new HibernateException("No se ha podido actualizar el objeto: " + obj.toString());
		} finally {
			this.sesion.close();
		}
	}
	
	public void eliminar(T obj) throws HibernateException {
		try {
			this.iniciarOperacion();
			this.sesion.delete(obj);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new HibernateException("No se ha podido borrar el objeto: " + obj.toString());
		} finally {
			this.sesion.close();
		}
	}
	
	public T obtenerPorID (int id) throws HibernateException {
		T obj = null;
		try {
			this.iniciarOperacion();
			obj = (T) this.sesion.get(tipoClase, id);
		} finally {
			this.sesion.close();
		}
		
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> obtenerLista() throws HibernateException {
        List<T> lista = null;  
        
        try 
        { 
            this.iniciarOperacion(); 
            lista = sesion.createQuery("from " + tipoClase.getName()).list(); 
        } finally 
        { 
            sesion.close(); 
        }  
        
        return lista;
	}
	
	private void iniciarOperacion() throws HibernateException {
		this.sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction(); 
	}
}
