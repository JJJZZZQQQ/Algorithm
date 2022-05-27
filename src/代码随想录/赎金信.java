package 代码随想录;

public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] count = new int[127];
        int length = magazine.length();
        for (int i = 0; i < length; i++) {
            count[magazine.charAt(i)]++;
        }
        int length1 = ransomNote.length();
        for (int i = 0; i < length1; i++) {
            char c = ransomNote.charAt(i);
            if(count[c] > 0)count[c]--;
            else return false;
        }
        return true;
    }
}
