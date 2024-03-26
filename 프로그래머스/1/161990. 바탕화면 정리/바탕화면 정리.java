class Solution {
    public int[] solution(String[] wallpaper) {
        int[] minCord = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] maxCord = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++){
                if (wallpaper[i].charAt(j) == '#') {
                    minCord[0] = Math.min(minCord[0], i);
                    minCord[1] = Math.min(minCord[1], j);
                    maxCord[0] = Math.max(maxCord[0], i);
                    maxCord[1] = Math.max(maxCord[1], j);
                }
            }
        }
        int[] answer = new int[]{minCord[0], minCord[1], maxCord[0] + 1, maxCord[1] + 1};
        return answer;
    }
}