package com.nucpoop.springbootboard.service;

import com.nucpoop.springbootboard.dto.BoardDTO;
import com.nucpoop.springbootboard.entity.Board;
import com.nucpoop.springbootboard.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    public Board saveBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        return boardRepository.save(board);
    }

    @Transactional
    public Board modifyBoard(BoardDTO boardDTO) {
        Optional<Board> oBoard = boardRepository.findById(boardDTO.getId());
        if (oBoard.isPresent()) {
            Board board = oBoard.get();
            board.setTitle(boardDTO.getTitle());
            board.setContent(boardDTO.getContent());
            return boardRepository.save(board);
        }
        return new Board();
    }

    public boolean deleteBoard(BoardDTO boardDTO) {
        boardRepository.deleteById(boardDTO.getId());
        return true;
    }
}
