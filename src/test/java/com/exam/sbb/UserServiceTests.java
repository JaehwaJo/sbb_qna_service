package com.exam.sbb;

import com.exam.sbb.question.Question;
import com.exam.sbb.question.QuestionRepository;
import com.exam.sbb.user.UserRepository;
import com.exam.sbb.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class UserServiceTests {

  @Autowired
  private UserService userService;
  @Autowired
  private UserRepository userRepository;

  public static void createSampleData(UserService userService) {
    userService.create("admin", "admin@eamil.com", "1234");
    userService.create("user1", "user1@eamil.com", "1234");
  }

  private void createSampleData() {
    createSampleData(userService);
  }

  public static void clearData(UserRepository userRepository) {

  }

  @Test
  @DisplayName("회원가입이 가능하다.")
  public void t1() {
    userService.create("admin", "admin@eamil.com", "1234");
    userService.create("user1", "user1@eamil.com", "1234");
  }

}