import java.io.*;
import java.util.*;

public class Main {

	public static String generatePoruka() {
		System.out.println("Unesite vasu poruku: ");
		String poruka = (new Scanner(System.in)).nextLine();
		return poruka;
	}
	
	public static void main(String[] args) {
		try {

			Scanner console = new Scanner(System.in);
			
			System.out.println("Pozdrav, dobrodosli u Ademov program za kreiranje web stranica.");
			System.out.println("hajde da pocnemo!");
			System.out.println("izaberite kako ce se zvati vas fajl");
			String imeFajla = console.nextLine();
			//Potrebni input i ouput
			File file = new File(".\\"+imeFajla+".html");
			PrintWriter input = new PrintWriter(
					new BufferedWriter(
							new FileWriter(file)));
			Elementi element = new Elementi();
			int brojElemenata = 0;
			
			
			//Rucno unosimo neke element koje mozemo korisiti i spremamo u temp array listu da mozem iterirati u while petlji
			element.addMargin("p");
			element.addMargin("div");
			element.addMargin("q");
			
			//unosimo <html> i <head> tag
			input.println("<html>");
			input.println("<head>");
			
			//Unosimo title stranice
			System.out.println("Unesite title za vas web page: ");
			String title = console.nextLine();
			
			//Unosimo <title> i <body> tag i zatvaramo <head>
			input.println("<title>"+title+"</title>");
			input.println("</head>");
			input.println("<body>");
			
			//unosimo ostale elemtne
			while(true) {
				System.out.println("Izaberite neku od sljedecih opcija: ");
				for(int i = 0;i<Elementi.brojElemenata;i++) {
					System.out.println((i+1) + ". " + Elementi.getMargin().get(i));
				}
				System.out.println(Elementi.brojElemenata+1+". Izlaz");
				
				int unos = console.nextInt();
				unos--;
				if(unos<0 || unos>Elementi.brojElemenata) {
					System.out.println("Pogresan unos! Pokusajte ponovno. ");
					continue;
				}else if(unos==Elementi.brojElemenata) {
					System.out.println("Hvala vam sto ste koristili nas program!");
					break;
				}else {
					String msg = generatePoruka();
					input.println(element.add(unos,msg));
				}
			}
			
			//Zatvaramo <body> i <html>
			input.println("</body>");
			input.println("</html>");
			
			//Zatavramo console(Scanner) i input(PrintWriter)
			console.close();
			input.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
