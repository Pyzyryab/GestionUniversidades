package fp.tipos.grados;

/*
Nombre asignatura: Consultable. Tipo String.
Acr�nimo: Consultable. Derivada de tipo nombre. Tipo String. Se crea con las may�sculas del nombre.
C�digo: Consultable. Tipo String. Ha de tener 7 d�gitos.
Cr�ditos. Consultable. Tipo Double. Podr� tomar valores no enteros, pero ha de ser siempre mayor que cero.
Tipo De Asignatura: Consultable. Tipo ENUM. Toma los valores ("ANUAL", "PRIMER_CUATRIMESTRE", "SEGUNDO_CUATRIMESTRE").
Curso: Consultable. Tipo Integer. Toma valores de 0 a 4.
Departamento. Consultable. Tipo String.
Representaci�n del String: "(C�digo) nombre de la asignatura".
Criterios:
     - De igualdad: Dos objetos ser�n distintos si ambos objetos almacenan el mismo c�digo.
     - De orden natural: Se ordenan alfab�ticamente por su c�digo;
*/

public interface Asignatura extends Comparable<Asignatura>{
	String getNombre();
	String getAcronimo();
	String getCodigo();
	Double getCreditos();
	TipoAsignatura getTipo();
	Integer getCurso();
	String getDepartamento();
	
}
