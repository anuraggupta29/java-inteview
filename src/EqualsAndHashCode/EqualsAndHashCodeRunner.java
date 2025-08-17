package EqualsAndHashCode;

import java.util.*;

class Solution {
    class CharFrequency {
        private final int[] arr = new int[26];

        CharFrequency(String s){
            for(char c : s.toCharArray()){
                arr[c-'a']++;
            }
        }

        // checks equality between 2 objects of CharFrequency => how the 2 objects should be equated.
        // by default is compares based on object reference (address)
        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj.getClass() != CharFrequency.class) return false;
            return Arrays.equals(arr, ((CharFrequency) obj).arr);
        }

        // generates hash value to be used in hash based collections like HashSet, MashMap, HashTable
        // by default it generates hashCode based on object reference (address)
        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<CharFrequency, List<String>> map = new HashMap<>();
        CharFrequency cf;

        for(String s: strs){
            cf = new CharFrequency(s);
            if(map.containsKey(cf)){
                map.get(cf).add(s);
            }
            else{
                map.put(cf,new ArrayList<>(List.of(s)));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(CharFrequency key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }


    public List<List<String>> groupAnagramsMap(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        String sortedS;
        char[] temp;
        for(String s: strs){
            temp = s.toCharArray();
            Arrays.sort(temp);
            sortedS = new String(temp);
            if(map.containsKey(sortedS)){
                map.get(sortedS).add(s);
            }
            else{
                map.put(sortedS,new ArrayList<>(List.of(s)));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}

public class EqualsAndHashCodeRunner {
    public static void main(String[] args){
        Solution solution = new Solution();
        List<List<String>> ans;
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        // Method 1
        ans = solution.groupAnagramsMap(strs);

        System.out.println("Method 1 : Sorting");
        System.out.println(ans);

        // Method 2
        ans = solution.groupAnagrams(strs);

        System.out.println("Method 1 : FrequencyMap");
        System.out.println(ans);
    }
}
