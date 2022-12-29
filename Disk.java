
class Disk implements ComparableDiskInterface {
    private final int totalSpace = 1000000;
    private static int idCounter = 0; // idCounter
    private QueueInterface folders = new ArrayQueue();

    final int id = idCounter++; // disk's id

    /** @return total free space in */
    public int getFreeSpace() {

        return totalSpace - folders.getItemSizeSum();
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
        Disk disk2 = new Disk();

        disk.folders.enqueue("ergasia.java", 2000);
        disk.folders.enqueue("ergasia.py", 30500);
        disk2.folders.enqueue("ergasia.java", 13000);
        disk2.folders.enqueue("ergasia.py", 123500);

        System.out.println(disk2.id);
        disk.folders.printQueue();
        System.out.println(disk.id);

        System.out.println(disk2.getFreeSpace());
        System.out.println(disk.compareTo(disk2));
    }
}
