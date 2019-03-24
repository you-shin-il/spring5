package com.ysi.sequence.vo;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
public class Sequence {
	private final String id;
	private final String prefix;
	private final String suffix;

	public Sequence(String id, String prefix, String suffix) {
		this.id = id;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public String getId() {
		return id;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}
}
