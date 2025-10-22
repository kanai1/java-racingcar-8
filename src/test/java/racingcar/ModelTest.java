package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import camp.nextstep.edu.missionutils.test.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.Arguments;

public class ModelTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    static Stream<Arguments> argumentsForTestProgressRace() {
        return Stream.of(
                Arguments.of(MOVING_FORWARD, MOVING_FORWARD),
                Arguments.of(MOVING_FORWARD, STOP),
                Arguments.of(STOP, MOVING_FORWARD),
                Arguments.of(STOP, STOP)
        );
    }

    @ParameterizedTest(name = "{index} {displayName}({arguments})")
    @DisplayName("경주 실행 테스트")
    @MethodSource("argumentsForTestProgressRace")
    public void progressRaceTest(int move1, int move2) {
        Model testModel = new Model();
        List<String> testNames = List.of("test1", "test2");
        testModel.setNameOfParticipants(testNames);
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("test1"));
        testCars.add(new Car("test2"));
        if (move1 >= MOVING_FORWARD) {
            testCars.get(0).addScore();
        }
        if (move2 >= MOVING_FORWARD) {
            testCars.get(1).addScore();
        }

        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    testModel.progressRace();
                    List<Car> actualCarList = testModel.getParticipants();
                    assertThat(actualCarList).usingRecursiveComparison().isEqualTo(testCars);
                },
                move1, move2
        );

    }
}
