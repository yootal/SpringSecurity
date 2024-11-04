package security.oauth.jwt.studysecurityoauthjwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    @GetMapping("/my")
    public String myAPI() {
        return "my route";
    }
}