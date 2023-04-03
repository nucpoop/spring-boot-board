package com.nucpoop.springbootboard;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.nucpoop.springbootboard.entity.Board;
import com.nucpoop.springbootboard.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void boardSelect(){

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
}
