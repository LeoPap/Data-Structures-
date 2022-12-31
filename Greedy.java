import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Greedy {

    public static void main(String[] args) throws IOException {
        // A list containing the files' spaces in MB
        int[] MB;
        // create new file object
        FileInputStream file = new FileInputStream(args[0]);

        Scanner sc = new Scanner(file); // create a new scanner object
        Disk disk = new Disk(); // create a new disk object
        int counter = 0; // initialize counter
        // read each line and
        // count number of lines
        while (sc.hasNextLine()) {
            sc.nextLine();
            counter++;

        }
        file = new FileInputStream(args[0]);

        BufferedInputStream input = new BufferedInputStream(file);
        MB = new int[counter];
        for (int i = 0; i < MB.length; i++) {
            MB[i] = input.read();
        }
        System.out.println("Total Number of Lines: " + counter);
        System.out.println(MB.length);
        System.out.println(MB[0]);
        System.out.println(MB[1]);
        System.out.println(MB[2]);
        System.out.println(MB[3]);
        System.out.println(MB[4]);
        System.out.println(MB[5]);
        disk.folders.enqueue(MB[1]);
        System.out.println(disk.getFreeSpace());
        // close scanner
        sc.close();

    }

}
