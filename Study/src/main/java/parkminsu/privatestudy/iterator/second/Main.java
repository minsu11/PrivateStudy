package parkminsu.privatestudy.iterator.second;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        School<Student> school = new School();
        school.addMember(new Student("p", 1));
        school.addMember(new Student("a", 2));
        school.addMember(new Student("s", 3));
        school.addMember(new Student("d", 4));
        School<Teacher> teachers = new School();
        teachers.addMember(new Teacher("pa", 2));
        teachers.addMember(new Teacher("pad", 4));
        teachers.addMember(new Teacher("pagh", 5));
        teachers.addMember(new Teacher("pas", 23));
        teachers.addMember(new Teacher("paa", 6));

        School<SchoolMember> sc = new School<>();
        sc.addMember(new Teacher("a", 2));
        sc.addMember(new Student("b", 2));

        Filter<SchoolMember> filter = filterData -> filterData.getName() == "b";
        for (Iterator<SchoolMember> it = sc.iterator(); it.hasNext(); ) {
            SchoolMember st = it.next();
            System.out.println(st.toString());
            System.out.println(sc.filterMembers(filter).toString());

        }

    }
}
