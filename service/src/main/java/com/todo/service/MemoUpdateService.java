package com.todo.service;

import com.todo.common.dto.domain.MemoDto;

public interface MemoUpdateService {
    public void updateMemo(MemoDto memoDto);
    public void deleteMemo(MemoDto memoDto);
}
