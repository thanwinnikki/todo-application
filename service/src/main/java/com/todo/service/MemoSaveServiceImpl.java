package com.todo.service;

import org.springframework.stereotype.Service;

import com.todo.common.dto.domain.MemoDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemoSaveServiceImpl implements MemoSaveService {
    @Override
    public void saveMemo(MemoDto memoDto) {
        // TODO interaction with db to save Memos
    }
}
