package com.todo.service;

import java.util.List;

import com.todo.common.domain.Memo;
import com.todo.common.domain.MemoEntity;
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
  public Memo fetchSingleMemo(MemoSearchDto memoSearchDto) {
//    Memo memo = Memo.builder().id(1).name("Memo1").tag(Tag.COMPLETED).build();
    MemoEntity memoEntity = memoEntityDao.findById(memoSearchDto.getId());

    Memo memo = MemoMapper.INSTANCE.MemoEntityToMemoMapper(memoEntity);
    return memo;
  }

  @Override
  public List<MemoEntity> fetchTagMemos(MemoTagSearchDto memoSearchDto) {
//    Memo searchMemo1 = Memo.builder().id(1).name("Memo1").tag(Tag.COMPLETED).build();
//    Memo searchMemo2 = Memo.builder().id(2).name("Memo3").tag(Tag.COMPLETED).build();
//    // TODO return list Memo mock
//    List<Memo> memoDtoList = new ArrayList<>();
//    memoDtoList.add(searchMemo1);
//    memoDtoList.add(searchMemo2);
    List<MemoEntity> memoList = memoEntityDao.findByTag(Tag.valueOf(memoSearchDto.getTag()));
    return memoList;
  }

  @Override
  public List<MemoEntity> fetchAllMemos() {
//    Memo searchMemo1 = Memo.builder().id(1).name("Memo1").tag(Tag.COMPLETED).build();
//    Memo searchMemo2 = Memo.builder().id(2).name("Memo2").tag(Tag.UNCOMPLETED).build();
//    // TODO return list Memo mock
//    List<Memo> memoDtoList = new ArrayList<>();
//    memoDtoList.add(searchMemo1);
//    memoDtoList.add(searchMemo2);
    List<MemoEntity> memoList = memoEntityDao.findAll();
    return memoList;
  }
}
