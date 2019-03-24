package com.ysi.sequence.config;

import com.ysi.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
//@Configuration
public class SequenceGeneratorConfiguration {

	@Bean
	@DependsOn("datePrefixGenerator")
	public SequenceGenerator sequenceGenerator() {
		SequenceGenerator seqgen = new SequenceGenerator();
		//seqgen.setPrefixGenerator("30");
		seqgen.setInitial(100000);
		seqgen.setSuffix("A");
		return seqgen;
	}
}