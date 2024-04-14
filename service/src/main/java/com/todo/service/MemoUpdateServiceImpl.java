package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.common.domain.MemoEntity;
import com.todo.common.dto.MemoDto;
import com.todo.common.dto.mappers.MemoMapper;
import com.todo.repository.MemoEntityDao;


@Service
public class MemoUpdateServiceImpl implements  MemoUpdateService {

    private final MemoEntityDao memoEntityDao;

    @Autowired
    public MemoUpdateServiceImpl(MemoEntityDao memoEntityDao) {
        this.memoEntityDao = memoEntityDao;
    }

    @Override
    public void updateMemo(MemoDto memoDto) {
        MemoEntity memoEntity = MemoMapper.INSTANCE.MemoDTOToMemoEntityMapper(memoDto);
        memoEntityDao.update(memoEntity);
    }

    @Override
    public void deleteMemo(MemoDto memoDto) {
        MemoEntity memoEntity = MemoMapper.INSTANCE.MemoDTOToMemoEntityMapper(memoDto);
        memoEntityDao.deleteById(memoEntity.getId());
    }
}
