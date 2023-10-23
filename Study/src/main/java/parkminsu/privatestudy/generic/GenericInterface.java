package parkminsu.privatestudy.generic;

public interface GenericInterface<T> {
    void add(T item);

    T get(int index);

    int size();
}
