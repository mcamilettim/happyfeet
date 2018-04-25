package cl.camiletti.happyFeetWeb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import cl.camiletti.happyFeetWeb.model.Paciente;

@Component
public class DateUtil {
	public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public static String getFechaHoyString() {
		return dateFormat.format(getFechaHoyDate());
	}

	public static Date getFechaHoyDate() {
		return new Date();
	}

	public List<Paciente> setEdad(List<Paciente> pacientes) {
		for (Paciente paciente : pacientes) {
			paciente.setEdad(this.getAge(paciente.getFechaNacimiento()));
		}
		return pacientes;
	}

	public static String getHourSystem() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		//int seconds = calendar.get(Calendar.SECOND);
		return hours + ":" + minutes;
	}

	public String formatearFecha(String date) {
		String[] arr = date.split("-");
		return arr[2] + "/" + arr[1] + "/" + arr[0];

	}

	public int getAge(String nacimiento) {
		SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfBirth = null;
		try {
			dateOfBirth = (Date) input.parse(nacimiento);
		} catch (ParseException e) {
			System.out.print("error cambiando el formato de la fecha");
		}

		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();
		birthDate.setTime(dateOfBirth);
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("You don't exist yet");
		}
		int todayYear = today.get(Calendar.YEAR);
		int birthDateYear = birthDate.get(Calendar.YEAR);
		int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
		int birthDateDayOfYear = birthDate.get(Calendar.DAY_OF_YEAR);
		int todayMonth = today.get(Calendar.MONTH);
		int birthDateMonth = birthDate.get(Calendar.MONTH);
		int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
		int birthDateDayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
		int age = todayYear - birthDateYear;

		// If birth date is greater than todays date (after 2 days adjustment of leap
		// year) then decrement age one year
		if ((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)) {
			age--;

			// If birth date and todays date are of same month and birth day of month is
			// greater than todays day of month then decrement age
		} else if ((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)) {
			age--;
		}
		return age;
	}
}
