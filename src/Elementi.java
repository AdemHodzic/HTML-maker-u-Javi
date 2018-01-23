import java.util.*;

public class Elementi {
	
	//Data field sa marginama,specijalnim marginama i brojem elemenata
	public static int brojElemenata=0;
	private static ArrayList<String> openMargin = new ArrayList<String>();
	private static ArrayList<String> closeMargin = new ArrayList<>();
	private static ArrayList<String> specialMargin = new ArrayList<>();
	
	Elementi(){
		
	}
	
	//Dodajemo nove margine
	public void addMargin(String margin) {
		openMargin.add("<"+margin+">");
		closeMargin.add("</"+margin+">");
		brojElemenata++;
	}
	//Dodajemo nove specijalne margin <>
	public void addSpecialMargin(String special) {
		specialMargin.add("<"+special+">");
		brojElemenata++;
	}
	
	//Vracamo array listu sa marginama
	public static ArrayList<String> getMargin(){
		return openMargin;
	}
	
	//Dodajemo margine u html
	public String add(int broj,String poruka) {
		return openMargin.get(broj)+poruka+closeMargin.get(broj);
	}
	
	//Dodajemo specijalne margine u html file
	public String add(int broj) {
		return specialMargin.get(broj);
	}
}
