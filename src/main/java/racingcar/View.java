package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
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
        if (this.isFirstPrintResultOfRace) {
            System.out.println("실행 결과");
            this.isFirstPrintResultOfRace = false;
        }

        for (Car participant: participants) {
            System.out.printf("%s : %s\n", participant.getName(), "-".repeat(participant.getScore()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        List<String> winnersName = new ArrayList<String>();
        for (Car winner: winners) {
            winnersName.add(winner.getName());
        }
        System.out.printf("최종 우승자 : %s\n", String.join(", ", winnersName));
    }
}
