import java.util.ArrayList;

public class Aritmetica {
	OperacionesSecuencia op = new OperacionesSecuencia();
	
	public Aritmetica (){};

	public ArrayList <Par> suma (ArrayList <Par> arrA, ArrayList <Par> arrB){
		int i = 0, aux = 0;
		ArrayList <Par> res = new ArrayList <Par> ();
		for (Par p : arrA){
			aux = op.getIndexOfPosition(arrB, p.getPos());
			if (aux != -1){
				res.add (new Par (p.getPos(), p.getValor() + arrB.get(aux).getValor()));
			}
			else {
				res.add (new Par (p.getPos(), p.getValor()));	
			}
		}
		for (Par p : arrB){
			aux = op.getIndexOfPosition(res, p.getPos());
			if (aux == -1){
				res.add (new Par (p.getPos(), p.getValor()));
			}
		}
		return res;
	}

	public ArrayList <Par> resta (ArrayList <Par> arrA, ArrayList <Par> arrB){
		int i = 0, aux = 0;
		ArrayList <Par> res = new ArrayList <Par> ();
		for (Par p : arrA){
			aux = op.getIndexOfPosition(arrB, p.getPos());
			if (aux != -1){
				res.add (new Par (p.getPos(), p.getValor() - arrB.get(aux).getValor()));
			}
			else {
				res.add (new Par (p.getPos(), p.getValor()));	
			}
		}
		for (Par p : arrB){
			aux = op.getIndexOfPosition(res, p.getPos());
			if (aux == -1){
				res.add (new Par (p.getPos(), p.getValor()));
			}
		}
		return res;	
	}

	public ArrayList <Par> multiplicacion (ArrayList <Par> arrA, ArrayList <Par> arrB){
		int i = 0, aux = 0;
		ArrayList <Par> res = new ArrayList <Par> ();
		for (Par p : arrA){
			aux = op.getIndexOfPosition(arrB, p.getPos());
			if (aux != -1){
				res.add (new Par (p.getPos(), p.getValor() * arrB.get(aux).getValor()));
			}
			else {
				res.add (new Par (p.getPos(), 0));	
			}
		}
		for (Par p : arrB){
			aux = op.getIndexOfPosition(res, p.getPos());
			if (aux == -1){
				res.add (new Par (p.getPos(), 0));
			}
		}
		return res;	
	}
}