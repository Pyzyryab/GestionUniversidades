package fp.tipos.grados;

import fp.tipos.grados.excepciones.ExcepcionAsignaturaNoValida;

public class AsignaturaImpl implements Asignatura {

	// Atributos

	private String nombre;
	private String codigo;
	private Double creditos;
	private TipoAsignatura tipo;
	private Integer curso;
	private String departamento;

	// Constructor

	public AsignaturaImpl(String nombre, String codigo, Double creditos,
			TipoAsignatura tipo, Integer curso, String departamento) {

		//Excepciones de código, curso y créditos
		
		if (checkCodigo(codigo)) {
			this.codigo = codigo;
		} else {
			throw new ExcepcionAsignaturaNoValida("Código erróneo.");
		}
		if (curso < 1 || curso > 4) {
			throw new ExcepcionAsignaturaNoValida(
					"El curso introducido es incorrecto.");
		}
		if (creditos <= 0) {
			throw new ExcepcionAsignaturaNoValida(
					"El nº créditos es incorrecto.");
		}

		this.nombre = nombre;
		this.creditos = creditos;
		this.tipo = tipo;
		this.curso = curso;
		this.departamento = departamento;

	}

	
	//Comprobación de código correctamente escrito
	
	public static Boolean checkCodigo(String codigo) {
		Boolean c = codigo.length() == 7 && Character.isDigit(codigo.charAt(0))
				&& Character.isDigit(codigo.charAt(1))
				&& Character.isDigit(codigo.charAt(2))
				&& Character.isDigit(codigo.charAt(3))
				&& Character.isDigit(codigo.charAt(4))
				&& Character.isDigit(codigo.charAt(5))
				&& Character.isDigit(codigo.charAt(6));

		return c;
	}

	// Métodos

	public String getNombre() {
		return nombre;
	}

	public String getAcronimo() {

		String abrev = "";

		for (int i = 0; i < nombre.length(); i++) {

			if (Character.isUpperCase(nombre.charAt(i))) {

				abrev = abrev + nombre.charAt(i);

			}

		}

		return abrev;
	}

	public String getCodigo() {
		return codigo;
	}

	public Double getCreditos() {
		return creditos;
	}

	public TipoAsignatura getTipo() {
		return tipo;
	}

	public Integer getCurso() {
		return curso;
	}

	public String getDepartamento() {
		return departamento;
	}

	// Representación como cadena

	public String toString() {
		return "(" + getCodigo() + ") " + getNombre();
	}

	// Criterio de igualdad

	public boolean equals(Object o) {
		boolean r = false;
		if (o instanceof Asignatura) {
			Asignatura a = (Asignatura) o;
			r = getCodigo().equals(a.getCodigo());
		}

		return r;
	}

	public int hashCode() {
		return getCodigo().hashCode() * 31;
	}

	// Criterio de ordenación

	public int compareTo(Asignatura a) {
		int r;
		if (a == null) {
			throw new ExcepcionAsignaturaNoValida();
		} else {
			r = getCodigo().compareTo(a.getCodigo());
		}

		return r;

	}

}
