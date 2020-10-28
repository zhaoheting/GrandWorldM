package web.services.learn.lessons.tree;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
    private static class Heap {
        int[] a;
        int theSize;

        public Heap(int capacity) {
            a = new int[capacity];
        }

        private int[] heapify() {
            int start = this.theSize - 1 >> 1;
            for (int i = start; i >= 0; i--) {
                heapify(i);
            }
            return a;
        }

        private int removeMax() {
            int maxVal = a[0];
            a[0] = a[theSize - 1];
            --theSize;
            heapify(0);
            return maxVal;
        }

        private void insert(int x) {
            a[theSize] = x;
            //bottom to top.
            int currentIndex = theSize;
            while ((currentIndex - 1 >> 1) >= 0 && a[currentIndex - 1 >> 1] < a[currentIndex]) {
                int temp = a[currentIndex - 1 >> 1];
                a[currentIndex - 1 >> 1] = a[currentIndex];
                a[currentIndex] = temp;
                currentIndex = currentIndex - 1 >> 1;
            }
            ++theSize;
        }

        private void heapify(int index) {
            //top to bottom.
            int current = index;
            while (current < this.theSize) {
                int maxPosition = current;
                if (2 * current + 1 < this.theSize && a[current] < a[current * 2 + 1]) {
                    maxPosition = 2 * current + 1;
                }
                if (2 * current + 2 < this.theSize && a[maxPosition] < a[current * 2 + 2]) {
                    maxPosition = 2 * current + 2;
                }
                if (current == maxPosition) {
                    break;
                }
                int temp = a[current];
                a[current] = a[maxPosition];
                a[maxPosition] = temp;
                current = maxPosition;
            }
        }
    }

    public static void main(String[] args) {
        int[] stones = new int[3];
        stones[0] = 3;
        stones[1] = 7;
        stones[2] = 8;
//        stones[3] = 1;
//        stones[4] = 8;
//        stones[5] = 1;
        Heap heap = new Heap(3);
        for (int i = 0; i < stones.length; i++) {
            heap.insert(stones[i]);
        }
        heap.heapify();
        while (heap.theSize > 1) {
            int first = heap.removeMax();
            int second = heap.removeMax();
            int newData = first - second;
            if (newData != 0) {
                heap.insert(newData);
            }
        }
        if (heap.theSize != 0) {
            System.out.println(heap.removeMax());
        } else {
            System.out.println(0);
        }
    }
}
