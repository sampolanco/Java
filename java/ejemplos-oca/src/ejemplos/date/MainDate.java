package ejemplos.date;

import java.util.Calendar;
import java.util.Date;

import static java.lang.System.out;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MainDate {

	private void isAfter(boolean v8) {
		if(!v8) {
			Calendar inicio= Calendar.getInstance();
			Calendar fin= Calendar.getInstance();
			inicio.set(1, 8, 1994);
			boolean isAfter=inicio.after(fin);
			out.println(isAfter);
		}
		else {
			LocalDate inicio1 =LocalDate.now();
			LocalDate fin1 =LocalDate.of(1994, 7, 1);
			boolean isAfter1=inicio1.isAfter(fin1);
			out.println(isAfter1);
			
			LocalTime inicio2=LocalTime.now();
			LocalTime fin2=LocalTime.of(8, 0);
			boolean isAfter2=inicio2.isAfter(fin2);
			out.println(isAfter2);
			
			LocalDateTime inicio3 =LocalDateTime.now();
			LocalDateTime fin3 =LocalDateTime.of(1994, 7, 1,8,0);
			boolean isAfter3=inicio3.isAfter(fin3);
			out.println(isAfter3);
			
		}
	}
	private void medirTiempo(boolean v8) throws InterruptedException {
		if(!v8) {
			long inicio=System.currentTimeMillis();
			Thread.sleep(200);
			long fin=System.currentTimeMillis();
			out.println(fin-inicio);
		}
		else {
			Instant ini=Instant.now();
			Thread.sleep(200);
			Instant fin=Instant.now();
			
			out.println(Duration.between(ini, fin).toMillis());
		}
	}
	
	private void periodoEntreFechas(boolean v8) {
		if(!v8) {
			Calendar inicio= Calendar.getInstance();
			Calendar fin= Calendar.getInstance();
			inicio.set(1994,8,1);
			int anios=0;
			while(inicio.before(fin)) {
				anios++;
				inicio.add(Calendar.YEAR, 1);
			}
			out.println(anios);
		}
		else {
			LocalDate inicio1 =LocalDate.of(1994, 7, 1);
			LocalDate fin1 =LocalDate.now();
			Period periodo=Period.between(inicio1, fin1);
			out.println(periodo.getYears());
		}
	}
	
	private void format(boolean v8) throws ParseException {
		if(!v8) {
			String fechaStr="19-04-2020";
			DateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
			
			Date fechaConvertida=formato.parse(fechaStr);
			Calendar fecha=Calendar.getInstance();
			fecha.setTime(fechaConvertida);
			out.println(fecha.getTime());
			
			Date fechaActual = Calendar.getInstance().getTime();
			String fechaActualStr=formato.format(fechaActual);
			out.println(fechaActualStr);
		}
		else {
			String fechaStr="19-04-2020";
			DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate fecha =LocalDate.parse(fechaStr, formato);
			out.println(formato);
			
			LocalDate fechaActual=LocalDate.now();
			String fechaActualStr=formato.format(fechaActual);
			out.println(fechaActualStr);
		}
	}
	public static void main(String[] args) {
		MainDate main =new MainDate();
		main.isAfter(true);
		try {
			main.medirTiempo(true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		main.periodoEntreFechas(true);
		try {
			main.format(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
