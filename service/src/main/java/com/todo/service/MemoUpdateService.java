package com.todo.service;

import com.todo.common.dto.MemoDto;

public interface MemoUpdateService {
    public void updateMemo(MemoDto memoDto);
    public void deleteMemo(MemoDto memoDto);
}
