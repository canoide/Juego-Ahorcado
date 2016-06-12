package com.juegoahorcado.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			} catch (HibernateException e) {
				System.err.println("Error al Inicializar SessionFactory");
			}
		}
		
		return sessionFactory;
	}
}
