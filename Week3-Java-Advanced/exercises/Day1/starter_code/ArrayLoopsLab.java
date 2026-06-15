
public class ArrayLoopsLab {
    public static void reverse(int [] data){
        for(int i= 0; i < data.length/ 2; i++){
           int reverse_index = data.length - 1 - i;
            int temp =  data[reverse_index];
            data[reverse_index] = data[i];
            data[i] = temp;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        for(int num : arr)
        {
            System.out.println(num);
        }
        reverse(arr);
        for(int num : arr)
        {
            System.out.println(num);
        }
    }
}
