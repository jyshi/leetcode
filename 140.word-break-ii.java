/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }
    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> result = new LinkedList<String>();
        if (s.length() == 0) {
            // end of the string
            result.add("");
            return result;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = dfs(s.substring(word.length()), wordDict, map);
                for (String subStr : list) {
                    if (subStr.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + subStr);
                    }
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
// @lc code=end
cats + and

