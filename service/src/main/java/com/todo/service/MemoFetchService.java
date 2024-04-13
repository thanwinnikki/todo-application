package com.todo.service;

import com.todo.common.dto.MemoSearchDto;
import com.todo.common.dto.domain.MemoDto;

public interface MemoFetchService {
  public MemoDto fetchSingleMemo(MemoSearchDto memoSearchDto);
}