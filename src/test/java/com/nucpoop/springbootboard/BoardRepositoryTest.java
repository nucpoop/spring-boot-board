package com.nucpoop.springbootboard;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.google.gson.Gson;
import com.nucpoop.springbootboard.entity.Board;
import com.nucpoop.springbootboard.repository.BoardRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;
    static final int MAX_DEFAULT_BOARD_SIZE = 5;
    Gson gson = new Gson();

    @BeforeEach
    void initSetData() {
        for (int i = 0; i < MAX_DEFAULT_BOARD_SIZE; i++) {
            Board board = new Board();
            board.setTitle(i + "title");
            board.setContent(i + "content");
            boardRepository.save(board);
        }
    }

    @Test
    void boardSelect() {
        //given
        //when
        List<Board> boardList = boardRepository.findAll();
        //then
        assertThat(boardList.size()).isEqualTo(MAX_DEFAULT_BOARD_SIZE);
        System.out.println("result : " + gson.toJson(boardList));
    }

    @Test
    void boardInsert() {
        //given
        Board board = new Board();
        board.setTitle("hello");
        board.setContent("this is content");
        //when
        Board result = boardRepository.save(board);
        //then
        assertThat(boardRepository.findById(result.getId()).isPresent()).isTrue();
    }

    @Test
    void boardDelete() {
        //given
        //when
        //then
    }
}
