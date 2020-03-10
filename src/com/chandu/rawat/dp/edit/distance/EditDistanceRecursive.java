package com.chandu.rawat.dp.edit.distance;

/**
 * Recursive Approach for Edit Distance
 * Contains overlapping Sub-problems
 * @author allenkis
 */
public class EditDistanceRecursive {

    public static void main(String[] args) {
        System.out.println(editDistance("saturday","sunday"));
    }

    public static int editDistance(String string1, String string2) {

        if(string1 == null || string1.isEmpty()) return string2.length();
        if(string2 == null || string2.isEmpty()) return string1.length();
        if(string1.charAt(0) == string2.charAt(0)) return  editDistance(string1.substring(1),string2.substring(1));

        int d = editDistance(string1.substring(1), string2);
        int u = editDistance(string1.substring(1), string2.substring(1));
        int i = editDistance(string1, string2.substring(1));

        return getMinimum(d,u,i)+1;
    }

    public static int getMinimum(int d, int u, int i) {
        return Math.min(d, Math.min(u,i));
    }
}
