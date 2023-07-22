package com.exam.sbb.question;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Question {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column (length = 200)
  private String subject;

  @Column (columnDefinition = "TEXT")
  private String content;

  private LocalDateTime createDate;
}
