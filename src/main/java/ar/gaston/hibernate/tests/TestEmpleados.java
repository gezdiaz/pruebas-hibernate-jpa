package ar.gaston.hibernate.tests;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

import ar.gaston.hibernate.modelo.Empleado;

public class TestEmpleados {
	
	//@PersistenceContext(unitName = "aplicacion") //Es el que esta en el archivo xml
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		//creamos el gestor de persistencia
		emf = Persistence.createEntityManagerFactory("aplicacion");//"aplicacion" Es el que esta en el archivo xml
		EntityManager manager = emf.createEntityManager();
		
		Empleado e = new Empleado(10L, "Pérez", "Pepito", new GregorianCalendar(1997, 6, 3).getTime());
		
		manager.getTransaction().begin();
		manager.persist(e);
		manager.getTransaction().commit();
		manager.close();

		imprimirTodo();
		
	}

	private static void imprimirTodo() {
		EntityManager manager = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		
		System.out.println("Hay: "+empleados.size()+" empleado/s en el sistema.");
		for(Empleado e : empleados) {
			System.out.println(e.toString());
		}
		manager.close();
	}
	
}
