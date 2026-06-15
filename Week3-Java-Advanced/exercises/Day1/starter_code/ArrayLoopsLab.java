
public class ArrayLoopsLab {
    public static void reverse(int [] data){
        for(int i= 0; i < data.length/ 2; i++){
           int reverse_index = data.length - 1 - i;
            int temp =  data[reverse_index];
            data[reverse_index] = data[i];
            data[i] = temp;
        }
    }

    public static int min(int [] data){
        if(data == null || data.length == 0)
            throw new IllegalArgumentException("Illegal Array Length");

        int min = data[0];

        for(int number : data){
            if(number < min){
                min = number;
            }
        }

        return min;
    }

    public static int max(int [] data){
        if(data == null || data.length == 0)
            throw new IllegalArgumentException("Illegal Array Length");

        int max = data[0];

        for(int number : data){
            if(number > max){
                max = number;
            }
        }

        return max;
        
    }

    public static void sortAscending(int[] data){

        for(int i = 0; i < data.length; i++)
        {
            for(int j = 0; j < data.length - i - 1; j++){
                if(data[j] > data[j+1])
                {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    } 
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int [] arr2 = {5,2,3,1,4,6};

        System.out.println("Before Reverse");
        for(int num : arr)
        {
            System.out.print(num + " ");
        }
        reverse(arr);
        System.out.println("\nAfter Reverse");
        for(int num : arr)
        {
            System.out.print(num + " ");
        }

        System.out.println("\nMin: " + min(arr));
        System.out.println("Max: " + max(arr));

        System.out.println("Before Ascending Sort");
        for(int num : arr2)
        {
            System.out.print(num + " ");
        }
        sortAscending(arr2);
        System.out.println("\nAfter Ascending Sort");
        for(int num : arr2)
        {
            System.out.print(num + " ");
        }
    }
}
