package interviewCake;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinPossobilities {

    public static int changePossibilitiesTopDown(int amount, int[] denominations) {
        return changePossibilitiesTopDown(amount, denominations, 0);
    }

    private static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex) {


        Map<String, Integer> memo = new HashMap<>();
        // check our memo and short-circuit if we've already solved this one
        String memoKey = amountLeft + ", " + currentIndex;
        if (memo.containsKey(memoKey)) {
            System.out.println("grabbing memo [" + memoKey + "]");
            return memo.get(memoKey);
        }

        // base cases:
        // we hit the amount spot on. yes!
        if (amountLeft == 0) {
            return 1;
        }

        // we overshot the amount left (used too many coins)
        if (amountLeft < 0) {
            return 0;
        }

        // we're out of denominations
        if (currentIndex == denominations.length) {
            return 0;
        }

        System.out.println(String.format("checking ways to make %d with %s",
                amountLeft, Arrays.toString(Arrays.copyOfRange(denominations,
                        currentIndex, denominations.length))));

        // choose a current coin
        int currentCoin = denominations[currentIndex];

        // see how many possibilities we can get
        // for each number of times to use currentCoin
        int numPossibilities = 0;
        while (amountLeft >= 0) {
            numPossibilities += changePossibilitiesTopDown(amountLeft, denominations,
                    currentIndex + 1);
            amountLeft -= currentCoin;
        }

        // save the answer in our memo so we don't compute it again
        memo.put(memoKey, numPossibilities);
        return numPossibilities;
    }

    public static void main(String [] arg){
        int [] denominations = {1,2,3};
        changePossibilitiesTopDown(4, denominations);
    }

}
