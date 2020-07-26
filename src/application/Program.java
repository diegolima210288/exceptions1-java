package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	//retirado o comando THROWS para propagar as exe��es, pois nesta vers�o a exce��es ser�o tratadas
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
					
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			//variavel do tipo Date, por�m o SimpleDateFormat vai realizar a convers�o
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
		}
		//captura de exece��o caso o usu�rio digitar um formato de data errada.
		catch(ParseException e) {
			System.out.println("Invalid date format.");
		}
		//captura de exece��o caso metodo UPDATEDATES (classe Reservation) retornar erro
		catch(DomainException e) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}
		
		sc.close();

	}

}
