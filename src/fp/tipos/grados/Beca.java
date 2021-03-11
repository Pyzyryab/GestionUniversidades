package fp.tipos.grados;



/*
 Código: Consultable. Tipo String. Consta de 3 letras y 4 números.
 Cuantía de la beca: Consultable y modificable. Tipo Double. Mínimo 1500 Euros.
 Duración: Consultable y modificable. Tipo Integer.
 El lapso temporal ha de ser, como mínimo, de un mes. Será la cuantía mensual. Consultable.
 Tipo de Beca: Tipo ENUM. Toma los valores ("ORDINARIA", "MOVILIDAD", "EMPRESA").
 Representación como cadena: La aplicación las representará textualmente mediante el código y el tipo, 
 separados por comas y colocados entre corchetes (por ejemplo, “[ABB2024, movilidad]”).
 Criterios:
      -De igualdad: Dos objetos distintos son la misma beca, si ambos comparten un mismo código y el tipo de Beca.
      -De ordenación natural: Al ordenar becas que tienen el mismo código, se colocan en primera posición las becas de tipo ordinario, 
      luego las de movilidad y, por último, las de empresa.
 */
public interface Beca extends Comparable <Beca>{
	
	String getCodigo();
	Double getCuantiaTotal();
	void setCuantiaTotal (Double CuantiaTotal);
	Integer getDuracion();
	void setDuracion (Integer Duracion);
	TipoBeca getTipo();
	Double getCuantiaMensual();
	
}
