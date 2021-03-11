package fp.tipos.grados;



/*
 C�digo: Consultable. Tipo String. Consta de 3 letras y 4 n�meros.
 Cuant�a de la beca: Consultable y modificable. Tipo Double. M�nimo 1500 Euros.
 Duraci�n: Consultable y modificable. Tipo Integer.
 El lapso temporal ha de ser, como m�nimo, de un mes. Ser� la cuant�a mensual. Consultable.
 Tipo de Beca: Tipo ENUM. Toma los valores ("ORDINARIA", "MOVILIDAD", "EMPRESA").
 Representaci�n como cadena: La aplicaci�n las representar� textualmente mediante el c�digo y el tipo, 
 separados por comas y colocados entre corchetes (por ejemplo, �[ABB2024, movilidad]�).
 Criterios:
      -De igualdad: Dos objetos distintos son la misma beca, si ambos comparten un mismo c�digo y el tipo de Beca.
      -De ordenaci�n natural: Al ordenar becas que tienen el mismo c�digo, se colocan en primera posici�n las becas de tipo ordinario, 
      luego las de movilidad y, por �ltimo, las de empresa.
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
