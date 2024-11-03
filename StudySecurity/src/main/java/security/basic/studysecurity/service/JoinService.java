package security.basic.studysecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import security.basic.studysecurity.constant.Role;
import security.basic.studysecurity.dto.JoinDto;
import security.basic.studysecurity.entity.User;
import security.basic.studysecurity.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto) {

        boolean isUser = userRepository.existsByUsername(joinDto.getUsername());
        if (isUser) {
            return;
        }

        User user = User.builder()
                .username(joinDto.getUsername())
                .password(bCryptPasswordEncoder.encode(joinDto.getPassword()))
//                .role(Role.valueOf("USER"))
                .role(Role.valueOf("ADMIN"))
                .build();

        userRepository.save(user);
    }
}
