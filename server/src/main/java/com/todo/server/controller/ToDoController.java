package com.todo.server.controller;

import java.util.List;

import com.todo.common.domain.Memo;
import com.todo.common.dto.MemoTagSearchDto;
import com.todo.common.dto.MemoDto;
import com.todo.common.dto.MemoSearchDto;
import com.todo.common.dto.mappers.MemoMapper;
import com.todo.repository.MemoRepository;
import com.todo.service.MemoFetchService;
import com.todo.service.MemoSaveService;
import com.todo.service.MemoUpdateService;

import lombok.AllArgsConstructor;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class ToDoController {

  private final MemoFetchService memoFetchService;
  private final MemoSaveService memoSaveService;
  private final MemoUpdateService memoUpdateService;

  @PostMapping(value = "/post/single/memo")
  public ResponseEntity<Void> postMemo(@RequestBody MemoDto memoDto) {
    memoSaveService.saveMemo(memoDto);
    return ResponseEntity.accepted().build();
  }

  @GetMapping(value = "/get/single/memo")
  public ResponseEntity<Memo> getMemo(@RequestBody MemoSearchDto memoSearch) {
    Memo responseMemo = memoFetchService.fetchSingleMemo(memoSearch);
    return ResponseEntity.ok(responseMemo);
  }

  @GetMapping(value = "/get/tag/memo")
  public ResponseEntity<List<Memo>> getTagMemo(@RequestBody MemoTagSearchDto memoSearch) {
    List<Memo> responseMemo = memoFetchService.fetchTagMemos(memoSearch);
    return ResponseEntity.ok(responseMemo);
  }

  @GetMapping(value = "/get/all/memo")
  public ResponseEntity<List<Memo>> getAllMemos() {
    List<Memo> responseMemoList = memoFetchService.fetchAllMemos();
    return ResponseEntity.ok(responseMemoList);
  }

  @PatchMapping(value = "/patch/single/memo")
  public ResponseEntity<MemoDto> updateMemo(@RequestBody MemoDto memoDto) {
    memoUpdateService.updateMemo(memoDto);
    return ResponseEntity.ok(memoDto);
  }

  @DeleteMapping(value = "/delete/single/memo")
  public ResponseEntity<MemoDto> deleteMemo(@RequestBody MemoDto memoDto) {
//    Memo memo = MemoMapper.INSTANCE.MemoDtoToMemoMapper(memoDto);
    memoUpdateService.deleteMemo(memoDto);
    return ResponseEntity.ok(memoDto);
  }


}
