
class Disk implements ComparableDiskInterface {
    private final int totalSpace = 1000000;
    private static int idCounter = 0; // idCounter
    QueueInterface folders = new ArrayQueue();

    final int id = idCounter++; // disk's id

    /** @return total free space in */
    public int getFreeSpace() {

        return totalSpace - folders.addAll();
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

}
