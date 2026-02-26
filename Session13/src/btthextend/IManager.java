package btthextend;

public interface IManager<T> {

    void add(T item);

    void update(T item);

    void delete(int id);

    void displayAll();
}