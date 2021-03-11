package fp.tipos.grados.test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import fp.utiles.grados.Grados;
import fp.tipos.grados.Alumno;
import fp.tipos.grados.AlumnoImpl;
import fp.tipos.grados.Asignatura;
import fp.tipos.grados.AsignaturaImpl;
import fp.tipos.grados.Beca;
import fp.tipos.grados.BecaImpl;
import fp.tipos.grados.TipoAsignatura;
import fp.tipos.grados.TipoBeca;
import fp.tipos.grados.excepciones.ExcepcionAlumnoNoValido;

public class TestEntrega1 {

	public static void main(String[] args) {

		List<Asignatura> asignaturas = new LinkedList<Asignatura>();
		Alumno a1 = new AlumnoImpl("Jan", "Phillips", "00112233A",
				"Calle Cani, S/N", "954161064", "jan@us.es",
				new GregorianCalendar(1900, Calendar.JANUARY, 1), asignaturas);
		System.out.println(a1);
		Alumno a2 = new AlumnoImpl("Juan", "Garc�a", "11332233A",
				"Calle Camiones, S/N", "955161064", "juan@us.es",
				new GregorianCalendar(1900, Calendar.JANUARY, 4), asignaturas);
		System.out.println(a2);
		Alumno a3 = new AlumnoImpl("Mar�a", "Dom�nguez", "00778456A",
				"Calle Bruselas, 10", "955231064", "mar�a@us.es",
				new GregorianCalendar(1900, Calendar.FEBRUARY, 6), asignaturas);
		System.out.println(a3);

		Beca b1 = new BecaImpl("ABC1234", 1601.0, 11, TipoBeca.ORDINARIA);
		System.out.println(b1);
		Beca b2 = new BecaImpl("ABC1235", 1700.0, 10, TipoBeca.ORDINARIA);
		System.out.println(b2);
		Beca b3 = new BecaImpl("ABC1236", 1502.0, 9, TipoBeca.ORDINARIA);
		System.out.println(b3);

		Asignatura asig1 = new AsignaturaImpl("Fundamentos de la Programaci�n",
				"4567891", 12.0, TipoAsignatura.ANUAL, 1, "LSI");
		System.out.println(asig1);

		// 7.2

		Asignatura as[] = new Asignatura[9];
		as[0] = asig1;
		as[1] = new AsignaturaImpl("Fisica", "1234567", 6.0,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, "FFI");
		as[2] = new AsignaturaImpl("Introducci�n a las matem�ticas discretas",
				"4567892", 6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1, "MMD");
		as[3] = new AsignaturaImpl("�lgebra", "5648791", 6.0,
				TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1, "ALN");
		as[4] = new AsignaturaImpl("Circu�tos", "7412589", 6.0,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, "CED");
		as[5] = new AsignaturaImpl("C�lculo", "7832589", 6.0,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, "CIN");
		as[6] = new AsignaturaImpl("Estructuras de Computadores", "7412589",
				6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1, "EDC");
		as[7] = new AsignaturaImpl("Empresas", "7411189", 6.0,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, "AE");
		as[8] = new AsignaturaImpl("Estad�stica", "1477589", 6.0,
				TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1, "CED");

		Grados.matriculaAlumno(a1, as);
		System.out.println(a1.getAsignaturas().toString());

		// 7.3

		System.out.println(Arrays.toString(Grados
				.resumenTipoAsignaturasAlumno(a1)));

		// 7.4

		// i
		if (Grados.esBecaEspecial(b1)) {
			System.out.println("La beca tiene una cuant�a mayor de 1000 Euros"
					+ " y una duraci�n menor que un a�o");

		} else {
			System.out
					.println("La beca no tiene una cuant�a mayor de 1000 Euros"
							+ " y una duraci�n menor que un a�o");
		}

		// ii
		if (Grados.esBecaEspecial(b1)) {
			System.out.println("La beca tiene una cuant�a mayor de 1000 Euros"
					+ " y una duraci�n menor que un a�o");

		} else {
			System.out
					.println("La beca no tiene una cuant�a mayor de 1000 Euros"
							+ " y una duraci�n menor que un a�o");
		}

		// iii

		if (Grados.esAlumnoVeterano(a1)) {
			System.out.println("Es del �ltimo curso o nacido antes de 1985");

		} else {
			System.out
					.println("El alumno no es del �ltimo curso o nacido antes"
							+ " de 1985");
		}

		// iv
		if (Grados.esAsignaturaExtensa(asig1)) {
			System.out.println("El alumno est� matriculado de esa asignatura");

		} else {
			System.out
					.println("El alumno no est� matriculado de esa asignatura");
		}

		// v.1

		if (Grados.sonBecasIguales(b1, b2) == true) {
			System.out.println("Las becas son iguales");

		} else {
			System.out.println("Las becas no son iguales");
		}

		// v.2

		if (Grados.sonBecasIdenticas(b2, b3) == true) {
			System.out.println("Las becas son id�nticas");

		} else {
			System.out.println("Las becas no son id�nticas");
		}

		if (Grados.estaAlumnoMatriculado(a1, asig1) == true) {
			System.out.println("El alumno est� matriculado de esa asignatura");
		} else {
			System.out
					.println("El alumno no est� matriculado de esa asignatura");
		}

		// 7.5
		try {
			a1.setEmail("Desconocido");

		} catch (ExcepcionAlumnoNoValido excep) {
			System.out.println("Falta rellenar campo Email");
		}

		// 7.6
		Beca becas[] = new Beca[3];
		becas[0] = b1;
		becas[1] = b2;
		becas[2] = b3;
		Grados.ordenaBecasPorCodigo(becas);
		System.out.println(Arrays.toString(becas));
		
		// 7.7
		Grados.ordenaBecasPorCuantiaMensual(becas);
		System.out.println(Arrays.toString(becas));
	}

}
