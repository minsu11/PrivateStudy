package parkminsu.privatestudy.iterator.first;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        School school = new School();
        school.addMember(new Student("p"));
        school.addMember(new Student("a"));
        school.addMember(new Student("s"));
        school.addMember(new Student("d"));
        for (Iterator<SchoolMember> it = school.iterator(); it.hasNext(); ) {
            SchoolMember st = it.next();
            System.out.println(st.toString());

        }

    }
}
