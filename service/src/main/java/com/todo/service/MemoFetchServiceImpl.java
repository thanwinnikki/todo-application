package com.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.todo.common.domain.Memo;
import com.todo.common.dto.MemoSearchDto;
import com.todo.common.dto.MemoTagSearchDto;
import com.todo.common.dto.MemoDto;
import com.todo.common.domain.enums.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemoFetchServiceImpl implements MemoFetchService{

  @Override
  public Memo fetchSingleMemo(MemoSearchDto memoSearchDto) {
    Memo searchMemo = Memo.builder().id(1).name("Memo1").tag(Tag.COMPLETED).build();
    return searchMemo;
  }

  @Override
  public List<Memo> fetchTagMemos(MemoTagSearchDto memoSearchDto) {
    Memo searchMemo1 = Memo.builder().id(1).name("Memo1").tag(Tag.COMPLETED).build();
    Memo searchMemo2 = Memo.builder().id(2).name("Memo3").tag(Tag.COMPLETED).build();
    // TODO return list Memo mock
    List<Memo> memoDtoList = new ArrayList<>();
    memoDtoList.add(searchMemo1);
    memoDtoList.add(searchMemo2);
    return memoDtoList;
  }

  @Override
  public List<Memo> fetchAllMemos() {
    Memo searchMemo1 = Memo.builder().id(1).name("Memo1").tag(Tag.COMPLETED).build();
    Memo searchMemo2 = Memo.builder().id(2).name("Memo2").tag(Tag.UNCOMPLETED).build();
    // TODO return list Memo mock
    List<Memo> memoDtoList = new ArrayList<>();
    memoDtoList.add(searchMemo1);
    memoDtoList.add(searchMemo2);
    return memoDtoList;
  }
}
