import java.util.Comparator;

class Disk implements ComparableInterface<Disk>, Comparator<Object> {
    private final int totalSpace = 1000000;
    private static int idCounter = -1; // idCounter

    MaxPQ folders = new MaxPQ(new IntegerComparator());

    int id = idCounter++; // disk's id
    int usedSpace = 0;

    // new method to return the ID instance variable
    public int getID() {
        return id;
    }

    public static int getNumberOfIDs() {
        return idCounter;
    }

    public void addFile(int file) {
        if (file + usedSpace <= totalSpace) {
            folders.add(file);
            usedSpace += file;
        }

    }

    /** @return total free space in */
    public int getFreeSpace(int id) {

        return totalSpace - this.usedSpace;
    }

    // compare this disk object to the given disk argument
    @Override
    public int compareTo(Disk diskB) {
        if (this.getFreeSpace(id) > diskB.getFreeSpace(id))
            return 1;
        else if (this.getFreeSpace(id) < diskB.getFreeSpace(id))
            return -1;
        else
            return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {

        return 0;
    }

}
