package org.pmoo.packlaboratorio7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PretendistaTest {

	Pretendista c1,c2,c7;
	
	@Before
	public void setUp() throws Exception 
	{
		c1= new Pretendista("Manuel",1);
		c2= new Pretendista("Javi", 5);
		c7= new Pretendista("Xavi", 5);
	}

	@After
	public void tearDown() throws Exception 
	{
		c1=null;
		c2=null;
		c7=null;
	}

	@Test
	public void testCumpleLasReglas() 
	{
		//Vamos probando caso por caso
		
		//Caso 1: tiene más pretendistas nominados que puntuación
		Tronero c3= new Tronero(null, 0);
		Pretendista c4= new Pretendista(null, 10);
		Pretendista c5= new Pretendista(null, 0);
		c1.nominar(c3);
		c1.nominar(c4);
		c1.nominar(c5);
		assertFalse(c1.cumpleLasReglas());
		
		//Caso 2: tiene mas de un tronero nominado
		Tronero c6= new Tronero(null, 0);
		c2.nominar(c3);
		c2.nominar(c6);
		assertFalse(c2.cumpleLasReglas());
		
		//Caso 3: tiene menos o igual pretendistas a su puntuacion y uno o ningun tronero
		
		//Lista vacia
		assertTrue(c3.cumpleLasReglas());
		
		//Lista con solo pretendistas inferiores a la puntuacion y cero troneros
		c7.nominar(c4);
		c7.nominar(c5);
		assertTrue(c3.cumpleLasReglas());
		
		//Lista con solo pretendistas inferiores a la puntuacion y un troneros
		c7.nominar(c6);
		assertTrue(c3.cumpleLasReglas());
		
		//Lista con único tronero
		c4.nominar(c6);
		assertTrue(c4.cumpleLasReglas());
		
		//Caso 4: puntuacion negativa
		Pretendista c8=new Pretendista(null, -1);
		c4.nominar(c8);
		assertFalse(c4.cumpleLasReglas());
		
		//Caso 5: puntuación negativa en el nominador
		assertFalse(c8.cumpleLasReglas());

	}

	@Test
	public void testAplicarNominacion() 
	{
		//Se hará una prueba para cuando la nominacíon es normal y otra para cuando es quintuple
		
		Tronero c3= new Tronero(null, 0);
		Pretendista c4= new Pretendista(null, 0);
		Pretendista c5= new Pretendista(null, 0);
		c3.nominar(c1);
		
		//Nomina a tronero que le tiene nominado --> Nominación quintuple
		c1.aplicarNominacion(c3);
		System.out.print("Las nominaciones del concursante deberían ser cinco, y el programa muestra: ");
		System.out.print(c3.cuantasNominacionesTiene());
		
		//Nomina a pretendista --> Nominación normal
		c1.aplicarNominacion(c4); 
		System.out.print("\nLas nominaciones del concursante deberían ser una, y el programa muestra: ");
		System.out.print(c4.cuantasNominacionesTiene());
		
		//Nomina a tronero que no lo tiene nominado --> Nominación normal
		c2.aplicarNominacion(c3); 
		System.out.print("\nLas nominaciones del concursante deberían ser seis (ya que se suma una a las cinco que ya tenía), y el programa muestra: ");
		System.out.print(c3.cuantasNominacionesTiene());
		
	}

	@Test
	public void testPretendista() 
	{
		assertNotNull(c1);
		assertNotNull(c2);
	}

}
