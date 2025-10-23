package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    static Stream<Arguments> argumentForApplicationTest() {
        return Stream.of(
                Arguments.of("pobi,woni", "1", new int[]{MOVING_FORWARD, STOP}, List.of("pobi : -", "woni : ", "최종 우승자 : pobi")),
                Arguments.of("pobi,woni", "1", new int[]{MOVING_FORWARD, MOVING_FORWARD}, List.of("pobi : -", "woni : -", "최종 우승자 : pobi, woni"))
        );
    }

    @ParameterizedTest(name = "{displayName}(Names = {0}, TimesToTry = {1}, randomNumber = {2}, expected = {3})")
    @DisplayName("기능 테스트")
    @MethodSource("argumentForApplicationTest")
    void 기능_테스트(String inputNames, String inputTimesToTry, int[] randomNumber, List<String> expected) {
        assertRandomNumberInRangeTest(
            () -> {
                run(inputNames, inputTimesToTry);
                assertThat(output()).contains(expected);
            }, randomNumber[0], randomNumber[1]
        );
    }

    static Stream<Arguments> argumentForExceptionTest() {
        return Stream.of(
                Arguments.of("name,name", "1"),
                Arguments.of("pobi,woni", "0"),
                Arguments.of("pobi,woni", "21"),
                Arguments.of("pobi,woni", "1번"),
                Arguments.of("name,na me", "1"),
                Arguments.of("1,2,3,4,5,6,7,8,9,10,11", "1"),
                Arguments.of("pobi,abcedf", "1번")
        );
    }

    @ParameterizedTest(name = "{displayName}(Names = {0}, TimesToTry = {1})")
    @DisplayName("예외 테스트")
    @MethodSource("argumentForExceptionTest")
    void 예외_테스트(String inputNames, String inputTimesToTry) {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(inputNames, inputTimesToTry))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
