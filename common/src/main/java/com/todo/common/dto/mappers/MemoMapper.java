package com.todo.common.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.todo.common.domain.MemoEntity;
import com.todo.common.dto.MemoDto;
import com.todo.common.domain.Memo;
import com.todo.common.domain.enums.Tag;

@Mapper(componentModel = "spring")
public interface MemoMapper {
    MemoMapper INSTANCE = Mappers.getMapper(MemoMapper.class);


    @Mapping(source = "tag", target = "tag", qualifiedByName = "StringToTagEnum")
    Memo MemoDtoToMemoMapper(MemoDto memoDto);

    MemoEntity MemoDTOToMemoEntityMapper(MemoDto memoDto);

    @Mapping(source = "tag", target = "tag", qualifiedByName = "StringToTagEnum")
    Memo MemoEntityToMemoMapper(MemoEntity memoEntity);

    @Named("StringToTagEnum")
    public static Tag StringToTagEnum(String stringEnum) {
        String upperCaseString = stringEnum.toUpperCase();
        return Tag.valueOf(upperCaseString);
    }
}
