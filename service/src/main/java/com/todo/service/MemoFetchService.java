package com.todo.service;

import java.util.List;

import com.todo.common.domain.Memo;
import com.todo.common.dto.MemoSearchDto;
import com.todo.common.dto.MemoTagSearchDto;
import com.todo.common.dto.MemoDto;

public interface MemoFetchService {
  public Memo fetchSingleMemo(MemoSearchDto memoSearchDto);
  public List<Memo> fetchTagMemos(MemoTagSearchDto memoSearchDto);
  public List<Memo> fetchAllMemos();
}