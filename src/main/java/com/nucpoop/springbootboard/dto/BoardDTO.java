package com.nucpoop.springbootboard.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDTO {

    private Long id;
    private String title;
    private String content;
}
