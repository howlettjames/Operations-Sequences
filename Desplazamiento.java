import java.util.ArrayList;

public class Desplazamiento {
	ArrayList <Par> arr;
	public Desplazamiento	(ArrayList <Par> arr){
		this.arr = arr;
	}

	public ArrayList <Par> desplazar (int n){
		if (n < 0){
			for (Par p : arr){
				p.setPos(p.getPos() + (n*-1)); 
			}
		}
		else {
			for (Par p : arr){
				p.setPos(p.getPos() - n); 
			}
		}
		return arr;
	}
}