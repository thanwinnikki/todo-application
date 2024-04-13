package com.todo.common.dto.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class MemoDto {
    int id;
    String name;
    String tag;
}
