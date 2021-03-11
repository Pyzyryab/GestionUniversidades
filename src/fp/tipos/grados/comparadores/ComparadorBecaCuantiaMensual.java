package fp.tipos.grados.comparadores;

import java.util.Comparator;

import fp.tipos.grados.Beca;

public class ComparadorBecaCuantiaMensual implements Comparator<Beca> {

	public int compare(Beca b1, Beca b2) {

		int res= b1.getCuantiaMensual().compareTo(b2.getCuantiaMensual());
		if (res == 0) {
			res = b1.compareTo(b2);
		}
		return res;

	}

}
