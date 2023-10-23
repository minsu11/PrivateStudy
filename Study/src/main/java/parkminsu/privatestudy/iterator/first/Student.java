package parkminsu.privatestudy.iterator.first;

public class Student implements SchoolMember {
    private String name;

    public Student(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
