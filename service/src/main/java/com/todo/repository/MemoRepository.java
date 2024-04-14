package com.todo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.todo.common.domain.MemoEntity;

@Repository
public interface MemoRepository extends JpaRepository<MemoEntity, Long> {
    List<MemoEntity> findByTag(String tag);
}
