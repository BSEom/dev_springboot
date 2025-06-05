package com.ebs0012.my01.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ebs0012.my01.dto.BungBbang;
import com.ebs0012.my01.dto.MemberData;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class My01Controller {
    @GetMapping("/")
    public String mainPage(Model model) {
        List<String> pageNames = List.of("model", "increase", "fragments", "if-unless", "DTO1", "DTO2",
                "GET-querystring",
                "GET-pathvariable", "POST-formdata", "final-chatbot");
        model.addAttribute("pages", pageNames);
        return "index";
    }

    @GetMapping("/model")
    public String ex01(Model model) {
        model.addAttribute("hello", "만나서 반갑다.");
        model.addAttribute("name", "이름은 홍길동");
        model.addAttribute("age", "나이는 25");

        return "ex01";
    }

    @GetMapping("/increase")
    public String ex02(Model model) {
        List<Integer> sampleNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        model.addAttribute("numbers", sampleNumbers);

        return "ex02";
    }

    @GetMapping("/fragments")
    public String ex03(Model model) {

        return "ex03";
    }

    @GetMapping("/if-unless")
    public String ex04(Model model) {

        model.addAttribute("isAdmin", false);
        model.addAttribute("who", "BSEom");
        List<String> itm = new ArrayList<>();
        itm.add("사과");
        itm.add("복숭아");
        itm.add("바나나");
        itm.add("수박");
        itm.add("망고");
        itm.add("포도");
        itm.add("참외");
        model.addAttribute("items", itm);

        return "ex04";
    }

    @GetMapping("/DTO1")
    public String ex05(Model model) {

        MemberData member1 = new MemberData("홍길동", LocalDate.of(2001, 5, 5));
        MemberData member2 = new MemberData("김아무개", LocalDate.of(1993, 6, 21));

        model.addAttribute("name", member1.getName());
        model.addAttribute("birth", member1.getBirthDate());

        model.addAttribute("mem", member2);

        return "ex05";
    }

    @GetMapping("/DTO2")
    public String ex06(Model model) {

        // BungBbang bbang1 = new BungBbang("팥", 500, LocalDate.of(1973, 1, 1));
        // BungBbang bbang2 = new BungBbang("슈크림", 500, LocalDate.of(2005, 1, 1));
        // BungBbang bbang3 = new BungBbang("피자", 1000, LocalDate.of(2014, 1, 1));
        // BungBbang bbang4 = new BungBbang("민트초코", 1000, LocalDate.of(2020, 1, 1));

        // model.addAttribute("팥붕어", bbang1);
        // model.addAttribute("슈크림붕어", bbang2);
        // model.addAttribute("피자붕어", bbang3);
        // model.addAttribute("민트초코붕어", bbang4);

        // model.addAttribute("팥붕어_이름", bbang1.getFlavor());
        // model.addAttribute("팥붕어_가격", bbang1.getPrice());
        // model.addAttribute("팥붕어_출시일", bbang1.getSince());

        // model.addAttribute("슈크림붕어_이름", bbang2.getFlavor());
        // model.addAttribute("슈크림붕어_가격", bbang2.getPrice());
        // model.addAttribute("슈크림붕어_출시일", bbang2.getSince());

        // model.addAttribute("피자붕어_이름", bbang3.getFlavor());
        // model.addAttribute("피자붕어_가격", bbang3.getPrice());
        // model.addAttribute("피자붕어_출시일", bbang3.getSince());

        // model.addAttribute("민트초코붕어_이름", bbang4.getFlavor());
        // model.addAttribute("민트초코붕어_가격", bbang4.getPrice());
        // model.addAttribute("민트초코붕어_출시일", bbang4.getSince());

        List<BungBbang> bungs = List.of(
                new BungBbang("팥", 500, LocalDate.of(1973, 1, 1)),
                new BungBbang("슈크림", 500, LocalDate.of(2005, 1, 1)),
                new BungBbang("피자", 1000, LocalDate.of(2014, 1, 1)),
                new BungBbang("민트초코", 1000, LocalDate.of(2020, 1, 1)),
                new BungBbang("치즈", 1400, LocalDate.of(2022, 1, 1))

        );

        model.addAttribute("bungs", bungs);

        return "ex06";
    }

    @GetMapping("/GET-querystring")
    public String ex07(@RequestParam(required = false) String inpName, String inAge, String inGen, String allow,
            String lang, Model model) {

        System.out.println("이름:" + inpName);
        System.out.println("나이:" + inAge);
        System.out.println("성별:" + inGen);
        System.out.println("동의:" + allow);
        System.out.println("언어:" + lang);

        List<String> content = List.of(
                "이름:" + inpName,
                "나이:" + inAge,
                "성별:" + inGen,
                "동의:" + allow,
                "언어:" + lang);

        model.addAttribute("content", content);

        return "ex07";
    }

    @GetMapping({ "/GET-pathvariable", "/pathvariable/{name}", "/pathvariable/{name}/{age}" })
    public String ex08(@PathVariable(required = false) String name, @PathVariable(required = false) String age,
            Model model) {

        System.out.println("이름:" + name);
        System.out.println("나이:" + age);

        List<String> content = List.of(
                "이름:" + name,
                "나이:" + age);

        model.addAttribute("content", content);

        return "ex08";
    }

    @GetMapping("/POST-formdata")
    public String ex09() {
        return "ex09";
    }

    @PostMapping("/POST-formdata")
    public String ex09Post(@RequestParam String inName, @RequestParam String inAge, Model model) {

        // System.out.println("이름: " + inName + "\n나이: " + inAge);

        // model.addAttribute("name", inName);
        // model.addAttribute("age", inAge);

        try {
            int parseAge = Integer.parseInt(inAge);

            model.addAttribute("name", inName);
            model.addAttribute("age", parseAge);

        } catch (NumberFormatException e) {

            model.addAttribute("error", "나이는 숫자로 입력해야 합니다.");
        }

        return "ex09";
    }

    @GetMapping("/final-chatbot")
    public String ex10Chat(Model model) {
        return "ex10";
    }
}
