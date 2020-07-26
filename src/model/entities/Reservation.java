package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumber() {
		return roomNumber;
	}

	public void setNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	//metudo para calcular a diferença de dias entre as datas
	public long duration() {
		//diferença em milisegundos entre as datas
		long diff = checkOut.getTime() - checkIn.getTime();
		//converte milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//metodo para validar as informações e alterar os dias da reserva
	public String updateDates(Date checkIn, Date checkOut) {
		
		//varivavel NOW recebera a data atual
		Date now = new Date();
		//se as datas checkIn ou checkOut for anterior a data atual o programa não executa
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		//se a data de checkOut for depois a checkIn o pragram não executa
		} 
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		//se as condições não retornar erro então o metódo retorna-rá nulo (não ouve erro na operação)
		return null;
	}
	
	//metodo toString também é uma sobreposição, por este motivo utilizamos o "Override"
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}

}
