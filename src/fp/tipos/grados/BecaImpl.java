package fp.tipos.grados;

import fp.tipos.grados.excepciones.ExcepcionBecaNoValida;

public class BecaImpl implements Beca {

	// Atributos

	private String codigo;
	private Double cuantiaTotal;
	private Integer duracion;
	private TipoBeca tipo;
	private static final Double RETENCION = 0.18;
	private static final Double CUANTIA_MINIMA = 1500.0;

	// Constructores

	// Constructor becas con cuant�a y duraci�n desconocidas

	public BecaImpl(String codigo, TipoBeca tipoBeca) {
		if (checkCodigo(codigo)) {
			this.codigo = codigo;
		} else {
			throw new ExcepcionBecaNoValida("El c�digo es incorrecto.");
		}
		cuantiaTotal = CUANTIA_MINIMA;
		duracion = 1;
		this.tipo = tipoBeca;
	}

	public static Boolean checkCodigo(String codigo) {
		Boolean c = codigo.length() == 7
				&& Character.isLetter(codigo.charAt(0))
				&& Character.isLetter(codigo.charAt(1))
				&& Character.isLetter(codigo.charAt(2))
				&& Character.isDigit(codigo.charAt(3))
				&& Character.isDigit(codigo.charAt(4))
				&& Character.isDigit(codigo.charAt(5))
				&& Character.isDigit(codigo.charAt(6));

		return c;
	}

	// Constructor de datos conocidos

	public BecaImpl(String codigo, Double cuantiaTotal, Integer duracion,
			TipoBeca tipo) {

		// Excepciones a c�digo, cuant�a y duraci�n

		if (checkCodigo(codigo)) {
			this.codigo = codigo;
		} else {
			throw new ExcepcionBecaNoValida("El c�digo es incorrecto.");
		}

		if (cuantiaTotal >= CUANTIA_MINIMA) {
			this.cuantiaTotal = cuantiaTotal;
		} else {
			throw new ExcepcionBecaNoValida(
					"La cuant�a total es menor que 1500E.");
		}
		if (duracion >= 1) {
			this.duracion = duracion;
		} else {
			throw new ExcepcionBecaNoValida("La duraci�n es menor que un mes");
		}

		this.tipo = tipo;

	}

	// Metodos

	public String getCodigo() {
		return codigo;
	}

	public Double getCuantiaTotal() {
		return cuantiaTotal;
	}

	public void setCuantiaTotal(Double cuantiaTotal) {
		if (cuantiaTotal >= CUANTIA_MINIMA) {
			this.cuantiaTotal = cuantiaTotal;
		} else {
			throw new ExcepcionBecaNoValida(
					"La cuant�a total es menor que 1500E.");
		}

	}

	public Integer getDuracion() {

		return duracion;
	}

	public void setDuracion(Integer duracion) {
		if (duracion >= 1) {
			this.duracion = duracion;
		} else {
			throw new ExcepcionBecaNoValida("La duraci�n es menor que un mes");
		}

	}

	public TipoBeca getTipo() {
		return tipo;
	}

	public Double getCuantiaMensual() {
		Double cm = (cuantiaTotal - (cuantiaTotal * RETENCION)) / duracion;
		return cm;
	}

	// Representaci�n como cadena

	public String toString() {
		return "[" + getCodigo() + ", " + getTipo() + "]";
	}

	// Criterio de igualdad

	public boolean equals(Object o) {
		boolean r = false;
		if (o instanceof Beca) {
			Beca a = (Beca) o;
			r = this.getCodigo().equals(a.getCodigo())
					&& this.getTipo().equals(a.getTipo());
		}
		return r;
	}

	public int hashCode() {
		return getCodigo().hashCode() + getTipo().hashCode() * 31;
	}

	// M�todo de ordenaci�n

	public int compareTo(Beca a) {
		int r;
		if (a == null) {
			throw new ExcepcionBecaNoValida();
		} else {
			r = getCodigo().compareTo(a.getCodigo());
			if (r == 0) {
				r = getTipo().compareTo(a.getTipo());
			}
		}
		return r;
	}

}