package security.jwt.studysecurityjwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import security.jwt.studysecurityjwt.dto.JoinDto;
import security.jwt.studysecurityjwt.service.JoinService;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(JoinDto joinDto) {

        System.out.println(joinDto.getUsername());
        joinService.joinProcess(joinDto);

        return "ok";
    }
}
