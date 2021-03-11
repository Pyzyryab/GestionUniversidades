package fp.tipos.grados;

/*
Nombre asignatura: Consultable. Tipo String.
Acrónimo: Consultable. Derivada de tipo nombre. Tipo String. Se crea con las mayúsculas del nombre.
Código: Consultable. Tipo String. Ha de tener 7 dígitos.
Créditos. Consultable. Tipo Double. Podrá tomar valores no enteros, pero ha de ser siempre mayor que cero.
Tipo De Asignatura: Consultable. Tipo ENUM. Toma los valores ("ANUAL", "PRIMER_CUATRIMESTRE", "SEGUNDO_CUATRIMESTRE").
Curso: Consultable. Tipo Integer. Toma valores de 0 a 4.
Departamento. Consultable. Tipo String.
Representación del String: "(Código) nombre de la asignatura".
Criterios:
     - De igualdad: Dos objetos serán distintos si ambos objetos almacenan el mismo código.
     - De orden natural: Se ordenan alfabéticamente por su código;
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
