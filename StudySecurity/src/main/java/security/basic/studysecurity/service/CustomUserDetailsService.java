package security.basic.studysecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.basic.studysecurity.dto.CustomUserDetails;
import security.basic.studysecurity.entity.User;
import security.basic.studysecurity.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 로그인 처리 시 유저가 있는지 확인하고 존재하면 UserDetails 객체 기반 인증 프로세스 진행
        // 인증 성공하면 SecurityContextHolder 유저 정보 등록

        User user = userRepository.findByUsername(username);

        if (user != null) {
            return new CustomUserDetails(user);
        }

        return null;
    }
}
