package google;

/**
 * Created by j_rus on 11/16/2016.
 */
public class SolutionJ {

    public int spareSearch(String target, String [] words){
        return spareSearch(target, words, 0, words.length -1);
    }

    public int spareSearch(String target, String [] words, int low, int high){
        if(high >= low){
            int mid = (high + low)/2;
            int tempMid = mid;
            while(words[tempMid].isEmpty()){
                if(tempMid <= mid && tempMid >= 0){
                    tempMid--;
                }
                if(tempMid<0){
                    tempMid = mid+1;
                }
                if(tempMid > mid && tempMid <= high){
                    tempMid++;
                }
                mid = tempMid;
            }

            if(words[mid].equals(target)){
                return mid;
            }else if(words[mid].compareTo(target) < 0){
                return spareSearch(target, words, mid + 1, high);
            }else{
                return spareSearch(target, words,low, mid -1);
            }
        }

        return -1;
    }

    public static void main(String [] arg){
        String target = "paul";
        String [] words = {"asterly", "", "", "billy", "carl","", "", "", "jean", "paul", "shane", "tori", ""};
        SolutionJ sj = new SolutionJ();
        sj.spareSearch(target, words);

    }
}
