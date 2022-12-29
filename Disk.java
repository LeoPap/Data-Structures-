
class Disk implements ComparableDisk {
    private final int totalSpace = 1000000;
    private static int idCounter = 0; // idCounter
    private String folders[]; // folders array
    final int id = idCounter++; // disk's id

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
        disk.folders = new String[1];
        disk.folders[0] = "java";
        System.out.println(disk.folders[0]);
        Disk disk2 = new Disk();
        System.out.println(disk.id);
        System.out.println(disk2.id);
        // disk.compareTo(disk2);
    }
}
