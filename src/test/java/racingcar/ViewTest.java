package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ViewTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("실행 결과를 출력하는 메소드 테스트")
    void printResultOfRaceTest() {
        View testView = new View();
        List<Car> testList = new ArrayList<Car>();
        testList.add(new Car("test1"));
        testList.add(new Car("test2"));
        testList.get(0).addScore();
        testList.get(0).addScore();
        testList.get(1).addScore();
        testView.printResultOfRace(testList);
        assertThat(outputStreamCaptor.toString().trim()).contains("실행 결과", "test1 : --", "test2 : -");
    }

    @Test
    @DisplayName("최종 우승자가 다수인 경우를 출력하는 테스트")
    void printWinnersTest1() {
        View testView = new View();
        List<Car> testList = new ArrayList<Car>();
        testList.add(new Car("test1"));
        testList.add(new Car("test2"));
        testView.printWinners(testList);
        assertEquals("최종 우승자 : test1, test2", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("최종 우승자가 1명인 경우를 출력하는 테스트")
    void printWinnersTest2() {
        View testView = new View();
        List<Car> testList = new ArrayList<Car>();
        testList.add(new Car("test1"));
        testView.printWinners(testList);
        assertEquals("최종 우승자 : test1", outputStreamCaptor.toString().trim());
    }
}
