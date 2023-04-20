import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {



	
	private static List Lista = new List();
	
	public static void main ( String[] args ) {
		
		Scanner input = new Scanner(System.in);
		
		int option;
		boolean exit = false;
		
		do {
			
			System.out.println("Inserire opzione\n"
							 + "0) aggiungere un invitato"+"\n"
							 + "1) remuovere un invitato"+"\n"
							 + "2) stampa invitati"+"\n"
							 + "3) exit"+"\n");

			option = input.nextInt();
			
			while ( !(option >= 0 && option <= 3) ) {
				System.out.println("\n\topzione non disponobile, riprova");
				option = input.nextInt();
			}
			
			

			switch (option) {
			
			case 0: // new invitato
					
					Lista.Add(InputInvitato());
					
				break;
				
			case 1: // remove invitato
					
					try {
						
						Lista.Remove(SelectResuorce());
						
					}
					catch ( IndexNotValidException e ) {
						System.out.println(e.getMessage());
					}
					catch ( EmptyListException e ) {
						System.out.println(e.getMessage());
					}
				
					
				break;
				
			case 2: // print
				
					try {
						
						for ( int i = 0 ; i < Lista.Size() ; i += 1 ) {
							System.out.println(Lista.getData(i).getSurname() + Lista.getData(i).getName());
							
						}
					}
					catch ( IndexNotValidException e ) {
						System.out.println(e.getMessage());
					}
					catch ( EmptyListException e ) {
						System.out.println(e.getMessage());
					}
				
					
				break;
				
			case 3: // exit for program
				exit = true;
				break;

			}
			
			
			
		}
		while( !exit );
		
		
		input.close();
		
	}
	
	private static Data InputInvitato () {
		Scanner input = new Scanner(System.in);
		
		String Str1;
		String Str2;
		LocalDate Date1;
		int Int1;

		boolean exit = true;
		Data output = null;
		do {
			
			System.out.println("inserire nome\n");
			Str1 = input.next();
			System.out.println("inserire cognome\n");
			Str2 = input.next();
			System.out.println("inserire data di nascita\n");
			Date1 = dateInput(input.next());
			System.out.println("inserire eta\n");
			Int1 = input.nextInt();

			 try { 
				output = new Data(
								Str1,
								Str2,
								Date1,
								Int1);
				
			 } catch ( Exception e ) {
				 System.out.println(e.getMessage());
				 exit = false;
			 }
			 
			}while ( !exit );
		
		input.close();
		
		return output;
		
	}
		
	private static int SelectResuorce () throws IndexNotValidException {
		Scanner input = new Scanner(System.in);
		
		int option;
		
		try {
			
			for ( int i = 0 ; i < Lista.Size() ; i += 1 ) {
				System.out.println(i + ") " + Lista.getData(i).getSurname());
			}
			
		}
		catch ( IndexNotValidException e ) {
			System.out.println(e.getMessage());
			throw new IndexNotValidException();
		}
		catch ( EmptyListException e ) {
			System.out.println(e.getMessage());
		}
		
		option = input.nextInt();
		
		while ( option >= 0 && option < Lista.Size() ) {
			System.out.println("\n\tinvitato non disponobile, riprova");
			option = input.nextInt();
			
		}
		
		
		input.close();
		
		return option;
	}
	
	
	
	
	public static LocalDate dateInput(String userInput) {

	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate date = LocalDate.parse(userInput, dateFormat);


	    //System.out.println(date);
	    return date ;
	}
	
	
	
}