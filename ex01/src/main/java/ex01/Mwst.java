package ex01;

public class Mwst {
	
	
	int brutto;
	double mwst = 0.26D;
	
	public static void main(String[] args) {
		
		Mwst test = new Mwst();
		
		System.out.println(test.berechnePreis(3301.92,'€'));
		System.out.println(test.berechnePreis2(3301.92,'€'));
		
		
		
		
		
	}
	
	 String berechnePreis2(double wert, char currency){
			
		double result = (wert*mwst) + wert;
		
		
		
		
		return "Die Ware kostet: "+result+currency;
	}
	
	
	
	 String berechnePreis(double wert, char currency){
		
		int valueInCents = (int) Math.round(wert*100D);
		
		double netto = (valueInCents * mwst) + valueInCents;
		
		int nettoCents = (int)Math.round(netto);
		
		double result = nettoCents/100D;
		
		
		return "Die Ware kostet: "+result+currency;
	}
	

}
