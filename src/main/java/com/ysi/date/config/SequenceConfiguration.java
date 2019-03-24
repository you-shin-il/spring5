package com.ysi.date.config;

import com.ysi.date.DatePrefixGenerator;
import com.ysi.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
@Configuration
public class SequenceConfiguration {

	@Bean
	public DatePrefixGenerator datePrefixGenerator() {
		DatePrefixGenerator dpg = new DatePrefixGenerator();
		dpg.setPattern("yyyyMMdd");
		return dpg;
	}

	@Bean
	public SequenceGenerator sequenceGenerator() {
		SequenceGenerator sequence = new SequenceGenerator();
		sequence.setInitial(100000);
		sequence.setSuffix("A");
		sequence.setPrefixGenerator(datePrefixGenerator());
		return sequence;
	}
}