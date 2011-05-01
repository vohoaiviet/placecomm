/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package au.edu.latrobe.placecomm.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Tuan Nguyen
 * Inherit the idea from Chen, soupa
 */
public class DateTimeConversion {

    	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
	private static final SimpleDateFormat format =
		new SimpleDateFormat(DATE_TIME_FORMAT);


        public static String getCurrentDateTime(){
                Date dCurrent = new Date();
		return format.format(dCurrent);
	}

	public static Date parseTimestamp(String timestamp) throws ParseException {
		return format.parse(timestamp);
	}


        public static void main(String[] args) {

		String a = "2008-11-01T11:19:14";
		String b = "2009-11-01T08:08:30";
		Date date = null;
		try {
			date = parseTimestamp(a);
			System.out.println("a = " + date.toString());

			date = parseTimestamp(b);
			System.out.println("b = " + date.toString());

			System.out.println("Time now:");
                        Date d = new Date();
                        System.out.println(format.format(d));

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
