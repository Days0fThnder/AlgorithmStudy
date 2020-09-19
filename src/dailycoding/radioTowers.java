package dailycoding;

public class radioTowers {

    public int minimumRange(int [] listeners, int[] towers){

        int min = 0;
        int currMin = 0;
        int towIdx = 0;
        int listIdx = 0;

        while ( listIdx < listeners.length) {

            currMin = Math.max(currMin, Math.abs(listeners[listIdx] - towers[towIdx]));

            if(min == 0){
                min = currMin;
            }
            if(currMin > min){
                if(towIdx < towers.length){ towIdx++;}


            }else{
                listIdx++;
            }
        }

        return 0;
    }
}
