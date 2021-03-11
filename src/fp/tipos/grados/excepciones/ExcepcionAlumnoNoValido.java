package fp.tipos.grados.excepciones;

public class ExcepcionAlumnoNoValido extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionAlumnoNoValido(){
		super ();
	}

	public ExcepcionAlumnoNoValido(String message){
		super (message);
	}
}
