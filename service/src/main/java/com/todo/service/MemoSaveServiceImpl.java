package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.common.domain.Memo;
import com.todo.common.domain.MemoEntity;
import com.todo.common.dto.MemoDto;
import com.todo.common.dto.mappers.MemoMapper;
import com.todo.repository.MemoEntityDao;

import lombok.AllArgsConstructor;

@Service
public class MemoSaveServiceImpl implements MemoSaveService {
    private final MemoEntityDao memoEntityDao;

    @Autowired
    public MemoSaveServiceImpl(MemoEntityDao memoEntityDao) {
        this.memoEntityDao = memoEntityDao;
    }

    @Override
    public void saveMemo(MemoDto memoDto) {
        // TODO interaction with db to save Memos
        MemoEntity memoEntity = MemoMapper.INSTANCE.MemoDTOToMemoEntityMapper(memoDto);
        memoEntityDao.save(memoEntity);
    }
}
