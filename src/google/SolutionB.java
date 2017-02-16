package google;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by j_rus on 10/6/2016.
 */
public class SolutionB {
    static class IceCream implements Comparable<IceCream>{
        int flavor;
        int index;

        public IceCream(int flavor, int index) {
            this.flavor = flavor;
            this.index = index;
        }

        @Override
        public int compareTo(IceCream o) {
            return (this.flavor <  o.flavor ) ? -1: (this.flavor >  o.flavor) ? 1:0 ;

        }

        @Override
        public boolean equals(Object o){
            // If the object is compared with itself then return true
            if (o == this) {
                return true;
            }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
            if (!(o instanceof IceCream)) {
                return false;
            }

            // typecast o  so that we can compare data members
            IceCream c = (IceCream) o;

            // Compare the data members and return accordingly
            return Integer.compare(flavor, c.flavor) == 0
                    && Integer.compare(index, c.index) == 0;
        }

    }
    public static int binarySearch(int first, int last, IceCream[] arr, int search) {

        if(last >= first){
            int mid = first + (last - first)/2;
            if(arr[mid].flavor == search){
                return arr[mid].index;
            }
            else if(search < arr[mid].flavor )
                return binarySearch( first, mid - 1, arr, search);
            else if(search > arr[mid].flavor){
                return binarySearch( mid + 1, last, arr, search);
            }
        }
        return -1;

    }

    public static void main(String[] args) {

        int t;
        int n, m;

        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for(int test = 0; test < t; test++) {

            m = in.nextInt();
            n = in.nextInt();
            IceCream[] arr = new IceCream[n];

            for (int i = 0; i < n; i++)
                arr[i] = new IceCream(in.nextInt(), i + 1);

            Arrays.sort(arr);
            int firstIndex = 100000, secondIndex = 100000;
            for(int i = 0; i < n - 1 ; i++) {
                int search = m - arr[i].flavor;
                if(search >= arr[i].flavor) {
                    int index = binarySearch( i, n - 1, arr, search);
                    if( index != -1 ) {
                        System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                        break;

                    }
                }
            }

        }

    }
}
