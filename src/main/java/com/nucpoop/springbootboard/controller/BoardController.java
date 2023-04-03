package com.nucpoop.springbootboard.controller;

import com.nucpoop.springbootboard.dto.BoardDTO;
import com.nucpoop.springbootboard.entity.Board;
import com.nucpoop.springbootboard.service.BoardService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("board")
@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<List<Board>> findAllBoard() {
        return ResponseEntity.ok(boardService.getBoardList());
    }

    @PostMapping
    public ResponseEntity<Board> saveBoard(@RequestBody BoardDTO boardDTO) {
        return ResponseEntity.ok(boardService.saveBoard(boardDTO));
    }

    @PutMapping
    public ResponseEntity<Board> modifyBoard(@RequestBody BoardDTO boardDTO) {
        return ResponseEntity.ok(boardService.modifyBoard(boardDTO));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteBoard(@RequestBody BoardDTO boardDTO) {
        return ResponseEntity.ok(boardService.deleteBoard(boardDTO));
    }
}
