package fp.tipos.grados;

import java.util.Calendar;
import java.util.List;

/*
  Nombre: Consultable. Modificable. Tipo String.
  Apellidos: Consultable. Modificable. Tipo String.
  DNI: Consultable. Modificable. Tipo String. Tiene ocho números y una letra.
  Fecha de Nacimiento: Consultable. Modificable. Tipo Calendar.
  Dirección:Consultable. Modificable. Tipo String.
  Teléfono: Consultable. Modificable. Tipo String. Ha de tener 9 números.
  Email: Consultable. Modificable. Tipo String. Debe tener un @ en la cadena de carácteres.
  Asignaturas: Tipo List. Consultable y modificable.
  Curso: Tipo Integer. Consultable y modificable.
  Representación del String: DNI-Apellidos, Nombre.
  Criterios:
       - De igualdad: Dos objetos serán (¿¿distintos??) si ambos objetos almacenan el mismo DNI, nombre y apellidos.
       - De orden natural: La aplicación mantendrá a los alumnos ordenados por apellidos en orden alfabético.
       Si se encontrara una igualdad de apellidos, pasarían a ordenarse por el nombre y, en caso de coincidencia de este,
       lo harían por el DNI.
 */
public interface Alumno extends Comparable<Alumno> {

	String getNombre();

	void setNombre(String Nombre);

	String getApellidos();

	void setApellidos(String Apellidos);

	String getDNI();

	void setDNI(String DNI);

	Calendar getFechaNacimiento();

	void setFechaNacimiento(Calendar FechaNacimiento);

	String getDireccion();

	void setDireccion(String Direccion);

	String getTelefono();

	void setTelefono(String Telefono);

	String getEmail();

	void setEmail(String Email);

	Integer getCurso();

	List<Asignatura> getAsignaturas();

	void matriculaAsignatura(Asignatura a);

	void eliminaAsignatura(Asignatura a);

}
