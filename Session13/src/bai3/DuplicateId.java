package bai3;

import java.util.ArrayList;

public class DuplicateId {
    static <T> ArrayList<T> findCommonPatients(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> result = new ArrayList<>();
        for (T e : list1) {
            if (list2.contains(e) && !result.contains(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> listId1 = new ArrayList<>();
        listId1.add(101);
        listId1.add(102);
        listId1.add(105);
        ArrayList<Integer> listId2 = new ArrayList<>();
        listId2.add(102);
        listId2.add(105);
        listId2.add(108);
        ArrayList<Integer> commonInt = findCommonPatients(listId1, listId2);
        System.out.println(commonInt);
        ArrayList<String> listBHYT1 = new ArrayList<>();
        listBHYT1.add("DN01");
        listBHYT1.add("DN02");
        listBHYT1.add("DN03");
        ArrayList<String> listBHYT2 = new ArrayList<>();
        listBHYT2.add("DN02");
        listBHYT2.add("DN04");
        ArrayList<String> commonString = findCommonPatients(listBHYT1, listBHYT2);
        System.out.println(commonString);
    }
}
