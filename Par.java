public class Par {
	int pos; // posicion
	double valor; // magnitud

	public Par (int pos, double valor){
		this.pos = pos;
		this.valor = valor;
	}

	public int getPos (){
		return pos;
	}

	public double getValor (){
		return valor;
	}

	public void setPos (int pos){
		this.pos = pos;
	}

	public void setValor (double valor){
		this.valor = valor;
	}

	public void setValor (int valor){
		this.valor = (double) valor;
	}
}