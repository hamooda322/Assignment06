
class HanoiAlgorithm {

    public static void main(String[] args) {
        System.out.println(TowerOfHanoi(4).length());
    }

    public static String TowerOfHanoi(Integer disks) {
        if (disks <= 1) {
            return "1";
        }

        String sequence = TowerOfHanoi(disks - 1) + Integer.toString(disks) + TowerOfHanoi(disks - 1);
        return sequence;
    }
}