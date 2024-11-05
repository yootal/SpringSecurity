package security.pro.jwt.studysecurityprojwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import security.pro.jwt.studysecurityprojwt.dto.JoinDto;
import security.pro.jwt.studysecurityprojwt.service.JoinService;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(JoinDto joinDto) {
        joinService.joinProcess(joinDto);
        return "ok";
    }
}
