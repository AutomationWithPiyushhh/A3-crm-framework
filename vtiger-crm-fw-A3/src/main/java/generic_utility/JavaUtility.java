package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
	public static String getCurrentTime() {
		LocalDateTime now = LocalDateTime.now();
		String time = DateTimeFormatter.ofPattern("HHmmss_ddMMyyyy").format(now);

		return time;
	}
}
