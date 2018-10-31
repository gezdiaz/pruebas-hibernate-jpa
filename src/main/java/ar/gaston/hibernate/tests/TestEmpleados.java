package ar.gaston.hibernate.tests;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ar.gaston.hibernate.modelo.Direccion;
import ar.gaston.hibernate.modelo.Empleado;

public class TestEmpleados {
	
	//@PersistenceContext(unitName = "aplicacion") //Es el que esta en el archivo xml
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		//creamos el gestor de persistencia
		emf = Persistence.createEntityManagerFactory("aplicacion");//"aplicacion" Es el que esta en el archivo xml
		EntityManager manager = emf.createEntityManager();
		

		Empleado e = new Empleado(10L, "Pérez", "Sherman", LocalDate.of(1973, Month.JULY, 3));
		e.setDireccion(new Direccion(15L, "Calle Walaby 42", "Sídney", "Nueva Gales del Sur", "Australia"));

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
