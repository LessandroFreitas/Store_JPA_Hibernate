package br.com.lessandro.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");

	public static  EntityManager getEntityManeger () {
		return FACTORY.createEntityManager();
	}
	
}
