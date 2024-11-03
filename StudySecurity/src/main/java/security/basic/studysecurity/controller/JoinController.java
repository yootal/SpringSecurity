package security.basic.studysecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import security.basic.studysecurity.dto.JoinDto;
import security.basic.studysecurity.service.JoinService;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String joinP() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(JoinDto joinDto) {

        System.out.println(joinDto.getUsername());

        joinService.joinProcess(joinDto);

        return "redirect:/login";
    }
}
