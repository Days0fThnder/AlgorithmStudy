package amazon;

import java.util.*;

public class solution2 {

    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {
        // WRITE YOUR CODE HERE
        Map<String, Integer> results = new HashMap<>();
        for(String possibleFeature : possibleFeatures){
            results.put(possibleFeature, 0);
        }

        for(String featureRequest : featureRequests){
            String formated = featureRequest.toLowerCase();
            formated = formated.replaceAll("[!.?]", "");
            for(String key : results.keySet()){
                if(formated.contains(key)){
                    results.put(key, results.get(key)+1);
                }
            }
        }


        Map<String, Integer> resultsSorted = sortHashMapByValues(results);
        ArrayList<String> resultsArr = new ArrayList<>();
        int topcounter = 0;
        for(String top : resultsSorted.keySet()){
            resultsArr.add(top);
            topcounter++;
            if (topcounter == topFeatures){break;}
        }

        return resultsArr;
    }

    public LinkedHashMap<String, Integer> sortHashMapByValues(
            Map<String, Integer> passedMap) {
        List<String> mapKeys = new ArrayList(passedMap.keySet());
        List<Integer> mapValues = new ArrayList(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<String, Integer> sortedMap =
                new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
}
