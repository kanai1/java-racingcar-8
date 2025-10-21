package racingcar;

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
}
