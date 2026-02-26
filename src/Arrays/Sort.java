package Arrays;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {75,35,98,21};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //ascending order
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j< arr.length;j++){
                if(arr[i]>arr[j]){//ascending
                    // if(arr[i]>arr[j]){//descending
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
