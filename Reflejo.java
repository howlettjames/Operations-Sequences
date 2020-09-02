import java.util.ArrayList;

public class Reflejo {
	ArrayList <Par> arr;
	public Reflejo	(ArrayList <Par> arr){
		this.arr = arr;
	}

	public ArrayList <Par> reflejar (){
		for (Par p : arr){
			p.setPos(p.getPos() * (-1)); 
		}
		return arr;
	}
}