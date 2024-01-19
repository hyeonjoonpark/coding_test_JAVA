package Algorithm.Search.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int key, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2; // 오버플로 방지

        if (arr[mid] < key) {
            return binarySearch(arr, key, mid + 1, right); // 오른쪽 탐색
        } else if (arr[mid] > key) {
            return binarySearch(arr, key, left, mid - 1); // 왼쪽 탐색
        } else {
            return mid; // 찾은 경우, 인덱스 반환
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 배열 요소 갯수 입력
        int key = sc.nextInt(); // 검색할 값
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array); // BinarySearch는 무조건 정렬되어있어야 함

        int result = binarySearch(array, key, 0, N - 1);

        if (result == -1) {
            System.out.println("찾는 값이 존재하지 않습니다");
        } else {
            System.out.println(result); // 찾는 값의 인덱스 출력
        }

        sc.close();
    }
}