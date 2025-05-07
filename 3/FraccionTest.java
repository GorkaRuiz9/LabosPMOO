package org.pmoo.packlaboratorio3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FraccionTest {

	Fraccion f1,f2;
	
	
	@Before
	public void setUp() throws Exception 
	{
		f1= new Fraccion(6,9);
		f2= new Fraccion(3,1);
	}

	@After
	public void tearDown() throws Exception 
	{
		f1=null;
		f2=null;
	}

	@Test
	public void testFraccion() 
	{
		assertNotNull(f1);
		assertNotNull(f2);
		
	}

	@Test
	public void testSimplificar() 
	{
		//La fracción es 6/9, por tanto la simplificación 2/3
		f1.simplificar();
		assertEquals(2,f1.getNumerador());
		assertEquals(3,f1.getDenominador());
		
		IFraccion f3= new Fraccion(-6, 9);
		//La fracción es -6/9 por tanto la simplificación -2/3
		f3.simplificar();
		assertEquals(-2,f3.getNumerador());
		assertEquals(3,f3.getDenominador());
		
		IFraccion f4= new Fraccion(6, -9);
		//La fracción es 6/-9 por tanto la simplificación -2/3
		f4.simplificar();
		assertEquals(-2,f4.getNumerador());
		assertEquals(3,f4.getDenominador());
		
	}

	@Test
	public void testSumar() 
	{
		//Suma de 6/9 + 3/1 = 33/9 = 11/3
		IFraccion f3=f1.sumar(f2);
		assertEquals(11,f3.getNumerador());
		assertEquals(3,f3.getDenominador());
		
		f1= new Fraccion(3,14);
		f2= new Fraccion(-2,3);
		
		//Suma de 3/14 + -2/3 =  -19/42
		IFraccion f4=f1.sumar(f2);
		assertEquals(-19,f4.getNumerador());
		assertEquals(42,f4.getDenominador());
		
		f1= new Fraccion(-3,14);
		f2= new Fraccion(2,3);
		
		//Suma de -3/14 + 2/3 =  19/42
		IFraccion f5=f1.sumar(f2);
		assertEquals(19,f5.getNumerador());
		assertEquals(42,f5.getDenominador());
		
		f1= new Fraccion(-3,14);
		f2= new Fraccion(-2,3);
		
		//Suma de -3/14 + -2/3 =  -37/42
		IFraccion f6=f1.sumar(f2);
		assertEquals(-37,f6.getNumerador());
		assertEquals(42,f6.getDenominador());
		
		
	}

	@Test
	public void testRestar() 
	{
		//Resta de 6/9 - 3/1 = -21/9 = -7/3
		IFraccion f3=f1.restar(f2);
		assertEquals(-7,f3.getNumerador());
		assertEquals(3,f3.getDenominador());
		
		f1= new Fraccion(3,14);
		f2= new Fraccion(-2,3);
		
		//Resta de 3/14 - -2/3 =  37/42
		IFraccion f4=f1.restar(f2);
		assertEquals(37,f4.getNumerador());
		assertEquals(42,f4.getDenominador());
		
		f1= new Fraccion(-3,14);
		f2= new Fraccion(2,3);
		
		//Resta de -3/14 - 2/3 =  -37/42
		IFraccion f5=f1.restar(f2);
		assertEquals(-37,f5.getNumerador());
		assertEquals(42,f5.getDenominador());
		
		f1= new Fraccion(-3,14);
		f2= new Fraccion(-2,3);
		
		//Resta de -3/14 - -2/3 =  19/42
		IFraccion f6=f1.restar(f2);
		assertEquals(19,f6.getNumerador());
		assertEquals(42,f6.getDenominador());
	}

	@Test
	public void testMultiplicar() 
	{
		//Multiplicación de 6/9 x 3/1 = 18/9 = 2/1
		IFraccion f3=f1.multiplicar(f2);
		assertEquals(2,f3.getNumerador());
		assertEquals(1,f3.getDenominador());
		
		f1= new Fraccion(-3,14);
		f2= new Fraccion(-2,3);
		
		//Multiplicación de -3/14 x -2/3 = 6/42 = 1/7
		IFraccion f4=f1.multiplicar(f2);
		assertEquals(1,f4.getNumerador());
		assertEquals(7,f4.getDenominador());
		
		f1= new Fraccion(3,14);
		f2= new Fraccion(-2,3);
		
		//Multiplicación de 3/14 x -2/3 = -6/42 = -1/7
		IFraccion f5=f1.multiplicar(f2);
		assertEquals(-1,f5.getNumerador());
		assertEquals(7,f5.getDenominador());
		
		f1= new Fraccion(-3,14);
		f2= new Fraccion(2,3);
		
		//Multiplicación de -3/14 x 2/3 = -6/42 = -1/7
		IFraccion f6=f1.multiplicar(f2);
		assertEquals(-1,f6.getNumerador());
		assertEquals(7,f6.getDenominador());
	}

	@Test
	public void testDividir() 
	{
		//División de 6/9 : 3/1 = 6/27 = 2/9
		IFraccion f3=f1.dividir(f2);
		assertEquals(2,f3.getNumerador());
		assertEquals(9,f3.getDenominador());
		
		f1= new Fraccion(-3,14);
		f2= new Fraccion(-2,3);
				
		//División de -3/14 : -2/3 = -9/-28 = 9/28
		IFraccion f4=f1.dividir(f2);
		assertEquals(9,f4.getNumerador());
		assertEquals(28,f4.getDenominador());
			
		f1= new Fraccion(3,14);
		f2= new Fraccion(-2,3);
				
		//División de 3/14 : -2/3 = 9/-28 = -9/28
		IFraccion f5=f1.dividir(f2);
		assertEquals(-9,f5.getNumerador());
		assertEquals(28,f5.getDenominador());
				
		f1= new Fraccion(-3,14);
		f2= new Fraccion(2,3);
				
		//División de -3/14 : 2/3 = -9/28 
		IFraccion f6=f1.dividir(f2);
		assertEquals(-9,f6.getNumerador());
		assertEquals(28,f6.getDenominador());
	}

	@Test
	public void testEsIgualQue() 
	{
		assertFalse(f1.esIgualQue(f2));
		f2=new Fraccion(6,9);
		assertTrue(f1.esIgualQue(f2));
	}

	@Test
	public void testEsMayorQue() 
	{	
		assertFalse(f1.esMayorQue(f2));
		assertTrue(f2.esMayorQue(f1));
	}

	@Test
	public void testEsMenorQue() 
	{
		assertTrue(f1.esMenorQue(f2));
		assertFalse(f2.esMenorQue(f1));
	}

}
