package HomeWork8;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringCollection stringCollection = new StringCollection();

        stringCollection.add(777);
        stringCollection.add("String1");
        stringCollection.add("String2");
        stringCollection.add("String3");
        stringCollection.add("String4");
        stringCollection.add("String5");
        stringCollection.add(5,"String6");
        stringCollection.delete("String2");
        stringCollection.delete("String5");
        stringCollection.print();
        stringCollection.get(3);
        stringCollection.get(7);
        stringCollection.get(77);
        stringCollection.contain("String3");
        stringCollection.contain("String33");

        StringCollection stringCollectionForCheckEquals = new StringCollection(8);
        stringCollectionForCheckEquals.add("1String");
        stringCollectionForCheckEquals.add("2String");
        stringCollectionForCheckEquals.add("3String");
        stringCollectionForCheckEquals.add("4String");
        stringCollectionForCheckEquals.add("5String");
        stringCollectionForCheckEquals.add("6String");


        System.out.println(stringCollection.equals(stringCollectionForCheckEquals));


        stringCollectionForCheckEquals.clear();
        stringCollectionForCheckEquals.print();

        System.out.println(stringCollection.size());
        System.out.println(stringCollectionForCheckEquals.size());

    }
}
