package fp.utiles.grados;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import fp.tipos.grados.Alumno;
import fp.tipos.grados.Asignatura;
import fp.tipos.grados.Beca;
import fp.tipos.grados.TipoAsignatura;
import fp.tipos.grados.comparadores.ComparadorBecaCuantiaMensual;

public class Grados {

	public static void matriculaAlumno( Alumno al,Asignatura a[]) {
		int numAsig = a.length;

		for (int i = 0; i < numAsig; i++) {
			List<Asignatura> asMatr = al.getAsignaturas();
			if (asMatr.contains(a[i]) == false) {
				al.matriculaAsignatura(a[i]);
			}
		}
	}

	public static Integer[] resumenTipoAsignaturasAlumno(Alumno al) {
		Integer i[] = new Integer[3];
		i[0] = 0;
		i[1] = 0;
		i[2] = 0;
		for (Asignatura a : al.getAsignaturas()) {
			switch (a.getTipo()) {
			case PRIMER_CUATRIMESTRE:
				i[0] += 1;
				break;
			case SEGUNDO_CUATRIMESTRE:
				i[1] += 1;
				break;
			default:
				i[2] += 1;
				break;
			}
		}
		return i;
	}

	public static Boolean esBecaEspecial(Beca beca) {

		Boolean res = false;
		if (beca.getCuantiaMensual() > 1000.0 && beca.getDuracion() > 12) {
			res = true;
		}
		return res;
	}

	public static Boolean esAlumnoVeterano(Alumno alumno) {

		Boolean res = false;
		if (alumno != null && alumno.getFechaNacimiento() != null) {
			if ((!alumno.getAsignaturas().isEmpty() && alumno.getCurso() == 4)
					|| alumno.getFechaNacimiento().get(Calendar.YEAR) < 1985) {
				res = true;
			}
		}
		return res;
	}

	public static Boolean esAsignaturaExtensa(Asignatura asig) {

		Boolean res = false;
		if ((asig.getTipo() == TipoAsignatura.ANUAL)
				&& asig.getCreditos() > 12) {
			res = true;
		} else if (asig.getTipo() != TipoAsignatura.ANUAL
				&& asig.getCreditos() > 6) {
			res = true;
		}
		return res;
	}

	public static Boolean estaAlumnoMatriculado(Alumno al, Asignatura asig) {

		Boolean res = false;
		if (al.getAsignaturas().contains(asig)) {
			res = true;
		}
		return res;
	}

	public static Boolean sonBecasIguales(Beca beca, Beca bec) {
		return beca.equals(bec);
	}

	public static Boolean sonBecasIdenticas(Beca beca, Beca bec) {
		return beca == bec;
	}

	public static void ordenaBecasPorCodigo(Beca beca[]) {
		Arrays.sort(beca);
	}

	public static void ordenaBecasPorCuantiaMensual(Beca beca[]) {
		Arrays.sort(beca, new ComparadorBecaCuantiaMensual());
	}

}
