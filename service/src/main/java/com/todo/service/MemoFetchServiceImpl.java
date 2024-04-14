package com.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.todo.common.dto.MemoSearchDto;
import com.todo.common.dto.MemoTagSearchDto;
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

  @Override
  public List<MemoDto> fetchTagMemos(MemoTagSearchDto memoSearchDto) {
    MemoDto searchMemo1 = MemoDto.builder().id(1).name("Memo1").tag("Completed").build();
    MemoDto searchMemo2 = MemoDto.builder().id(2).name("Memo3").tag("Completed").build();
    // TODO return list Memo mock
    List<MemoDto> memoDtoList = new ArrayList<>();
    memoDtoList.add(searchMemo1);
    memoDtoList.add(searchMemo2);
    return memoDtoList;
  }

  @Override
  public List<MemoDto> fetchAllMemos() {
    MemoDto searchMemo1 = MemoDto.builder().id(1).name("Memo1").tag("Completed").build();
    MemoDto searchMemo2 = MemoDto.builder().id(2).name("Memo2").tag("Uncompleted").build();
    // TODO return list Memo mock
    List<MemoDto> memoDtoList = new ArrayList<>();
    memoDtoList.add(searchMemo1);
    memoDtoList.add(searchMemo2);
    return memoDtoList;
  }
}
