package com.project.board.repository;

import com.project.board.model.BoardModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardModel, Integer> {
    @Override
    Page<BoardModel> findAll(Pageable pageable);
}
