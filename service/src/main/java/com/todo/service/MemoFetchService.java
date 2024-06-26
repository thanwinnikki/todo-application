package com.todo.service;

import java.util.List;

import com.todo.common.domain.Memo;
import com.todo.common.domain.MemoEntity;
import com.todo.common.domain.MemoTagSearch;
import com.todo.common.dto.MemoSearchDto;
import com.todo.common.dto.MemoTagSearchDto;

public interface MemoFetchService {
  public MemoEntity fetchSingleMemo(MemoSearchDto memoSearchDto);
  public List<MemoEntity> fetchTagMemos(MemoTagSearch memoSearchDto);
  public List<MemoEntity> fetchAllMemos();
}