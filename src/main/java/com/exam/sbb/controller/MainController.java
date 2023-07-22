package com.exam.sbb.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
//  @RequestMapping("/sbb")
//  // 아래 함수의 리턴값을 그대로 브라우저에 표시
//  // 아래 함수의 리턴값을 문자열화 해서 브라우저 응답을 바디에 담는다.
//  @ResponseBody
//  public String index() {
//    return "안녕하세요.";
//  }
//
//  @GetMapping("/page1")
//  @ResponseBody
//  public String showGet() {
//    return """
//           <form method="POST" action="/page2" />
//              <input type="number" name="age" placeholder="나이 입력" />
//              <input type="submit" value="page2로 POST 방식으로 이동" />
//           </form>
//           """;
//  }
//
//
//  @PostMapping("/page2")
//  @ResponseBody
//  public String showPage2Post(@RequestParam(defaultValue = "0") int age) {
//    return """
//           <h1>입력된 나이 : %d</h1>
//           <h1>안녕하세요. POST 방식으로 오신걸 환영합니다.</h1>
//           """.formatted(age);
//  }
//
//  @GetMapping("/page2")
//  @ResponseBody
//  public String showPost(@RequestParam(defaultValue = "0") int age) {
//    return """
//           <h1>입력된 나이 : %d</h1>
//           <h1>안녕하세요. GET 방식으로 오신걸 환영합니다.</h1>
//           """.formatted(age);
//  }
//  @GetMapping("/plus")
//  @ResponseBody
//  public String plusNum(int a, int b) {
//    return """
//           <h1>%d</h1>
//           """.formatted(a + b);
//  }
//
//  @GetMapping("/minus")
//  @ResponseBody
//  public String minusNum(int a, int b) {
//    return """
//           <h1>%d</h1>
//           """.formatted(a - b);
//  }
//  private int a = 0;
//  @GetMapping("/increase")
//  @ResponseBody
//  public int increaseNum() {
//
//    return a++;
//  }
//
//  @GetMapping("/gugudan")
//  @ResponseBody
//  public String gugudan(Integer dan, Integer limit) {
//    if (dan == null) {
//      dan = 9;
//    }
//    if (limit == null) {
//      limit = 9;
//    }
//
//    final Integer finaldan = dan;
//    return IntStream.rangeClosed(1, limit)
//        .mapToObj(i -> "%d * %d = %d".formatted(finaldan, i, finaldan * i))
//        .collect(Collectors.joining("<br>"));
//  }
//
//  @GetMapping("/mbti")
//  @ResponseBody
//  public String whatMbti(String name) {
//    String mbti = "";
//
//    switch (name) {
//      case "홍길동" :
//        mbti = "INFP";
//        break;
//      case "홍길순" :
//        mbti = "ENFP";
//        break;
//      case "임꺽정" :
//        mbti = "ESFJ";
//        break;
//    }
//
//    return mbti;
//  }
//
//  @GetMapping("/saveSessionAge/{age}")
//  @ResponseBody
//  public String saveAge(HttpServletRequest request,@PathVariable int age) {
//    HttpSession session = request.getSession();
//
//    session.setAttribute("age", age);
//
//    return "Session에 %d저장.".formatted(age);
//  }
//
//  @GetMapping("/getSessionAge")
//  @ResponseBody
//  public String getAge(HttpServletRequest request) {
//    HttpSession session = request.getSession();
//
//    return "Session에 저장된 값 : %d".formatted((int) session.getAttribute("age"));
//  }
  @AllArgsConstructor
  @Getter
  @Setter
  class Article {
    static int lastId = 0;
    int id;
    String title;
    String body;
    Article(String title, String body) {
      this(++lastId, title, body);
    }
}
  List<Article> articles = new ArrayList<>();

  @GetMapping("/addArticle")
  @ResponseBody
  public String addArticle(String title, String body) {

    Article article = new Article(title, body);

    articles.add(article);

    return "%d번 글이 등록되었습니다.".formatted(article.getId());
  }

  @GetMapping("/article/{id}")
  @ResponseBody
  public Article getAticle(@PathVariable int id) {
    Article article = articles.stream().filter(a -> a.getId() == id).findFirst().get();

    return article;
  }
  @GetMapping("/modifyArticle")
  @ResponseBody
  public String modifyArticle(int id, String title, String body) {
    Article article = articles.stream().filter(a -> a.getId() == id).findFirst().get();
    article.title = title;
    article.body = body;

    articles.set(id - 1, article);

    return "%d번 글이 수정되었습니다..".formatted(article.getId());
  }
  @GetMapping("/deleteArticle/{id}")
  @ResponseBody
  public String deleteArticle(@PathVariable int id) {
    Article article = articles.stream().filter(a -> a.getId() == id).findFirst().get();

    articles.remove(id - 1);

    return "%d번 글이 삭제되었습니다..".formatted(article.getId());
  }
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  class Person {
    private int id;
    private int age;
    private String name;

    public Person(int age, String name) {
      this.age = age;
      this.name = name;
    }
  }

//  @GetMapping("/addPerson")
//  @ResponseBody
//  public String addPerson(int id, int age, String name) {
//    Person p = new Person(id, age, name);
//
//    return "id : %d, age : %d, name : %s입니다.".formatted(p.getId(), p.getAge(), p.getName());
//  }

  @GetMapping("/addPerson/{id}")
  @ResponseBody
  public String addPerson(@PathVariable Person p) {
    //p = new Person(p.id, age, name);

    return "id : %d, age : %d, name : %s입니다.".formatted(p.getId(), p.getAge(), p.getName());
  }
}