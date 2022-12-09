package com.example.demoboard.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="boardArticle")
public class Article {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="board_id")
    private Board board;

    public Article(String content, Board board) {
        this.content = content;
        this.board = board;
    }

    @CreatedDate
    @Column(name = "create_date")
    private String createDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private String updateDate;

    @PrePersist
    public void onPrePersist() {
        this.createDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        this.updateDate = this.createDate;
    }
    @PreUpdate
    public void onPreUpdate() {
        this.updateDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }
}