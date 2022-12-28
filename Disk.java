
class Disk {

    private int id; //
    private String[] folders;
class Disk implements ComparableDisk {
    private final int totalSpace = 1000000;
    // private int id; // disk's id
    private String folders[]; // folders array

    /** @return total free space in */
    public int getFreeSpace() {
        return totalSpace - folders.length;
    }

    @Override
    public int compareTo(Disk diskB) {
        if (this.getFreeSpace() > diskB.getFreeSpace())
            return 1;
        else if (this.getFreeSpace() < diskB.getFreeSpace())
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {

        Disk disk = new Disk();
        System.out.println(disk.getFreeSpace());
        disk.folders[1] = "java";
        Disk disk2 = new Disk();
        disk.compareTo(disk2);
    }
}

public interface ComparableDisk {
    public int compareTo(Disk b);
}


    /** @return total free space in */
    public int getFreeSpace() {
        return 0;
    }
}
