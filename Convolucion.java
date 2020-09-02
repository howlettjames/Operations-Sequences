import java.util.ArrayList;

public class Convolucion 
{
	public Convolucion () {}

	public ArrayList <Par> convolucionar (ArrayList <Par> arr1, ArrayList <Par> arr2) {
		ArrayList <Par> res = new ArrayList <Par> ();
		ArrayList <Par> resfinal = new ArrayList <Par> ();
		int indiceRes = arr1.get (0).getPos() + arr2.get (0).getPos();
		int currentFirst = 0;
		int i = 0;
		Aritmetica a = new Aritmetica ();
		
		for (Par p1 : arr1){
			i = currentFirst;
			for (Par p2 : arr2){
				res.add(new Par (i, p1.getValor() * p2.getValor()));
				i++; 
			}
			currentFirst++;
			resfinal = a.suma (resfinal, res);
			res = new ArrayList <Par> ();
		}

		for (Par p : resfinal){
			p.setPos (indiceRes++);
		}

		return resfinal;
	}
	
}
