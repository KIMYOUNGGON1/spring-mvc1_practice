package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping ( "/request-param-v1" )
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");

    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ) {
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    // 기존에는 상관없었지만 스프링 버전 업그레이드 이후로는 명시적으로 작성해주지 않으면 에러가 발생하도록 변경되었다.
    // 기존 - @RequestParam String username, @RequestParam int age 와 같이 파라미터 명칭과 동일하기만 해도 괜찮았다.
    //    스프링 부트 3.2부터 자바 컴파일러에 -parameters 옵션을 넣어주어야 애노테이션에 적는 이름을 생략할 수 있다.
    //    해결 방안1(권장)**
    //    애노테이션에 이름을 생략하지 않고 다음과 같이 이름을 항상 적어준다. **이 방법을 권장한다.**
    //            `@RequestParam("username") String username` `@PathVariable("userId") String userId
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam("username") String username,
            @RequestParam("age") int age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 기존에는 상관없었지만 스프링 버전 업그레이드 이후로는 명시적으로 작성해주지 않으면 에러가 발생하도록 변경되었다.
    // 기존 - String username, int age 와 같이 파라미터 명칭과 동일하기만 해도 괜찮았다.
    //    스프링 부트 3.2부터 자바 컴파일러에 -parameters 옵션을 넣어주어야 애노테이션에 적는 이름을 생략할 수 있다.
    //    해결 방안1(권장)**
    //    애노테이션에 이름을 생략하지 않고 다음과 같이 이름을 항상 적어준다. **이 방법을 권장한다.**
    //            `@RequestParam("username") String username` `@PathVariable("userId") String userId
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            @RequestParam("username") String username,
            @RequestParam("age") int age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 기존에는 상관없었지만 스프링 버전 업그레이드 이후로는 명시적으로 작성해주지 않으면 에러가 발생하도록 변경되었다.
    //    스프링 부트 3.2부터 자바 컴파일러에 -parameters 옵션을 넣어주어야 애노테이션에 적는 이름을 생략할 수 있다.
    //    해결 방안1(권장)**
    //    애노테이션에 이름을 생략하지 않고 다음과 같이 이름을 항상 적어준다. **이 방법을 권장한다.**
    //            `@RequestParam("username") String username` `@PathVariable("userId") String userId
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(name = "username", required = true) String username,
            @RequestParam(name = "age", required = false) Integer age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 기존에는 상관없었지만 스프링 버전 업그레이드 이후로는 명시적으로 작성해주지 않으면 에러가 발생하도록 변경되었다.
    //    스프링 부트 3.2부터 자바 컴파일러에 -parameters 옵션을 넣어주어야 애노테이션에 적는 이름을 생략할 수 있다.
    //    해결 방안1(권장)**
    //    애노테이션에 이름을 생략하지 않고 다음과 같이 이름을 항상 적어준다. **이 방법을 권장한다.**
    //            `@RequestParam("username") String username` `@PathVariable("userId") String userId
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(name = "username", required = true, defaultValue = "guest") String username,
            @RequestParam(name = "age", required = false, defaultValue = "-1") int age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 기존에는 상관없었지만 스프링 버전 업그레이드 이후로는 명시적으로 작성해주지 않으면 에러가 발생하도록 변경되었다.
    // 기존 - String username, int age 와 같이 파라미터 명칭과 동일하기만 해도 괜찮았다.
    //    스프링 부트 3.2부터 자바 컴파일러에 -parameters 옵션을 넣어주어야 애노테이션에 적는 이름을 생략할 수 있다.
    //    해결 방안1(권장)**
    //    애노테이션에 이름을 생략하지 않고 다음과 같이 이름을 항상 적어준다. **이 방법을 권장한다.**
    //            `@RequestParam("username") String username` `@PathVariable("userId") String userId
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
}
