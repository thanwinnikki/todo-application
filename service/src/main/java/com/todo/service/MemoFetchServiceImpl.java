package com.todo.service;

import com.todo.common.dto.MemoSearchDto;
import com.todo.common.dto.domain.MemoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemoFetchServiceImpl implements MemoFetchService{

  @Override
  public MemoDto fetchSingleMemo(MemoSearchDto memoSearchDto) {
    MemoDto searchMemo = MemoDto.builder().id(1).name("Memo1").tag("Completed").build();
    return searchMemo;
  }
}
