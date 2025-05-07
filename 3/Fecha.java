package org.pmoo.packlaboratorio3;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha implements IFecha
{
	//atributos
	private int dia;
	private int mes;
	private int annio;
	
	
	//constructora
	public Fecha(int pDia, int pMes, int pAnnio)
	{
		this.dia = pDia;
		this.mes = pMes;
		this.annio = pAnnio;
		
		if (!this.esCorrecta())
		{
			Calendar c = new GregorianCalendar();
			this.dia = c.get(Calendar.DATE);     // los dias empiezan a contar desde uno, pero
			this.mes = c.get(Calendar.MONTH) +1; // los meses empiezan a contar desde cero
			this.annio = c.get(Calendar.YEAR);			
		}
		
	}
		
	//otros métodos

	@Override
	public String toString()
	{
		String strDia = String.format("%02d", this.dia); 
		String strMes = String.format("%02d", this.mes);
		String strAnnio = String.format("%04d", this.annio);
		
		return strDia + "/" + strMes + "/" + strAnnio;
	}
	
	
	private boolean esCorrecta(){
		boolean correcto = false;
		if (this.dia > 0 && this.annio > 0) {
			switch (this.mes){
				case 1, 3, 5, 7, 8, 10, 12:
					if (this.dia <= 31) {
						correcto = true;
					}
					break;//31
				case 4, 6, 9, 11:
					if (this.dia <= 30) {
						correcto = true;
					}
					break; //30
				case 2:
					if (this.dia <= 28 && !esBisiesto()) {
						correcto = true;
					}else if (this.dia <= 29 && esBisiesto()){
						correcto = true;
					}
					break; // 28 no bisisesto
				default:
					break; // numero de mes no existente
					
				}
		}
		return correcto;
		
		
	}

	public boolean esBisiesto() {
		if (this.annio % 4 == 0 && this.annio % 100 != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void incrementar() {
		switch (this.mes) {
			case 1, 3, 5, 7, 8, 10, 12:
				if (this.dia == 31) {
					sumar();
				}else {
					this.dia += 1;
				}
				break;//31
			case 4, 6, 9, 11:
				if (this.dia == 30) {
					sumar();
				}else {
					this.dia += 1;
				}
				break; //30
			case 2:
				if (this.dia == 28 && !esBisiesto()) {
					sumar();
				}else if (this.dia == 29 && esBisiesto()){
					sumar();
				}else {
					this.dia += 1;
				}
				break; // 28 no bisisesto
		}
		
	}
	
	public void sumar() {
		this.dia = 1;
		if (this.mes != 12) {
			this.mes += 1;
		}else {
			this.mes = 1;
			this.annio += 1;
		}
	}
	
	public void restar() {
		if (this.mes != 1) {
			this.mes -= 1;
		}else {
			this.mes = 12;
			this.annio -= 1;
		}
		switch (this.mes) {
		case 1, 3, 5, 7, 8, 10, 12:
			this.dia = 31;
			break;//31
		case 4, 6, 9, 11:
			this.dia = 30;
			break; //30
		case 2:
			if (!esBisiesto()) {
				this.dia = 28;
			}else if (esBisiesto()){
				this.dia = 29;
			}
			break;
		}
	}
	
	@Override
	public void decrementar() {
		if (this.dia != 1) {
			this.dia -= 1;
		}else {
			restar();
		}
		
	}
	
}
