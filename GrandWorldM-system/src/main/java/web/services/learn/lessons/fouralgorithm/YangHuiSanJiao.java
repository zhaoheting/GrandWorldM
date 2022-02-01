package web.services.learn.lessons.fouralgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author HeTing.Zhao
 * @since 2022/2/1
 */
public class YangHuiSanJiao {


    public static void main(String[] args) {
        new YangHuiSanJiao().solve();
    }

    private void initList(List<List<Integer>> list) {
        List<Integer> list1 = new ArrayList<Integer>() {
            {
                add(5);
            }
        };
        list.add(list1);
        List<Integer> list2 = new ArrayList<Integer>() {
            {
                add(7);
                add(8);
            }
        };
        list.add(list2);
        List<Integer> list3 = new ArrayList<Integer>() {
            {
                add(2);
                add(3);
                add(4);
            }
        };
        list.add(list3);
        List<Integer> list4 = new ArrayList<Integer>() {
            {
                add(4);
                add(9);
                add(6);
                add(1);
            }
        };
        list.add(list4);
        List<Integer> list5 = new ArrayList<Integer>() {
            {
                add(2);
                add(7);
                add(9);
                add(4);
                add(5);
            }
        };
        list.add(list5);
    }

    /**
     * 杨辉三角从顶端到底端的最短路径问题。
     */
    private void solve() {
        List<List<Integer>> list = new ArrayList<>();
        initList(list);
        int listSize = list.size();
        //Init left and right.
        for (int i = 1; i < listSize; ++i) {
            List<Integer> preList = list.get(i - 1);
            List<Integer> currentList = list.get(i);
            currentList.set(0, preList.get(0) + currentList.get(0));
            currentList.set(currentList.size() - 1, preList.get(preList.size() - 1) + currentList.get(currentList.size() - 1));
        }
        if (list.size() > 2) {
            for (int j = 2; j < list.size(); ++j) {
                List<Integer> preList = list.get(j - 1);
                List<Integer> currentList = list.get(j);
                for (int m = 1; m < currentList.size() - 1; ++m) {
                    currentList.set(m, Math.min(preList.get(m - 1), preList.get(m)) + currentList.get(m));
                }
            }
        }
        List<Integer> lastList = list.get(list.size() - 1);
        int length = lastList.size();
        int result = Integer.MAX_VALUE;
        for (int n = 0; n < length; ++n) {
            System.out.println(lastList.get(n));
            result = Math.min(result, lastList.get(n));
        }
        System.out.println(result);
    }
}
