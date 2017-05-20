package common.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormat {
	public static final String DIAS_SEMANA[] = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
	public static final String MESES[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	
	public static String formatedDateToString(String str){
		
		String[] strArray = str.split("/");
		int diaSemana = Integer.parseInt(strArray[0]);
		int dia = Integer.parseInt(strArray[1]);
		int mes = Integer.parseInt(strArray[2]);
		int anno = Integer.parseInt(strArray[3]);
		int hora = Integer.parseInt(strArray[4]);
		int min = Integer.parseInt(strArray[5]);
		int seg = Integer.parseInt(strArray[6]);
		String am = strArray[7];
		 return DIAS_SEMANA[diaSemana] + ", "+ dia + " de " + MESES[mes] + " del "+ anno + "   "+ hora + ":"+ min +  " "+ am;
	}
	
	public static String fechaToString(Date date){
		int anno = date.getYear() + 1900;
			  return DIAS_SEMANA[date.getDay()] + ", "+ date.getDate() + " de " + MESES[date.getMonth()] + " del "+ anno + "   "+ horaToString(date);
	}
	
	public static String horaToString(Date date){
		return date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}
	
	public static String dateToString(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy/hh/mm/ss/aaa");
		String formatedDate = simpleDateFormat.format(date);
		formatedDate = date.getDay()+"/"+formatedDate;
		return formatedDate;
	}
	
	@SuppressWarnings("deprecation")
	public static String getDateToString(){
		Calendar c = Calendar.getInstance();
		Date date = new Date(c.getTimeInMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy/hh/mm/ss/aaa");
		String formatedDate = simpleDateFormat.format(date);
		formatedDate = date.getDay()+"/"+formatedDate;
		System.out.println("getDateToString = "+formatedDate);
		return formatedDate;
	}
	
//	public static Date stringToDate( String str){
//		String[] strArray = str.split("/");
//		int dia = Integer.parseInt(strArray[1]);
//		int mes = Integer.parseInt(strArray[2]);
//		int anno = Integer.parseInt(strArray[3]);
//		int hora = Integer.parseInt(strArray[4]);
//		int min = Integer.parseInt(strArray[5]);
//		int seg = Integer.parseInt(strArray[6]);
//		
//		Date date = new Date(dia,mes,anno);
//		date.setHours(hora);
//		date.setMinutes(min);
//		date.setSeconds(seg);
//		
//		return date;
//	}
	
}
