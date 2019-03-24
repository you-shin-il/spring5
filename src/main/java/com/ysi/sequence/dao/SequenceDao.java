package com.ysi.sequence.dao;

import com.ysi.sequence.vo.Sequence;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
public interface SequenceDao {
	public Sequence getSequence(String sequenceId);

	public int getNextValue(String sequenceId);
}