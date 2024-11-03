package security.basic.studysecurity.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

    // 앞의 상수로 접근 했을 때, 리턴
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String value;
}
