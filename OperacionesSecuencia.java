import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OperacionesSecuencia {

	public OperacionesSecuencia () {};

	public int getIndexOfPosition (ArrayList <Par> arr, int pos){ // Obtener indice de una posicion
		int i = 0;
		for (Par p : arr){
			// System.out.println ("pos: " + p.getPos());
			if (p.getPos() == pos){
				return i;
			}
			i++;
		}
		return -1;
	}

	public void ordenarPorPosicion (ArrayList <Par> arr){ // Ordenar el arreglo por posicion
		Collections.sort(arr, new Comparator<Par>() {
	    @Override
	    public int compare(Par o1, Par o2) {
	        return o1.getPos() - o2.getPos();
	    }
});
	}

	public void imprimirArreglo (ArrayList <Par> arr){
		for (int i = 0; i < arr.size(); i++){
			System.out.println ("Posicion: " + arr.get (i).getPos() + " " + "Valor: " + arr.get (i).getValor());
		}
	}

	public ArrayList <Par> completarIndices (ArrayList <Par> arr){
		// Encontrar indice de origen
		int i = getIndexOfPosition (arr, 0);
		//System.out.println ("Arreglo antes de primera pasada:");
		//imprimirArreglo (arr);

		//System.out.println ("Indice origen: " + i);

		// Indices negativos (es decir antes de 0)
		int j = i; // Para no perder indice de origen
		j *= -1;
		for (Par p : arr){
			if (j == 0){
				break;
			}
			p.setPos (j);
			j++;
		}
		//System.out.println ("Arreglo despes de primera pasada:");
		//imprimirArreglo (arr);

		// Indices positivos (es decir despues del 0)
		int l = 1;
		for (j = i + 1; j < arr.size(); j++){
			arr.get (j).setPos (l);
			l++;
		}
		//System.out.println ("Arreglo despes de segunda pasada:");
		//imprimirArreglo (arr);

		return arr;
	}
}