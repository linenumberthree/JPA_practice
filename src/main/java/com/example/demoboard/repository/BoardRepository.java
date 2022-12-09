package com.example.demoboard.repository;

import com.example.demoboard.dto.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findBoardById(long id);

    List<Board> findBoardsByCreatorId(long id);

    Board findBoardByTitle(String title);

}
