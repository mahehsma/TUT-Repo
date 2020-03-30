package pr2.pu1;

public class ReelleZahl extends KomplexeZahl {
	
	/**
	 * 
	 * @param re 	real part of complex number
	 */
	
	// number without imaginary part
	public ReelleZahl(double re) {
		super(re, 0);
	}

	@Override
	public String toString() {
		return String.format("%.1f", re);
	}
}
