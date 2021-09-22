// Time Complexity : O(MN) [M: source length, N: target length]
// Space Complexity : O(M)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

//bruthe force approach
class Solution {
    public int shortestWay(String source, String target) {
        if (source == null || target == null) {
			return -1;
		}

		if (source.length() == 0 && target.length() == 0) {
			return 0;
		}

		if (source.equals(target)) {
			return 1;
		}

		int m = source.length();
		int n = target.length();

		Set<Character> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			set.add(source.charAt(i));
		}

		int pos = 0;
		int i = 0;
		int result = 1;

		while (i < n) {
			char ch = target.charAt(i);

			if (!set.contains(ch)) {
				return -1;
			}

			while (pos < m && source.charAt(pos) != ch) {
				pos++;
			}

			if (pos == m) {
				result++;
				pos = 0;
			} else {
				pos++;
				i++;
			}
		}

		return result;
    }
}