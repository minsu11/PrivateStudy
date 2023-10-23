package parkminsu.privatestudy.iterator.second;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class School<T extends SchoolMember> implements SchoolIterable<T> {
    private List<T> studentList;


    public School() {
        studentList = new ArrayList<>();
    }

    public void addMember(T schoolMember) {
        this.studentList.add(schoolMember);
    }

    public void printMember() {
        print(0);
    }

    private void print(int size) {
        if (size == this.studentList.size()) {
            return;
        }
        size++;
        System.out.println(this.studentList.get(size).getID() + " " + this.studentList.get(size).getName());
        print(size);
    }

    public List<T> filterMembers(Filter<T> filter) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < getStudentList().size(); i++) {
            if (filter.filter(getStudentList().get(i))) {
                list.add(getStudentList().get(i));
            }
        }
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return this.studentList.iterator();
    }


    @Override
    public String toString() {
        return "School{" +
                "studentList=" + studentList +
                '}';
    }

    public List<T> getStudentList() {
        return studentList;
    }

    public class SchoolIterator implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {

            return index < studentList.size();
        }

        @Override
        public T next() {
            return getStudentList().get(index++);
        }
    }

}
