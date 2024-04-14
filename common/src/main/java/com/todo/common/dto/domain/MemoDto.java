package com.todo.common.dto.domain;
import com.todo.common.dto.enums.Tag;

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
    Tag tag;
}
