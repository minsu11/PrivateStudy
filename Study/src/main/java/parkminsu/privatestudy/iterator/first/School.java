package parkminsu.privatestudy.iterator.first;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class School implements Iterable<SchoolMember> {
    private List<SchoolMember> studentList;


    public School() {
        studentList = new ArrayList<>();
    }

    public void addMember(Student student) {
        this.studentList.add(student);
    }

    @Override
    public Iterator<SchoolMember> iterator() {
        return new SchoolIterator();
    }

    @Override
    public void forEach(Consumer<? super SchoolMember> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<SchoolMember> spliterator() {
        return Iterable.super.spliterator();
    }

    public List<SchoolMember> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        return "School{" +
                "studentList=" + studentList +
                '}';
    }

    public class SchoolIterator implements Iterator<SchoolMember> {
        int index = 0;

        @Override
        public boolean hasNext() {

            return index < studentList.size();
        }

        @Override
        public SchoolMember next() {
            return getStudentList().get(index++);
        }
    }

}
