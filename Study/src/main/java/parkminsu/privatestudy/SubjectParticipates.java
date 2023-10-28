package parkminsu.privatestudy;

import java.util.ArrayList;
import java.util.List;

public class SubjectParticipates<T> {
    List<T> list = new ArrayList<>();

    public void add(T t) {
        this.list.add(t);
    }
}
