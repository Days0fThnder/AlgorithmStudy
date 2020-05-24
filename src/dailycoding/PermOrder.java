package dailycoding;



public class PermOrder {

    public void perm(char[] arr, int[] perm){

        for (int i = 0; i < perm.length ; i++) {

            //if(!(perm[i] <= i))
                swap(i, perm[i], arr);
        }
    }

    private void swap(int a, int b, char[] arr){
        char temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static void main(String [] args){

        PermOrder permOrder = new PermOrder();
        char[] arr = {'a','b','c','d'};
        int[] perm = {1,3,0,2};
        permOrder.perm(arr, perm);

        System.out.println("-----------------");
    }
}
