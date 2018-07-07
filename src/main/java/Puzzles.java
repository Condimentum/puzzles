import java.util.*;

public class Puzzles
{

    /**
     * Puzzle 1
     * Select the longest words from the input list. That is, select the words
     * whose lengths are equal to the maximum word length.
     */
    // Time complexity: O(n)
    public static List<String> selectLongestWords( List<String> input )
    {
        List<String> result = new ArrayList<>();
        int maxLen = 0;
        for (String word : input) {
            // If word is longer than any word before, set maxLen and clear result
            if (word.length() > maxLen) {
                maxLen = word.length();
                result = new ArrayList<>();
            }
            // If word is as long as the longest word so far, add it to list
            if (word.length() == maxLen) {
                result.add(word);
            }
        }

        return result;
    }

    /**
     * Puzzle 2
     * Given a list of words, create an output list that contains
     * only the odd-length words, converted to upper case.
     */
    // Time complexity: O(n)
    public static List<String> upcaseOddLengthWords( List<String> input)
    {
        List<String> result = new ArrayList<>();
        for (String word : input) {
            // If the word length is odd, add uppercase version to list
            if (word.length() % 2 == 1) {
                result.add(word.toUpperCase());
            }
        }

        return result;
    }

    /**
     * Puzzle 3
     * Given a list of words, populate a map whose keys are the initial characters of
     * each word, and whose values are the concatenation of the words with that
     * initial character. When concatenating the words, they should be
     * separated by a colon (':').
     */
    // Time complexity: O(n)
    public static Map<Character, String> mapOfStringByInitialCharacter( List<String> input )
    {
        Map<Character, String> result = new TreeMap<>();
        for (String word : input) {
            // Get lower case inital character
            Character initial = Character.toLowerCase(word.charAt(0));
            // If map key already exists, add word to the value
            if(result.containsKey(initial)) {
                result.put(initial, result.get(initial) + ":" + word);
            }
            // If map key doesn't exist, assign the word to the key
            else {
                result.put(initial, word);
            }
        }

        return result;
    }

    /**
     * Puzzle 4
     * Denormalize this map. The input is a map whose keys are the number of legs of an animal
     * and whose values are lists of names of animals. Run through the map and generate a
     * "denormalized" list of strings describing the animal, with the animal's name separated
     * by a colon from the number of legs it has. The ordering in the output list is not
     * considered significant.
     *
     * Input is Map<Integer, List<String>>:
     *   { 4=["ibex", "hedgehog", "wombat"],
     *     6=["ant", "beetle", "cricket"],
     *     ...
     *   }
     *
     * Output should be a List<String>:
     *   [ "ibex:4",
     *     "hedgehog:4",
     *     "wombat:4",
     *     "ant:6",
     *     "beetle:6",
     *     "cricket:6",
     *     ...
     *   ]
     */
    public static List<String> denormilizeMap( Map<Integer, List<String>> input )
    {
        List<String> result = new ArrayList<>();
        // Iterate (key, value) pairs
        input.forEach((Integer k, List<String> v) -> {
            // Iterate animal list and add animal to result list
            for (String animal : v) {
                result.add(animal + ":" + k.toString());
            }
        });

        return result;
    }

    /**
     * Puzzle 5
     * Invert a "multi-map".
     *
     * Given a Map<X, Set<Y>>, convert it to Map<Y, Set<X>>.
     * Each set member of the input map's values becomes a key in
     * the result map. Each key in the input map becomes a set member
     * of the values of the result map. In the input map, an item
     * may appear in the value set of multiple keys. In the result
     * map, that item will be a key, and its value set will be
     * its corresopnding keys from the input map.
     *
     * In this case the input is Map<String, Set<Integer>>
     * and the result is Map<Integer, Set<String>>.
     *
     * For example, if the input map is
     *     {p=[10, 20], q=[20, 30]}
     * then the result map should be
     *     {10=[p], 20=[p, q], 30=[q]}
     * irrespective of ordering. Note that the Integer 20 appears
     * in the value sets for both p and q in the input map. Therefore,
     * in the result map, there should be a mapping with 20 as the key
     * and p and q as its value set.
     *
     * It is possible to accomplish this task using a single stream
     * pipeline (not counting nested streams), that is, in a single pass
     * over the input, without storing anything in a temporary collection.
     */
    public static Map<Integer, Set<String>> invertMultiMap( Map<String, Set<Integer>> input )
    {
        Map<Integer, Set<String>> result = new TreeMap<>();
        input.forEach((k, v) -> {
            for (int number : v) {
                Set<String> newValue;
                // If map key exists, get current value set
                if(result.containsKey(number)) {
                    newValue = result.get(number);
                }
                // If map key doesn't exist, create new value set
                else {
                    newValue = new TreeSet<>();
                }
                // Add key to value set
                newValue.add(k);
                result.put(number, newValue);
            }
        });

        return result;
    }
}
