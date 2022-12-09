package com.example.demoboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private long creatorId;

    public Board(String title, long creatorId) {
        this.title = title;
        this.creatorId = creatorId;
    }

    public Board(String title) {
        this.title = title;
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