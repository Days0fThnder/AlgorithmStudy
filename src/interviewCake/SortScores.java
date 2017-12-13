package interviewCake;

public class SortScores {

    public static int [] sortScores(int [] unsortedScores, int HIGHEST_POSSIBLE_SCORE){
        int[] countArr = new int [HIGHEST_POSSIBLE_SCORE +1];
        int unsortedIdx = 0;

        for (int i = 0; i < unsortedScores.length; i++) {
            countArr[unsortedScores[i]] = countArr[unsortedScores[i]] + 1;
        }

        for (int i = HIGHEST_POSSIBLE_SCORE; i >=0 ; i--) {
            if(countArr[i] > 0){
                for (int j = 0; j < countArr[i] ; j++) {
                    unsortedScores[unsortedIdx] = i;
                    unsortedIdx++;
                }
            }
        }

        return unsortedScores;
    }

    public static void main(String [] arg){
        int[] unsortedScores = {37, 89, 91, 41, 65, 91, 53};
        final int HIGHEST_POSSIBLE_SCORE = 100;

        sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
    }
}
