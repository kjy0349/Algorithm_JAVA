package Programmers;

import java.util.*;
public class word_convert {
    public static class Item{
        String str;
        int move;
        Item(String str, int move){
            this.str = str;
            this.move = move;
        }
    }
    public static boolean compare_word(String word1, String word2){
        int count = 0;
        char[] word1s = word1.toCharArray();
        char[] word2s = word2.toCharArray();
        for (int i = 0; i < word1.length(); i++){
            if (word1s[i] != word2s[i]){
                count += 1;
            }
        }
        return count == 1;
    }
    public static int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;
        boolean[] visited = new boolean[words.length];
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(begin, 0));

        while(!queue.isEmpty()){
            Item item = queue.poll();
            if(item.str.equals(target)) return item.move;
            for (int i = 0; i < words.length; i++){
                if(compare_word(item.str, words[i]) && !visited[i]){
                    visited[i] = true;
                    queue.add(new Item(words[i], item.move + 1));
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}))  ;
    }
}
