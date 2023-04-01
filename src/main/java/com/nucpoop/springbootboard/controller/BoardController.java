package com.nucpoop.springbootboard.controller;

import com.nucpoop.springbootboard.dto.BoardDTO;
import com.nucpoop.springbootboard.entity.Board;
import com.nucpoop.springbootboard.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
