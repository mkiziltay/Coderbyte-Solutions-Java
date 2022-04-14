import java.util.*;
import java.lang.*;

public class SumSet {
    static int recursive_time = 0;
    static void sum_up_recursive(ArrayList < Integer > numbers, int target, ArrayList < Integer > partial, ArrayList < Integer >
        listBackup) {
        recursive_time += 1;
        int s = 0;
        for (int x: partial) s += x;
        if (s == target && partial.size() == listBackup.size() / 2) {
            //if find taget remove other items from backup list
            listBackup.removeAll(partial);
            Collections.sort(listBackup);
            Collections.sort(partial); //sorting
            //print if found corect case 
            if (listBackup.get(0) < partial.get(0)) {
                System.out.println(listBackup.toString().replaceAll("[\\[\\]\\s]", "") + "," + partial.toString().replaceAll("[\\[\\]\\s]", ""));
                System.exit(0);
            } else {

                System.out.println(partial.toString().replaceAll("[\\[\\]\\s]", "") + "," + listBackup.toString().replaceAll("[\\[\\]\\s]", ""));
                System.exit(0);
            }

        }
        //if sum greater than target repeat
        if (s >= target)
            return;
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList < Integer > remaining = new ArrayList < Integer > ();
            int n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) remaining.add(numbers.get(j));
            ArrayList < Integer > partial_rec = new ArrayList < Integer > (partial);
            partial_rec.add(n);
            sum_up_recursive(remaining, target, partial_rec, listBackup);
        }
        //return -1 if no correct case 
        if ( partial.size() == 0)
            System.out.println("-1");
    }



    public static void main(String args[]) {
        //Initialize array
        //Integer[] numbers = {16,22,35,8,20,1,21,11}; // Array 1
        //Integer[] numbers = {1,2,1,5}; // Array 2
        //Integer[] numbers = {1,2,3,4}; // Array 3
        //Integer[] numbers = {16,21,1,3,8,15,7,10,9,6}; // Array 4
        //Integer[] numbers = {100,101,1,2}; // Array 5
        //Integer[] numbers = {100,101,1,0}; // Array 6
        //Integer[] numbers = {9,1,0,5,3,2}; // Array 7
        //Integer[] numbers = {1,1,1,1}; // Array 8
        Integer[] numbers = {6,2,4,1,10,25,5,3,40,4}; // Array 9

        // target sum 
        int target = 0;
        //Initialize target...
        for (int i = 0; i < numbers.length; i++) {
            target += numbers[i];
        }
        target /= 2;
        //Backup main list
        ArrayList < Integer > listBackup = new ArrayList < Integer > (Arrays.asList(numbers));
        //Calling method 
        sum_up_recursive(new ArrayList < Integer > (Arrays.asList(numbers)), target, new ArrayList < Integer > (), listBackup);

    }
}
