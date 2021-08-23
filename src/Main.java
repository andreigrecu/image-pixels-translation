import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	//varargs - calculez suma diferitilor timpi inregistrati pentru anumite operatii
	static void sumExecutionTime(long ...argument) {
		long suma = 0;
		System.out.println("Number of arguments:" + argument.length);
		for(long i : argument) {
			suma = suma + i;
		}
		
		System.out.println("Suma timpului înregistrat în datele de intrare este: " + suma);
	}
	
	
	public static void main(String... args) throws InterruptedException {
		
		long first, second, third;
		boolean done = false;
	
		
		Scanner in = new Scanner(System.in); //asteptam primirea constantei
		int ics, igrec;
		//String cale = "D:/rose.jpg";

		System.out.println("Translatare imagine...");
		
		while (!done) {
		    //calcul timp executie citire din fisier
		    long first1 = System.currentTimeMillis();
		    Image img = new Image(args[0]); //in args[0] am setat calea catre fisierul de unde se ia imaginea
		    long first2 = System.currentTimeMillis();
		    first = first2 - first1;
		    TranslateImage imgnoua;
		    
		    System.out.println("Latimea imaginii este: " + img.getImg().getWidth());
			System.out.println("Inaltimea imaginii este:" + img.getImg().getHeight()); //in numar de pixeli
		    while (true) {
				try {// citire coordonate de la tastatura
					System.out.println("Introduceti coordonata x:");
					ics = in.nextInt();
					System.out.println("Introduceti coordonata y:");
					igrec = in.nextInt();
					
					imgnoua = new TranslateImage(ics, igrec, img);
					long second1 = System.currentTimeMillis();
					imgnoua.translateImage();
					long second2 = System.currentTimeMillis();
					second = second2 - second1; // timpul inregistrat la translatia imaginii
					break;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Coordonate invalide!");
				} catch (InputMismatchException e) {
					System.out.println("Coordonata nu este numar intreg!");
					in.nextLine();
				}//daca x si y pentru translatie date de utilizator nu sunt numere intregi sau nu sunt in intervalul
				//setat de dimensiunile imaginii are loc o eroare - tratare de exceptii
			}
		    

			  long third1 = System.currentTimeMillis();
			  imgnoua.getImg().writeInFile(args[1]);
			  long third2 = System.currentTimeMillis();
			  third = third2 - third1; //timpul inregistrat la scrierea in fisier a imaginii translatate
		    
		     
		    //afisare timpi fiecare operatie
		    System.out.println("Etapa de citire: " + first + " ms");
			System.out.println("Etapa de translatare: " + second + " ms");
			System.out.println("Etapa de salvare: " + third + " ms\n\n");
			sumExecutionTime(first);
			sumExecutionTime(first, second, third);
			System.out.println("Doriti sa repetati? (1 - YES/0 - NO)"); //daca utilizator vrea sau nu sa repete operatiile,
			//dand alte valori pentru translatie

			// folosit pentru a incheia programul
			int r = in.nextInt();
			if(r == 1)
				done = false;
			else
				done = true;	
					
		}
		//la finalizare
		System.out.println("Program terminat!!");
		in.close();
				
	}
	
}
