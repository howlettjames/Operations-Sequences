import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OperacionesSecuencia {

	public Secuencia () {};

	public Par getParPorIndex (int index){ // Obtener un par por su index
		int i = 0;
		for (Par p : arr){
			if (i == index){
				return p;
			}
			i++;
		}
		return null;
	}

	public int getIndexOfPosition (int pos){ // Obtener indice de una posicion
		int i = 0;
		for (Par p : arr){
			if (p.getPos() == pos){
				return i;
			}
			i++;
		}
		return -1;
	}

	public void ordenarPorPosicion (){ // Ordenar el arreglo por posicion
		Collections.sort(arr, new Comparator<Par>() {
	    @Override
	    public int compare(Par o1, Par o2) {
	        return o1.getPos() - o2.getPos();
	    }
});
	}
}