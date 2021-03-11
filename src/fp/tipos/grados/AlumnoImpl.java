package fp.tipos.grados;

import java.util.Calendar;
import java.util.List;

import fp.tipos.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.tipos.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;

public class AlumnoImpl implements Alumno {

	// Atributos

	private String nombre, apellidos, dni, direccion, telefono, email;
	private Calendar fechaNacimiento;
	private List<Asignatura> asignaturas;

	

	// Constructor

	public AlumnoImpl(String nombre, String apellidos, String dni,
			String direccion, String telefono, String email,
			Calendar fechanacimiento, List<Asignatura> asignatura) {

		//Excepción a DNI
		
		if (checkDNI(dni)) {
			this.dni = dni;

		} else {
			throw new ExcepcionAlumnoNoValido("EL DNI es incorrecto.");
		}
		checkEmail(email);
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.fechaNacimiento = fechanacimiento;
		this.asignaturas = asignatura;

	}

	// Comprobación DNI bien escrito

	public static Boolean checkDNI(String dni) {
		Boolean d = dni.length() == 9 && Character.isDigit(dni.charAt(0))
				&& Character.isDigit(dni.charAt(1))
				&& Character.isDigit(dni.charAt(2))
				&& Character.isDigit(dni.charAt(3))
				&& Character.isDigit(dni.charAt(4))
				&& Character.isDigit(dni.charAt(5))
				&& Character.isDigit(dni.charAt(6))
				&& Character.isDigit(dni.charAt(7))
				&& Character.isLetter(dni.charAt(8));
		return d;
	}
	
	
	//Comprobación email contenga "@"
	
	private void checkEmail(String email) {
		if (!email.contains("@")) {
			throw new ExcepcionAlumnoNoValido("Email no valido");
		}

	}

	// Métodos

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {

		return dni;
	}

	public void setDNI(String dni) {
		if (checkDNI(dni)) {
			this.dni = dni;

		} else {
			throw new ExcepcionAlumnoNoValido("EL DNI es incorrecto.");
		}

	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {

		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {
		checkEmail(email);
		this.email = email;
	}

	public Integer getCurso() {
		Integer curso = 1;
		if (getAsignaturas() != null && !getAsignaturas().isEmpty()) {
			for (Asignatura a : getAsignaturas()) {
				if (curso < a.getCurso()) {
					curso = a.getCurso();

				}
			}
		} else {
			throw new ExcepcionAlumnoOperacionNoPermitida(
					"Lista de asignatuars vacía");
		}
		return curso;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void matriculaAsignatura(Asignatura a) {

		asignaturas.add(a);

	}

	public void eliminaAsignatura(Asignatura a) {

		asignaturas.remove(a);

	}

	// Representación como cadena

	public String toString() {
		return getDNI() + " - " + getApellidos() + " , " + getNombre();
	}

	// Criterio de igualdad

	public boolean equals(Object o) {
		boolean r = false;
		if (o instanceof Alumno) {
			Alumno a = (Alumno) o;
			r = this.getDNI().equals(a.getDNI())
					&& this.getApellidos().equals(a.getApellidos())
					&& this.getNombre().equals(a.getNombre());
		}

		return r;
	}

	public int hashCode() {
		return getDNI().hashCode() + getApellidos().hashCode() * 31
				+ getNombre().hashCode() * 31 * 31;
	}

	// Método de ordenación

	public int compareTo(Alumno a) {
		int r;
		if (a == null) {
			throw new ExcepcionAlumnoOperacionNoPermitida();
		} else {
			r = getApellidos().compareTo(a.getApellidos());
			if (r == 0) {
				r = getNombre().compareTo(a.getNombre());
				if (r == 0) {
					r = getDNI().compareTo(a.getDNI());
				}
			}
		}
		return r;
	}

}
