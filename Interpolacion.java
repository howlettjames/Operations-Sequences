import java.util.ArrayList;

public class Interpolacion {
	public Interpolacion () {}

	public ArrayList <Par> interpolacionLineal (ArrayList <Par> arr, int k){
		if (k == 1) return arr;
		arr.add (new Par (-1000001, 0));
		ArrayList <Par> res = new ArrayList <Par> ();
		double dif;
		double add;
		//int currpos;
		//currpos = arr.get (0).getPos();
		for (int i = 0; i < arr.size() - 1; i++){
			dif = Math.abs ((arr.get (i).getValor() - arr.get (i + 1).getValor()) / k);
			if (arr.get (i).getValor() > arr.get (i + 1).getValor()){
				add = arr.get (i).getValor();
				if (arr.get(i).getPos() == 0){
					res.add (new Par (0, add));
				}
				else{
					res.add (new Par (-1000000, add));
				}
				
				for (int j = 0; j < k - 1; j++){
					add -= dif;
					res.add (new Par (-1000000, add));
				}
			}
			else if (arr.get (i).getValor() < arr.get (i + 1).getValor()){
				add = arr.get (i).getValor();
				if (arr.get(i).getPos() == 0){
					res.add (new Par (0, add));
				}
				else{
					res.add (new Par (-1000000, add));
				}
				for (int j = 0; j < k - 1; j++){
					add += dif;
					res.add (new Par (-1000000, add));
				}
			}
		}

		OperacionesSecuencia op = new OperacionesSecuencia();
		arr = op.completarIndices (res);

		return arr;
	}

	public ArrayList <Par> interpolacionCero (ArrayList <Par> arr, int k){
		if (k == 1) return arr;
		ArrayList <Par> res = new ArrayList <Par> ();
		for (Par p : arr){
			res.add (p);
			for (int i = 0; i < k - 1; i++){
				res.add (new Par (-10000, 0));
			}
		}
		OperacionesSecuencia op = new OperacionesSecuencia();
		arr = op.completarIndices (res);
		return arr;
	}

	public ArrayList <Par> interpolacionEscalon (ArrayList <Par> arr, int k){
		if (k == 1) return arr;
		ArrayList <Par> res = new ArrayList <Par> ();
		for (Par p : arr){
			res.add (p);
			for (int i = 0; i < k - 1; i++){
				res.add (new Par (-10000, p.getValor()));
			}
		}
		OperacionesSecuencia op = new OperacionesSecuencia();
		arr = op.completarIndices (res);
		return arr;
	}
}