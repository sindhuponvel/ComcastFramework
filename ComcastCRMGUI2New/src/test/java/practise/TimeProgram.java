package practise;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TimeProgram {
	@Test
	public void getDateAndTime() {

		Date dateObj = new Date();
		System.out.println(dateObj);
		System.out.println(dateObj.toString().replace(" ", "_").replace(":", "_"));

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sim.format(dateObj));

		// getting required date

		Calendar cal = sim.getCalendar();
		cal.add(cal.DAY_OF_MONTH, 60);
		System.out.println(sim.format(cal.getTime()));

	}

}
