
import edu.aueb.ds.exceptions.EmptyListException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Greedy {
    // private static char rndChar() {
    // int rnd = (int) (Math.random() * 52); // or use Random or whatever
    // char base = (rnd < 26) ? 'A' : 'a';
    // return (char) (base + rnd % 26);

    // }

    static int numberOfDisks = 0;
    private static int numberOfFiles = 0;// number of files

    public static void main(String[] args) throws IOException, EmptyListException {

        // A list containing the files' spaces in MB

        MaxPQ diskList = new MaxPQ(new Disk()); // A list that contains disk objects

        // create new file object
        FileInputStream file = new FileInputStream(args[0]);

        Scanner sc = new Scanner(file); // create a new scanner object
        Disk disk = new Disk();
        int sumOfAllFolders = 0; // Total sum of data used in all disks
        // read each line and
        // count number of lines
        int fileMB = 0;
        diskList.add(disk); // Add disk in diskList

        while (sc.hasNext()) {
            // add
            fileMB = sc.nextInt(); // retrieve next int from input
            numberOfFiles += 1;
            sumOfAllFolders += fileMB;
            if (fileMB > 0 && fileMB < 1000000) {
                if (disk.getFreeSpace(disk.getID()) >= fileMB) {
                    disk.addFile(fileMB);
                } else {

                    disk = new Disk();
                    diskList.add(disk);
                    numberOfDisks += 1;
                    for (int id = 0; id < Disk.getNumberOfIDs(); id++) {
                        if (disk.getFreeSpace(id) >= fileMB) {
                            disk.addFile(fileMB);

                        }
                    }
                    disk.addFile(fileMB);

                }
            } else
                System.exit(1);

        }
        // System.out.println(MB.length);
        // close scanner}
        sc.close();
        final float i = sumOfAllFolders;
        System.out.println("Sum of all folders = " + i / 1000000 + " TB");

        System.out.println("Total number of disks used = " + Disk.getNumberOfIDs());
        Object max = null;

        if (numberOfFiles <= 100) {
            while (diskList.peek() != null) {
                Disk diskaki = (Disk) diskList.getMax();
                System.out.print("id " + diskaki.id + " " + diskaki.getFreeSpace(diskaki.getID()) + ": ");
                max = diskaki.folders.getMax();
                while (max != null) {
                    System.out.print(max + " ");
                    max = diskaki.folders.getMax();
                }

                System.out.println();
            }
        }
    }

}
