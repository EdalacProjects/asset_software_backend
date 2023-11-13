package co.com.asset.util.exception;

import java.time.LocalDateTime;

public class DateUtils {

	public static LocalDateTime convertToLocalDateTime(String date) {
		return LocalDateTime.parse(date);
	}
}
