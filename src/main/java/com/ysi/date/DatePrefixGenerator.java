package com.ysi.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
public class DatePrefixGenerator implements PrefixGenerator {

	private DateFormat formatter;

	public void setPattern(String pattern) {
		this.formatter = new SimpleDateFormat(pattern);
	}

	@Override
	public String getPrefix() {
		return formatter.format(new Date());
	}

}