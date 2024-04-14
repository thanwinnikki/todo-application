package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.todo.common.domain.MemoEntity;

@Repository
public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

}
