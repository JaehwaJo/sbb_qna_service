package com.exam.sbb.question;

import com.exam.sbb.answer.Answer;
import com.exam.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity // 아래 Question 클래스는 엔티티 클래스이다.
// 아래 클래스와 1:1로 매칭되는 테이블이 DB 없다면, 자동으로 생성되어야 한다.
public class Question {
  @Id // primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
  private int id;

  @Column(length = 200) // varchar(200)
  private String subject;

  @Column(columnDefinition = "TEXT")
  private String content;

  private LocalDateTime createDate;
  private LocalDateTime modifyDate;

  @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
  private List<Answer> answerList = new ArrayList<>();

  @ManyToOne
  private SiteUser author;

  public void addAnswer(Answer answer) {
    answer.setQuestion(this);
    getAnswerList().add(answer);
  }

  @ManyToMany
  Set<SiteUser> voter;
}
