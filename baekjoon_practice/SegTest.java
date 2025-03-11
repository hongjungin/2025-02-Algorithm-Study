public class SegTest {
    static class Seg{
        static class Node{
            long min, max;
            Node(long min, long max) {
                this.min = min;
                this.max = max;
            }
        }
        int size;
        long[] arr;
        Node[] tree;

        Seg(int n) {
            size = n;
            int height = (int) Math.ceil(Math.log(n) / Math.log(2));
            int segSize = 2 << height;
            arr = new long[n];
            tree = new Node[segSize];
        }
    }
    public static void main(String[] args) {

    }
}
