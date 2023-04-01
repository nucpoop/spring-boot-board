package com.nucpoop.springbootboard.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    @CreationTimestamp
    @Column(name = "reg_dtm")
    private LocalDateTime regDtm;

    @UpdateTimestamp
    @Column(name = "mod_dtm")
    private LocalDateTime modDtm;
}
