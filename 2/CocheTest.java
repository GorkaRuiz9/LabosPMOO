package org.pmoo.packlaboratorio1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CocheTest {
	
	Coche c1;
	Persona p1, p2, aux;
	
	@Before
	public void setUp() throws Exception 
	{
		c1= new Coche("3213 CTM", "Wolkswagen");
	}

	@After
	public void tearDown() throws Exception 
	{
		c1=null;
	}

	@Test
	public void testCoche() 
	{
		assertNotNull(c1);
	}

	@Test
	public void testEsElPropietario() 
	{
		p1 =new Persona("Juan Ceballos", 20, 10, "0-", "Español");
		p2 =new Persona("Juan Ceballos", 26, 10, "0-", "Español");
		c1.setPropietario(p1);
		assertTrue(c1.esElPropietario(p1));
		assertFalse(c1.esElPropietario(p2));
		
	}

	@Test
	public void testCambiarDePropietario() 
	{
		p1 =new Persona("Juan Ceballos", 20, 10, "0-", "Español");
		p2 =new Persona("Manuel Perez", 26, 17, "0+", "Español");
		
		//En esta primera prueba no se ejecuta el cambio, ya que el propietario es
		//el mismo que el que se quiere cambiar
		//El programa devuelve un chivato que dice si se ha hecho el cambio o no
		//Y luego mediante equals se compara los valores iniciales y finales de propietario
		c1.setPropietario(p1);
		aux=c1.getPropietario();
		assertFalse(c1.cambiarDePropietario(p1));
		assertEquals(aux,p1);
		
		//En este si se provoca el cambio
		c1.setPropietario(p2);
		assertTrue(c1.cambiarDePropietario(p1));
		assertEquals(p1,c1.getPropietario());
		assertNotEquals(p2,c1.getPropietario());
		
		//Para provocar el cambio todos los parámetros de la persona deben ser iguales
		//basta con que uno sea diferente para provocarlo
		p1 =new Persona("Juan Ceballos", 22, 10, "0-", "Español");
		c1.setPropietario(p2);
		assertTrue(c1.cambiarDePropietario(p1));
		assertEquals(p1,c1.getPropietario());
		assertNotEquals(p2,c1.getPropietario());		
		
	}

}
