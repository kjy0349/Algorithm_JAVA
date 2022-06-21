package leetcode;

public class Replace {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            boolean is_ind = false;
            int s_index = 0;
            for (int j = 0; j < indices.length; j++) {
                if (indices[j] == i) {
                    is_ind = true;
                    s_index = j;
                    break;
                }
            }
            if (is_ind) {
                String target = targets[s_index];
                String source = sources[s_index];
                boolean is_same = true;
                for (int j = 0; j < source.length(); j++) {
                    if (s.charAt(i + j) != source.charAt(j)) {
                        is_same = false;
                        break;
                    }
                }
                if (is_same) {
                    for (int j = 0; j < target.length(); j++) {
                        sb.append(target.charAt(j));
                        i++;
                    }
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
