package common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.util.Assert;

 
public class DateUtil {
 
	public final static String BOTH = "yyyy-MM-dd HH:mm:ss";
	 
	public final static String DATE = "yyyy-MM-dd";
	 
	public final static String TIME = "HH:mm:ss";
	 
	public static long MILLION_SECONDS_OF_DAY = 24 * 60 * 60 * 1000L;// 86400000
	 
	public static long MILLION_SECONDS_OF_HOUR = 60 * 60 * 1000L;// 3600000;

	private DateUtil() {

	}
 
	public static boolean isValidDate(String str, String fmt) {
		Date date = parse(str, fmt);
		if (date == null) {
			return false;
		}
		String dateStr = format(date, fmt);
		if (dateStr.equals(str)) {
			return true;
		}
		return false;
	}

	 
	public static Date parse(String str, String fmt) {
		if (NullJudgeUtil.isNotNull(fmt) && NullJudgeUtil.isNotNull(fmt)) {
			SimpleDateFormat simDateFormat = new SimpleDateFormat(fmt);
			Date date = null;
			try {
				date = simDateFormat.parse(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return date;
		}
		return null;		
	}

	 
	public static String format(Date date, String fmt) {
		if (NullJudgeUtil.isNotNull(fmt) && NullJudgeUtil.isNotNull(fmt)) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fmt);
		return simpleDateFormat.format(date);
		}else{
			return null;
		}
	}

	 
	public static Date addMonth(Date date, int months) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, months);
		return c.getTime();
	}

	 
	public static Date addDay(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, days);
		return c.getTime();
	}

	 
	public static String addDay(String str, int days, String fmt) {
		Calendar c = Calendar.getInstance();
		c.setTime(parse(str, fmt));
		c.add(Calendar.DAY_OF_MONTH, days);
		Date date = c.getTime();
		return format(date, fmt);
	}
 
	public static Date addMinutes(Date date, int minutes) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, minutes);
		return c.getTime();
	}

	 
	public static int subDateDays(Date sd, Date ed) {
		Long eds = ed.getTime();
		Long sds = sd.getTime();
		return (int) ((eds - sds) / MILLION_SECONDS_OF_DAY);
	}

	 
	public static int subDateDays(String sd, String ed) {
		Long eds = parse(ed, DATE).getTime();
		Long sds = parse(sd, DATE).getTime();
		return (int) ((eds - sds) / MILLION_SECONDS_OF_DAY);
	}
 
	public static boolean isContain(String begin, String end, String tBegin, String tEnd, String fmt) {
		long beginTime = parse(begin, fmt).getTime();
		long endTime = parse(end, fmt).getTime();
		long bTime = parse(tBegin, fmt).getTime();
		long eTime = parse(tEnd, fmt).getTime();
		if (bTime > endTime || eTime <= beginTime) {
			return false;
		}
		return true;
	}

	 
	public static XMLGregorianCalendar toXMLGC(String str, String fmt) {
		GregorianCalendar cal = new GregorianCalendar();
		XMLGregorianCalendar gc = null;
		try {
			Date date = parse(str, fmt);
			cal.setTime(date);
			gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gc;
	}
 
	public static Date toDate(String str) {
		return DatatypeConverter.parseDate(str).getTime();
	}

	public static void main(String[] args) {
		System.out.println(isValidDate("2010-03-31", DATE));
	}
}
