package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//인터페이스와 구체 클래스가 모두 있는 형태
@RequestMapping // 스프링은 @Controller또는 @RequestMapping이 있어야 스프링 컨트롤러로 인식한다.
@ResponseBody
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);
    //클래스 레벨에선 @RequestParam를 생략할 수 있으나, 인터페이스 레벨에서는 다 입력해주어야한다.

    @GetMapping("/v1/no-log")
    String noLog();
}
