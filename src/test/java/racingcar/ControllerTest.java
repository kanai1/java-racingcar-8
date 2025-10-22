package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ControllerTest {

    static Stream<Arguments> argumentForVerifyNameTest() {
        return Stream.of(
                Arguments.of(List.of("name", "abcd"), true),
                Arguments.of(List.of("name"), false), // 이름 목록이 2개 이상이여야 함
                Arguments.of(List.of("name", "abcdef"), false), // 이름이 5글자 이하여야함
                Arguments.of(List.of("name", "ab cd"), false), // 이름에 공백이 포함되면 안됨
                Arguments.of(List.of("n1", "n2", "n3", "n4", "n5", "n6", "n7", "n8", "n9", "n10", "n11"), false), // 이름 목록이 10개 이하여야 함
                Arguments.of(List.of("a", "name", "a", "name"), false) // 이름이 중복되어선 안됨
        );
    }

    @ParameterizedTest(name = "{displayName}(names = {0}, expected = {1})")
    @MethodSource("argumentForVerifyNameTest")
    @DisplayName("이름 검증 테스트")
    public void verifyNameTest(List<String> names, boolean expected) {
        Controller testController = new Controller();
        assertThat(testController.verifyName(names)).isEqualTo(expected);
    }
}
