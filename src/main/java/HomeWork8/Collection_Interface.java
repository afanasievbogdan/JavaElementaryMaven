package HomeWork8;

public interface Collection_Interface {

    boolean add(Object o);

    boolean add(int index, Object o);

    boolean delete (Object o);

    Object get(int index);

    boolean contain(Object o);

    boolean equals (Object obj);

    boolean clear();

    int size();
}
