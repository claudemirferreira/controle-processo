package br.com.ieadam.componentes;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

	public static void main(String[] args) {
		pegarAnocorrente();
	}

	public static int pegarMescorrente() {
		Date data = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		Format format = new SimpleDateFormat("MM");
		System.out.println(Integer.parseInt(format.format(c.getTime())));

		return Integer.parseInt(format.format(c.getTime()));
	}

	public static int pegarAnocorrente() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		System.out.println(year);

		return year;
	}
}