package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RosterTest {

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
		Roster.getRoster().resetear();
	}

	@Test
	public void testGetRoster() 
	{
		assertNotNull(Roster.getRoster());
	}


	@Test
	public void testObtenerListaDeConcursantesExpulsables() 
	{
		//Roster en el que los participantes no cumplen las normas
		Tronero c1= new Tronero(null, 10);
		Pretendista c2= new Pretendista(null,10);
		Tronero c3= new Tronero(null, 18);
		
		//Tronero nomina a la vez a tronereo y a pretendista, no cumple las normas
		//Para comprobar que es así se puede poner en comenatario una de las dos nominaciones de c1
		//y al ejecutar veremos que no aparece el mensaje de que las normas no se cumplen
		c1.nominar(c2);
		c1.nominar(c3);
		c3.nominar(c1);
		c2.nominar(c3);
		
		Roster.getRoster().anadirConcursante(c3);
		Roster.getRoster().anadirConcursante(c1);
		Roster.getRoster().anadirConcursante(c2);
		
		Roster.getRoster().obtenerListaDeConcursantesExpulsables();
		
		Roster.getRoster().resetear();
		
		Tronero t1= new Tronero("Manu", 10);
		Tronero t2= new Tronero("Santi",17);
		Pretendista p1= new Pretendista("Lara", 20);
		Pretendista p2= new Pretendista("Marta", 90);
		Tronero t3= new Tronero("Juan", 12);
		
		t1.nominar(t2);
		t1.nominar(t3);
		
		t2.nominar(p1);
		t2.nominar(p2);
		
		p1.nominar(t2);
		p1.nominar(p2);
		
		p2.nominar(t1);
		
		t3.nominar(p2);
		
		//Si analizamos estas nominaciones los resulatdos deberian quedar así
		//t1: 1 nominación
		//t2: 7 nominaciones
		//t3: 2 nominaciones
		//p1: 2 nominaciones
		//p2: 4 nominaciones
		//Por tanto el umbral será siete, y se añadirán a la lista los concursantes con siete o más nominaciones,
		//en este caso solo estará t2
		
		Roster.getRoster().anadirConcursante(t3);
		Roster.getRoster().anadirConcursante(p2);
		Roster.getRoster().anadirConcursante(t2);
		Roster.getRoster().anadirConcursante(t1);
		Roster.getRoster().anadirConcursante(p1);
		
		ListaConcursantes lista1=Roster.getRoster().obtenerListaDeConcursantesExpulsables();
		
		assertFalse(lista1.esta(t1));
		assertTrue(lista1.esta(t2));
		assertFalse(lista1.esta(t3));
		assertFalse(lista1.esta(p1));
		assertFalse(lista1.esta(p2));
		
		Roster.getRoster().resetear();
		
		//Probamos ahora un caso en el que la lista vaya a tener más concursantes
		//para ello quitamos la nominación quintuple del ejemplo anterior
		
		Tronero t11= new Tronero("Manu", 10);
		Tronero t22= new Tronero("Santi",17);
		Pretendista p11= new Pretendista("Lara", 20);
		Pretendista p22= new Pretendista("Marta", 90);
		Tronero t33= new Tronero("Juan", 12);
		
		t11.nominar(t22);
		t11.nominar(t33);
		
		t22.nominar(p11);
		t22.nominar(p22);
		
		p11.nominar(p22);
		
		p22.nominar(t11);
		
		t33.nominar(p22);
		
		//Si analizamos estas nominaciones los resulatdos deberian quedar así
		//t1: 1 nominación
		//t2: 2 nominaciones
		//t3: 2 nominaciones
		//p1: 2 nominaciones
		//p2: 4 nominaciones
		//Por tanto el umbral será dos, y se añadirán a la lista los concursantes con dos o más nominaciones,
		//en este caso estarán t22, t33, p11 y p22
		
		Roster.getRoster().anadirConcursante(t33);
		Roster.getRoster().anadirConcursante(p22);
		Roster.getRoster().anadirConcursante(t22);
		Roster.getRoster().anadirConcursante(t11);
		Roster.getRoster().anadirConcursante(p11);
		
		ListaConcursantes lista2=Roster.getRoster().obtenerListaDeConcursantesExpulsables();
		
		assertFalse(lista2.esta(t11));
		assertTrue(lista2.esta(t22));
		assertTrue(lista2.esta(t33));
		assertTrue(lista2.esta(p11));
		assertTrue(lista2.esta(p22));
	}



}
