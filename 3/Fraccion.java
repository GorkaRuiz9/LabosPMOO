package org.pmoo.packlaboratorio3;

public class Fraccion implements IFraccion
{
	private int numerador;
	private int denominador;
	
	public Fraccion (int pNumerador, int pDenominador)
	{
		this.numerador=pNumerador;
		this.denominador=pDenominador;
		
		if (this.denominador==0 )
		{
			this.denominador=1;
			System.out.print("No se puede crear una fracción con denominador cero. ");
			System.out.println("Se ha asignado el valor 1 al denominador.");
		}
		
	}
	
	
	// no interesa hacer pública, esta funcionalidad
 	//????????????? mcd(//?????????????)
	{
		//?????????????
	}
	
	public int getNumerador() {
		return numerador;
	}


	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}


	public int getDenominador() {
		return denominador;
	}


	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}


	@Override
	public void simplificar() 
	{
		boolean chivato=true;
		int i;
		
		if (this.denominador<0)
		{
			this.denominador=this.denominador*-1;
			this.numerador=this.numerador*-1;
		}
		
		while (chivato)
		{
			chivato=false;
			for (i=2;i<=this.denominador;i=i+1)
			{
				if (this.numerador%i==0 && this.denominador%i==0)
				{
					this.numerador=this.numerador/i;
					this.denominador=this.denominador/i;
					chivato=true;
				}
			}
		}
	}


	@Override
	public IFraccion sumar(IFraccion pFraccion) 
	{
		Fraccion f=new Fraccion(0, 0);
		f.denominador=this.denominador*pFraccion.getDenominador();
		f.numerador=this.numerador*pFraccion.getDenominador()+pFraccion.getNumerador()*this.denominador;
		f.simplificar();
		return f;
	}


	@Override
	public IFraccion restar(IFraccion pFraccion) 
	{
		Fraccion f=new Fraccion(0, 0);
		f.denominador=this.denominador*pFraccion.getDenominador();
		f.numerador=this.numerador*pFraccion.getDenominador()-pFraccion.getNumerador()*this.denominador;
		f.simplificar();
		return f;
	}


	@Override
	public IFraccion multiplicar(IFraccion pFraccion) 
	{
		Fraccion f =new Fraccion(0,0);
		f.numerador=this.numerador*pFraccion.getNumerador();
		f.denominador=this.denominador*pFraccion.getDenominador();
		f.simplificar();
		if (f.denominador<0 && f.numerador<0)
		{
			f.denominador=f.denominador*-1;
			f.numerador=f.numerador*-1;
		}
		return(f);
		
	}


	@Override
	public IFraccion dividir(IFraccion pFraccion) 
	{
		Fraccion f =new Fraccion(0,0);
		f.numerador=this.numerador*pFraccion.getDenominador();
		f.denominador=this.denominador*pFraccion.getNumerador();
		f.simplificar();
		if (f.denominador<0 && f.numerador<0)
		{
			f.denominador=f.denominador*-1;
			f.numerador=f.numerador*-1;
		}
		return(f);
	}


	@Override
	public boolean esIgualQue(IFraccion pFraccion) 
	{
		float f1=this.numerador/this.denominador;
		float f2=pFraccion.getNumerador()/pFraccion.getDenominador();
		if (f1==f2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public boolean esMayorQue(IFraccion pFraccion) 
	{
		float f1=this.numerador/this.denominador;
		float f2=pFraccion.getNumerador()/pFraccion.getDenominador();
		if (f1>f2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public boolean esMenorQue(IFraccion pFraccion) 
	{
		float f1=this.numerador/this.denominador;
		float f2=pFraccion.getNumerador()/pFraccion.getDenominador();
		if (f1<f2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


}
