package HomeWork8;

import java.util.Arrays;

public class StringCollection implements Collection_Interface{

    private String[] strings;
    private int current;

    public StringCollection(){
        strings = new String[10];
    }

    public StringCollection(int numOfStrings){
        strings = new String[numOfStrings];
    }

    private void collectionCopy(){
        String[] buffer = new String[strings.length];
        System.arraycopy(strings, 0, buffer, 0, strings.length);
        strings = new String[strings.length + 1];
        System.arraycopy(buffer, 0, strings, 0, buffer.length);
    }

    public void print(){
        System.out.println();
        for (String string : strings) {
            if(string != null)
                System.out.println(string);
        }
    }

    @Override
    public boolean add(Object o) {

//          ?Проверка на вводимый тип данных?Нужна ли она?Нужно ли даункастить вообще?
        try {
            String s = (String) o;
        }catch (ClassCastException e) {
            System.out.println("You can only add a String value ");
            return false;
        }

        String s = (String) o;
        if (current >= strings.length){
            collectionCopy();
        }
        strings[current] = s;
        current++;
        return true;
    }

    @Override
    public boolean add(int index, Object o) {

        try {
            String s = (String) o;
        }catch (ClassCastException e) {
            System.out.println("You can only add a String value ");
            return false;
        }

        String s = (String) o;
        while (index >= strings.length){
            collectionCopy();
        }
        if (strings[index] == null)
            current++;
        strings[index] = s;
        return true;
    }

    @Override
    public boolean delete(Object o) {

        try {
            String s = (String) o;
        }catch (ClassCastException e) {
            System.out.println("You can only delete a String value ");
            return false;
        }

        String s = (String) o;
        String[] buffer = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if (s.equals(strings[i])) {
                strings[i] = null;
                System.arraycopy(strings, 0, buffer, 0, strings.length);
                System.arraycopy(buffer, 0, strings, 0, i);
                if (strings.length - 1 - i >= 0) System.arraycopy(buffer, i + 1, strings, i, strings.length - 1 - i);
                current--;
                return true;
            }
        }
        System.out.println("No such value");
        return false;
    }

    @Override
    public Object get(int index) {

        if(index < strings.length && index >= 0){
            if (strings[index] == null){
                System.out.println("by index '" + index + "' was found empty element");
                return -1;}
            else
                System.out.println("by index '" + index + "' was found String '" + strings[index] + "'");
            return (Object) strings[index];
        }else
            System.out.println("index '" + index + "' is out of collection ");
        return -1;
    }

    @Override
    public boolean contain(Object o) {

        try {
            String s = (String) o;
        }catch (ClassCastException e) {
            System.out.println("You can only check a String value ");
            return false;
        }

        String s = (String) o;
        for (int i = 0; i < strings.length; i++) {
            if (s.equals(strings[i])) {
                System.out.println("Collection contain string '" + s + "' by index " + i);
                return true;
            }
        }
        System.out.println("No such string in collection");
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringCollection that = (StringCollection) o;
        return current == that.current &&
                Arrays.equals(strings, that.strings);
    }


    @Override
    public boolean clear() {
        Arrays.fill(strings, null);
        current = 0;
        return true;
    }

    @Override
    public int size() {
        return current;
    }
}
