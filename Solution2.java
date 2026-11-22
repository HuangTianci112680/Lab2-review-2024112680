/**
 * @description:
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
class Solution2 {
    public String removeDuplicateLetters(String s) {
        int[] num = new int[26];
        boolean[] vis = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            num[ch - 'a']--;

            if (vis[ch - 'a']) {
                continue;
            }
            while (sb.length() > 0
                    && sb.charAt(sb.length() - 1) > ch
                    && num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(ch);
            vis[ch - 'a'] = true;
        }
        return sb.toString();
    }
}
