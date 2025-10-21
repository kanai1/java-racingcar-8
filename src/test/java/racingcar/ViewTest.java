package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    void printResultOfRaceTest() {
        View testView = new View();
        List<Car> testList = new ArrayList<Car>();
        testList.add(new Car("test1"));
        testList.add(new Car("test2"));
        testList.get(0).addScore();
        testList.get(0).addScore();
        testList.get(1).addScore();
        testView.printResultOfRace(testList);
        assertThat(outputStreamCaptor.toString().trim()).contains("실행결과", "test1 : --", "test2 : -");
    }
}
