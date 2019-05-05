package clases;

public class Promocion {

	private int costo;
	private double vigencia;

	public Promocion(int costo, double vigencia) {

		this.costo = costo;
		this.vigencia = vigencia;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public double getVigencia() {
		return vigencia;
	}

	public void setVigencia(double vigencia) {
		this.vigencia = vigencia;
	}

    public void aplicarDescuento(){
    	
    }


}
