package org.pmoo.packlaboratorio3;

public interface IFraccion
{
  public abstract int getNumerador();
  public abstract int getDenominador();
  public abstract void simplificar();
  public abstract IFraccion sumar (IFraccion pFraccion);
  public abstract IFraccion restar (IFraccion pFraccion);
  public abstract IFraccion multiplicar (IFraccion pFraccion);
  public abstract IFraccion dividir (IFraccion pFraccion);
  public abstract boolean esIgualQue(IFraccion pFraccion);
  public abstract boolean esMayorQue(IFraccion pFraccion);
  public abstract boolean esMenorQue(IFraccion pFraccion);
}
