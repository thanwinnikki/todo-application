package com.todo.server.controller;

import java.util.List;

import com.todo.common.domain.Memo;
import com.todo.common.domain.MemoEntity;
import com.todo.common.domain.MemoTagSearch;
import com.todo.common.dto.MemoTagSearchDto;
import com.todo.common.dto.MemoDto;
import com.todo.common.dto.MemoSearchDto;
import com.todo.common.dto.mappers.MemoMapper;
import com.todo.service.MemoFetchService;
import com.todo.service.MemoSaveService;
import com.todo.service.MemoUpdateService;

import lombok.AllArgsConstructor;

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
    Memo memo = MemoMapper.INSTANCE.MemoDTOMapper(memoDto);
    memoSaveService.saveMemo(memo);
    return ResponseEntity.accepted().build();
  }

  @GetMapping(value = "/get/single/memo")
  public ResponseEntity<MemoEntity> getMemo(@RequestBody MemoSearchDto memoSearch) {
    MemoEntity responseMemo = memoFetchService.fetchSingleMemo(memoSearch);
    return ResponseEntity.ok(responseMemo);
  }

  @GetMapping(value = "/get/tag/memo")
  public ResponseEntity<List<MemoEntity>> getTagMemo(@RequestBody MemoTagSearchDto memoTagSearchDto) {
    MemoTagSearch memoTagSearch = MemoMapper.INSTANCE.MemoTagSearchDTOMapper(memoTagSearchDto);
    List<MemoEntity> responseMemo = memoFetchService.fetchTagMemos(memoTagSearch);
    return ResponseEntity.ok(responseMemo);
  }

  @GetMapping(value = "/get/all/memo")
  public ResponseEntity<List<MemoEntity>> getAllMemos() {
    List<MemoEntity> responseMemoList = memoFetchService.fetchAllMemos();
    return ResponseEntity.ok(responseMemoList);
  }

  @PatchMapping(value = "/patch/single/memo")
  public ResponseEntity<MemoDto> updateMemo(@RequestBody MemoDto memoDto) {
    memoUpdateService.updateMemo(memoDto);
    return ResponseEntity.ok(memoDto);
  }

  @DeleteMapping(value = "/delete/single/memo")
  public ResponseEntity<MemoDto> deleteMemo(@RequestBody MemoDto memoDto) {
    memoUpdateService.deleteMemo(memoDto);
    return ResponseEntity.ok(memoDto);
  }


}
