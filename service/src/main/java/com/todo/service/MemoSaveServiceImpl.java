package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.common.domain.Memo;
import com.todo.common.domain.MemoEntity;
import com.todo.common.dto.mappers.MemoMapper;
import com.todo.repository.MemoEntityDao;

@Service
public class MemoSaveServiceImpl implements MemoSaveService {
    private final MemoEntityDao memoEntityDao;

    @Autowired
    public MemoSaveServiceImpl(MemoEntityDao memoEntityDao) {
        this.memoEntityDao = memoEntityDao;
    }

    @Override
    public void saveMemo(Memo memoDto) {
        MemoEntity memoEntity = MemoMapper.INSTANCE.MemoToMemoEntity(memoDto);
        memoEntityDao.save(memoEntity);
    }
}
