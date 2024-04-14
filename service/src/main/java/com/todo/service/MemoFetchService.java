package com.todo.service;

import java.util.List;

import com.todo.common.dto.MemoSearchDto;
import com.todo.common.dto.MemoTagSearchDto;
import com.todo.common.dto.domain.MemoDto;

public interface MemoFetchService {
  public MemoDto fetchSingleMemo(MemoSearchDto memoSearchDto);
  public List<MemoDto> fetchTagMemos(MemoTagSearchDto memoSearchDto);
  public List<MemoDto> fetchAllMemos();
}