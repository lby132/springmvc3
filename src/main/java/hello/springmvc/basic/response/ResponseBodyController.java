package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Controller
@RestController
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() throws IOException {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    //@ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() throws IOException {
        return "ok";
    }

    @GetMapping("response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        final HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
   // @ResponseBody
    @GetMapping("response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        final HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);

        return helloData;
    }
}
