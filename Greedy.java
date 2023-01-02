
import edu.aueb.ds.exceptions.EmptyListException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Greedy {

    public static void main(String[] args) throws IOException, EmptyListException {
        // A list containing the files' spaces in MB
        List<Integer> MB = new List<>();
        // create new file object
        FileInputStream file = new FileInputStream(args[0]);

        Scanner sc = new Scanner(file); // create a new scanner object
        Disk disk = new Disk(); // create a new disk object
        int sumOfAllFolders = 0;
        // read each line and
        // count number of lines
        while (sc.hasNext()) {
            MB.insertAtFront(sc.nextInt());
            int fileMB = MB.removeFromFront();
            sumOfAllFolders += fileMB;
            if (fileMB < 0 && fileMB > 1000000) {
                if (disk.getFreeSpace() >= fileMB) {

                }
            }

        }
        // System.out.println(MB.length);
        // close scanner}
        sc.close();
        float i = sumOfAllFolders;
        System.out.println("Sum of all folders = " + i / 1000000 + " TB");
        System.out.println("Total number of disks used = ");
    }

}
