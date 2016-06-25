package com.juegoahorcado.utils;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() throws HibernateException {
		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			} catch (HibernateException e) {
				throw new HibernateException ("Se ha producido el siguiente error: /n" + e.getMessage());
			}
		}
		
		return sessionFactory;
	}
}
