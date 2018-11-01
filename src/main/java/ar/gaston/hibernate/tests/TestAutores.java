package ar.gaston.hibernate.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ar.gaston.hibernate.modelo.Autor;
import ar.gaston.hibernate.modelo.Libro;

public class TestAutores {

	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
	
	public static void main(String[] args) {
		
		crearDatos();
		imprimirDatos();

	}

	public static void imprimirDatos() {
		
		EntityManager manager = emf.createEntityManager();
		Autor autor = manager.find(Autor.class, 2L);
		List<Libro> libros = autor.getLibros();
		libros.size();
		manager.close();
		System.out.println(autor);
		for(Libro l: libros) {
			System.out.println("* "+l);
		}
		
		
	}

	public static void crearDatos() {
		
		EntityManager manager = emf.createEntityManager();
		Autor a1, a2, a3;
		a1 = new Autor(1L, "Pablo Pérez", "Española");
		a2 = new Autor(2L, "Elena Gomez", "Mexicana");
		a3 = new Autor(3L, "Miguel López", "Chilena");
		Libro l1, l2, l3, l4, l5;
		l1 = new Libro(1L, "Programar en Java es fácil", a1);
		l2 = new Libro(2L, "Cómo vestise con estilo", a3);
		l3 = new Libro(3L, "Cómo cocinar sin quemar la cocina", a1);
		l4 = new Libro(4L, "Programar en COBOL es divertido", a2);
		l5 = new Libro(5L, "Programar en COBOL no es divertido", null);
		a2.addLibro(l5);
		
		manager.getTransaction().begin();
		manager.persist(a1);
		manager.persist(a2);
		manager.persist(a3);
		manager.persist(l1);
		manager.persist(l2);
		manager.persist(l3);
		manager.persist(l4);
		manager.persist(l5);
		manager.getTransaction().commit();
		manager.close();
	}

}
