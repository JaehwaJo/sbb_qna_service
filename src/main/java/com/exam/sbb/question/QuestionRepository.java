package com.exam.sbb.question;

import com.exam.sbb.base.RepositoryUtil;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer>, RepositoryUtil {

  Question findBySubject(String subject);

  Question findByContent(String content);

  Question findBySubjectAndContent(String subject, String content);

  List<Question> findBySubjectLike(String subject);

  Page<Question> findBySubjectContains(String kw, Pageable pageable);
  Page<Question> findBySubjectContainingOrContentContaining(String kw, String kw_, Pageable pageable);

  @Modifying
  @Transactional
  @Query(value = "ALTER TABLE question AUTO_INCREMENT = 1", nativeQuery = true)
  void truncate();

}