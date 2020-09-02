import java.util.ArrayList;

public class Diezmacion {
	public Diezmacion () {};

	public ArrayList <Par> diezmar (ArrayList <Par> arr, int n){
		ArrayList <Par> res = new ArrayList <Par> ();
		for (Par p :  arr){
			if (p.getPos() % n == 0){
				if (p.getPos() == 0){
					res.add (new Par (0, p.getValor()));
				}
				else {
					res.add (new Par (-100000, p.getValor())); // Valor tentativo, debe ser maxint o minint	
				}
			}
		}
		OperacionesSecuencia op = new OperacionesSecuencia();
		res = op.completarIndices (res);
		return res;
	}
}