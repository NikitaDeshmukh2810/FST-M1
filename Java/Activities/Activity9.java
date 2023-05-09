package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> mylist = new ArrayList<String>();
        mylist.add("Niki");
        mylist.add("Mini");
        mylist.add("Ovi");
        mylist.add(3, "Gini");
        mylist.add(1, "Pari");

        System.out.println("Print All the Objects:");
        for(String names:mylist){
            System.out.println(names);
        }

        System.out.println("3rd element in the list is: " + mylist.get(2));
        System.out.println("Is Pari is in list: " + mylist.contains("Pari"));
        System.out.println("Size of ArrayList: " + mylist.size());

        mylist.remove("Gini");

        System.out.println("New Size of ArrayList: " + mylist.size());
    }
}