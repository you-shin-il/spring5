package com.ysi.sequence.service;

import com.ysi.sequence.dao.SequenceDao;
import com.ysi.sequence.vo.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 유신일
 * @since 2019-03-23
 */
@Component
public class SequenceService {
	@Autowired
	private SequenceDao sequenceDao;

	public SequenceService(SequenceDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}

	public String generate(String sequenceId) {
		Sequence sequence = sequenceDao.getSequence(sequenceId);
		int value = sequenceDao.getNextValue(sequenceId);
		return sequence.getPrefix() + value + sequence.getPrefix();
	}
}