import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		OperacionesSecuencia op = new OperacionesSecuencia ();
		Diezmacion d = new Diezmacion ();
		ArrayList <Par> arrA = new ArrayList <Par> ();
		ArrayList <Par> arrB = new ArrayList <Par> ();
		ArrayList <Par> arrC = new ArrayList <Par> ();
		/*for (int i = 0; i < 10; i++){
			arrA.add (new Par(i, i));
		}*/
		arrA.add (new Par (-2, -10));
		arrA.add (new Par (-1, 4));
		arrA.add (new Par (0, 0.25));
		arrA.add (new Par (1, -1));
		arrA.add (new Par (2, 0));
		arrA.add (new Par (3, 2));

		arrB.add (new Par (-3, 3));
		arrB.add (new Par (-2, -7));
		arrB.add (new Par (-1, 11));
		arrB.add (new Par (0, 9));
		arrB.add (new Par (1, -5));
		
		Convolucion a = new Convolucion ();
		op.imprimirArreglo (a.convolucionar(arrB, arrA));
		/*
		System.out.println ("Arreglo antes de diezmar 3:");
		op.imprimirArreglo (arrA);
		System.out.println ("Arreglo despues de diezmar 3:");
		arrB = d.diezmar (arrA, 3);
		op.imprimirArreglo (arrB);

		System.out.println ("Arreglo antes de diezmar 4:");
		op.imprimirArreglo (arrA);
		System.out.println ("Arreglo despues de diezmar 4:");
		arrB = d.diezmar (arrA, 4);
		op.imprimirArreglo (arrB);*/
	}
}