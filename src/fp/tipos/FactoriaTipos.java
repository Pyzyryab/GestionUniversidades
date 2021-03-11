package fp.tipos;

import java.util.ArrayList;
import java.util.Calendar;


import fp.tipos.grados.AlumnoImpl;
import fp.tipos.grados.AsignaturaImpl;
import fp.tipos.grados.Alumno;
import fp.tipos.grados.Asignatura;
import fp.tipos.grados.BecaImpl;
import fp.tipos.grados.TipoAsignatura;
import fp.tipos.grados.Beca;
import fp.tipos.grados.TipoBeca;
public class FactoriaTipos {

	public static String getNIEAlumno() {
		return null;
	}

	public static String getDNIAlumno() {
		return "123456789X";
	}

	public static String getNombreAlumno() {
		return "Juan";
	}

	public static String getApellidosAlumno() {
		return "Nadie";
	}

	public static Beca createBeca(String codigo, TipoBeca tipo) {
		return new BecaImpl(codigo, tipo);
	}

	public static Beca createBeca(String codigo, Double cuantia,
			Integer duracion, TipoBeca tipo) {
		return new BecaImpl(codigo, cuantia, duracion, tipo);
	}

	public static Asignatura createAsignatura(String nombre, String codigo,
			Double numCreditos, TipoAsignatura tipo, Integer curso,
			String departamento) {
		return new AsignaturaImpl(nombre, codigo, numCreditos, tipo, curso,
				departamento);
	}

	public static Alumno createAlumno(String dni, String nombre,
			String apellidos, Calendar fechaNacimiento, String direccion,
			String telefono, String email) {
		return new AlumnoImpl(nombre, apellidos, dni,
				direccion, telefono, email,  fechaNacimiento, new ArrayList<Asignatura>());
	}
}
