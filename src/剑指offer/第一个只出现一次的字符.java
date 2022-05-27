package 剑指offer;

import java.util.LinkedHashMap;

public class 第一个只出现一次的字符 {

    public char firstUniqChar(String s) {
        LinkedHashMap<Character,Boolean> map = new LinkedHashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,true);
            } else {
                map.put(c,false);
            }
        }
        for (Character character : map.keySet()) {
            if(map.get(character))return character;
        }
        return ' ';
    }
}
