package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    // http://localhost:8080/hello
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("id", "20230511");
        model.addAttribute("name", "Anakin");
//        model.addAttribute("tel", "010-7400");

        return "hello";
    }

    // http://localhost:8080/hellomvc?id=100&name=anakin&tel=0107400
    @GetMapping("hellomvc")
    public String hellomvc(@RequestParam(value = "id", required = false) String id      // required = true 시 필수 입력
            , @RequestParam(value = "name", required = false) String name  // required = false 시 옵션 입력
//            , @RequestParam(value = "tel", required = false) String tel
            , Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
//        model.addAttribute("tel", tel);
        return "hellomvc";
    }

    // http://localhost:8080/hellostring?id=100&name=anakin&tel=0107400
    @GetMapping("hellostring")
    @ResponseBody  // String 을 그대로 반환한다.  문자처리 StringConverter가 사용됨.
    public String helloString(@RequestParam(value = "id", required = false) String id      // required = true 시 필수 입력
            , @RequestParam(value = "name", required = false) String name  // required = false 시 옵션 입력
//            , @RequestParam(value = "tel", required = false) String tel
            , Model model) {

        return "hellostring " + name;
    }

    // http://localhost:8080/helloapi?id=100&name=anakin&tel=0107400
    @GetMapping("helloapi")
    @ResponseBody  // 객체를 반환하면 객체가 JSON으로 변환되는게 기본이다. 객체처리 JsonConverter가 사용됨.
    public Hello helloApi(@RequestParam(value = "id", required = false) String id      // required = true 시 필수 입력
            , @RequestParam(value = "name", required = false) String name  // required = false 시 옵션 입력
//            , @RequestParam(value = "tel", required = false) String tel
            , Model model) {
        Hello hello = new Hello();

        hello.setId(id);;
        hello.setName(name);
//        hello.setTel(tel);

        return hello;
    }

    // Property 접근방식.
    // Getter & Setter
    public static class Hello {
        private String id;
        private String name;
//        private String tel;

        public String getId() {            return id;         }
        public void setId(String id) {     this.id = id;      }
        public String getName() {          return name;       }
        public void setName(String name) { this.name = name;  }
//        public String getTel() {           return tel;        }
//        public void setTel(String tel) {   this.tel = tel;    }
    }

}
