package datastructures.binarytree;

import java.util.List;

public class BinarySearchTemplate {
    public static int findBoundary(List<Boolean> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid)) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static void main(String[] args) {
        int res = findBoundary(List.of(false,false,false,true,true));
        System.out.println(res);
    }
}
