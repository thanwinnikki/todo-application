package com.todo.server.controller;

import com.todo.common.dto.domain.MemoDto;
import com.todo.common.dto.MemoSearchDto;
import com.todo.service.MemoFetchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class ToDoController {

  private final MemoFetchService memoFetchService;

  @GetMapping(value = "/get")
  public ResponseEntity<MemoDto> getMemo(@RequestBody MemoSearchDto memoSearch) {
    MemoDto responseMemo = memoFetchService.fetchSingleMemo(memoSearch);
    return ResponseEntity.ok(responseMemo);
  }
}
