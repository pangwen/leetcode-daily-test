package longestStrWithoutRepeatingChar;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * Created on 2021/5/7.
 *
 * @author pangwen
 * @version 0.1
 */
public class LongestSubstringSolution {

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            //左移一格，集合也删除前一个字符
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right < len && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - i);
        }
        return max;
    }


    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
