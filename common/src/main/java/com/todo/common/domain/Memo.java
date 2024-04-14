package com.todo.common.domain;


import com.todo.common.domain.enums.Tag;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Memo {
    private int id;
    private String name;
    private Tag tag;
}
