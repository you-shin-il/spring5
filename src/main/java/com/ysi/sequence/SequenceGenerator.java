package com.ysi.sequence;

import com.ysi.date.PrefixGenerator;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
public class SequenceGenerator {
	private PrefixGenerator prefixGenerator;
	private String suffix;
	private int initial;
	private final AtomicInteger counter = new AtomicInteger();


	public String getSuffix() {
		return suffix;
	}

	public int getInitial() {
		return initial;
	}

	public AtomicInteger getCounter() {
		return counter;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public PrefixGenerator getPrefixGenerator() {
		return prefixGenerator;
	}

	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}

	public String getSequence() {
		StringBuilder builder = new StringBuilder();
		builder.append(prefixGenerator.getPrefix())
				.append(initial)
				.append(counter.getAndIncrement())
				.append(suffix);

		return builder.toString();
	}

}