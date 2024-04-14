package com.todo.repository;
//
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//
//import com.todo.common.domain.MemoEntity;
//
//@Repository
//public interface MemoRepository extends JpaRepository<MemoEntity, Long> {
//    List<MemoEntity> findByTag(String tag);
//}

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.todo.common.domain.MemoEntity;
import com.todo.common.domain.enums.Tag;

@Repository
public class MemoEntityDao {
    private final JdbcTemplate jdbcTemplate;

    public MemoEntityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to insert a new MemoEntity into the database
    public void save(MemoEntity memoEntity) {
        String sql = "INSERT INTO MEMOS (id, name, tag) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, memoEntity.getId(), memoEntity.getName(), memoEntity.getTag());
    }

    // Method to retrieve a MemoEntity by its ID from the database
    public MemoEntity findById(Long id) {
        String sql = "SELECT id, name, tag FROM MEMOS WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new MemoEntity(rs.getLong("id"), rs.getString("name"), rs.getString("tag")));
    }

    public List<MemoEntity> findByTag(Tag tag) {
        String sql = "SELECT id, name, tag FROM MEMOS WHERE tag = ?";
        return jdbcTemplate.query(sql, new Object[]{tag.toString()}, (rs, rowNum) ->
                new MemoEntity(rs.getLong("id"), rs.getString("name"), rs.getString("tag")));
    }

    public List<MemoEntity> findAll() {
        String sql = "SELECT id, name, tag FROM MEMOS";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new MemoEntity(rs.getLong("id"), rs.getString("name"), rs.getString("tag")));
    }


    // Method to update an existing MemoEntity in the database
    public void update(MemoEntity memoEntity) {
        String sql = "UPDATE MEMOS SET name = ?, tag = ? WHERE id = ?";
        jdbcTemplate.update(sql, memoEntity.getName(), memoEntity.getTag().toString(), memoEntity.getId());
    }

    // Method to delete a MemoEntity from the database by its ID
    public void deleteById(Long id) {
        String sql = "DELETE FROM MEMOS WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
