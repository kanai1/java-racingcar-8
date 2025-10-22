package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Car> participants;

    public Model() {
        this.participants = new ArrayList<>();
    }

    public void setNameOfParticipants(List<String> names) {
        for (String name: names) {
            this.participants.add(new Car(name));
        }
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public void progressRace() {
        for (Car participant: this.participants) {
            if(Randoms.pickNumberInRange(0, 9) >= 4) {
                participant.addScore();
            }
        }
    }
}
