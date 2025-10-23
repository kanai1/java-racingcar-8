package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {

    private boolean isFirstPrintResultOfRace;

    public View() {
        this.isFirstPrintResultOfRace = true;
    }

    public String getNameOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String getTimesToTry() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void printResultOfRace(List<Car> participants) {
        if (isFirstPrintResultOfRace) {
            System.out.println("실행 결과");
            isFirstPrintResultOfRace = false;
        }

        for (Car participant: participants) {
            System.out.println(participant.getName() + " : " + "-".repeat((participant.getScore())));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " +  String.join(", ", winners));
    }
}
