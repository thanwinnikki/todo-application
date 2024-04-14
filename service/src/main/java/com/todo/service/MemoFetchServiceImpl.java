package com.todo.service;

import java.util.List;

import com.todo.common.domain.Memo;
import com.todo.common.domain.MemoEntity;
import com.todo.common.domain.MemoTagSearch;
import com.todo.common.dto.MemoSearchDto;
import com.todo.common.dto.MemoTagSearchDto;
import com.todo.common.domain.enums.Tag;
import com.todo.common.dto.mappers.MemoMapper;
import com.todo.repository.MemoEntityDao;

import org.springframework.stereotype.Service;

@Service
public class MemoFetchServiceImpl implements MemoFetchService{

  private final MemoEntityDao memoEntityDao;

  public MemoFetchServiceImpl(MemoEntityDao memoEntityDao) {
    this.memoEntityDao = memoEntityDao;
  }

  @Override
  public MemoEntity fetchSingleMemo(MemoSearchDto memoSearchDto) {
    MemoEntity memoEntity = memoEntityDao.findById(memoSearchDto.getId());
    return memoEntity;
  }

  @Override
  public List<MemoEntity> fetchTagMemos(MemoTagSearch memoSearchDto) {
    List<MemoEntity> memoList = memoEntityDao.findByTag(memoSearchDto.getTag());
    return memoList;
  }

  @Override
  public List<MemoEntity> fetchAllMemos() {
    List<MemoEntity> memoList = memoEntityDao.findAll();
    return memoList;
  }
}
