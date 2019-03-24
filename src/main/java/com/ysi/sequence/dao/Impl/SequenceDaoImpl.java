package com.ysi.sequence.dao.Impl;

import com.ysi.sequence.dao.SequenceDao;
import com.ysi.sequence.vo.Sequence;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
@Component("sequenceDao")
public class SequenceDaoImpl implements SequenceDao {

	private final Map<String, Sequence> sequences = new HashMap<>();
	private final Map<String, AtomicInteger> values = new HashMap<>();

	public SequenceDaoImpl() {
		sequences.put("IT", new Sequence("IT", "30", "A"));
		values.put("IT", new AtomicInteger(100000));
	}

	@Override
	public Sequence getSequence(String sequenceId) {
		return sequences.get(sequenceId);
	}

	@Override
	public int getNextValue(String sequenceId) {
		AtomicInteger value = values.get(sequenceId);
		return value.getAndIncrement();
	}

}