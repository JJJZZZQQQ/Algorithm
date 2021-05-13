package leetcode每日一题;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> vals;
    private Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        vals = new ArrayList<>();
        dfs(nestedList);
        cur = vals.iterator();
    }
    @Override
    public Integer next() {
        return cur.next();
    }
    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }
    public void dfs(List <NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()){
                vals.add(nestedInteger.getInteger());
            }
            else {
                dfs(nestedInteger.getList());
            }
        }
    }
}
