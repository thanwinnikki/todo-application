package com.todo.common.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.todo.common.domain.Memo;
import com.todo.common.domain.MemoEntity;
import com.todo.common.domain.MemoTagSearch;
import com.todo.common.dto.MemoDto;
import com.todo.common.dto.MemoTagSearchDto;


@Mapper(componentModel = "spring")
public interface MemoMapper {
    MemoMapper INSTANCE = Mappers.getMapper(MemoMapper.class);

    MemoEntity MemoDTOToMemoEntityMapper(MemoDto memoDto);
    MemoTagSearch MemoTagSearchDTOMapper(MemoTagSearchDto memoTagSearchDto);
    Memo MemoDTOMapper(MemoDto memoDto);
    MemoEntity MemoToMemoEntity(Memo memo);

}
