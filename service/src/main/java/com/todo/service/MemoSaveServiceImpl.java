package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.common.dto.MemoDto;
import com.todo.repository.MemoRepository;

import lombok.AllArgsConstructor;

@Service
public class MemoSaveServiceImpl implements MemoSaveService {
//    private final MemoRepository memoRepository;
//
//    @Autowired
//    public MemoSaveServiceImpl(MemoRepository memoRepository) {
//        this.memoRepository = memoRepository;
//    }

    @Override
    public void saveMemo(MemoDto memoDto) {
        // TODO interaction with db to save Memos
    }
}
