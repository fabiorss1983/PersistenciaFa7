package br.com.persistenciafa7.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA_PU");
		entityManagerFactory.createEntityManager();
	}
}
