package codeTop;

public class 用Rand7实现Rand10 {
    public int rand7() {
        return 0;
    }
    public int rand10() {
        //1 - 7
        // 0 - 6
        //0 - 9
        int t = rand7();
        return (int)(((t - 1) * 1.5) + 1);
    }
}
