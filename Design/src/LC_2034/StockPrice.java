package LC_2034;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class StockPrice {

    private HashMap<Integer, Integer> idx2val;
    private int[] lastCell; // [idx, val]
    private TreeMap<Integer, TreeSet<Integer>> val2idxset;
    public StockPrice() {

        this.idx2val = new HashMap<>();
        this.lastCell = new int[2];
        this.val2idxset = new TreeMap<>();
    }

    public void update(int timestamp, int price) {

        // update lastCell
        if (timestamp >= lastCell[0]) {
            lastCell[0] = timestamp;
            lastCell[1] = price;
        }
        // update idx2val and val2idxset
        Integer curVal = idx2val.get(timestamp);
        idx2val.put(timestamp, price);
        if (curVal == null) {
            TreeSet<Integer> curIdxSet = val2idxset.getOrDefault(price, new TreeSet<>());
            curIdxSet.add(timestamp);
            val2idxset.put(price, curIdxSet);
        } else {
            TreeSet<Integer> curIdxSet = val2idxset.get(curVal);
            curIdxSet.remove(timestamp);
            if (curIdxSet.size() == 0) {
                val2idxset.remove(curVal);
            }
            TreeSet<Integer> newIdxSet = val2idxset.getOrDefault(price, new TreeSet<>());
            newIdxSet.add(timestamp);
            val2idxset.put(price, newIdxSet);
        }
    }

    public int current() {
        return lastCell[1];
    }

    public int maximum() {
        return val2idxset.lastKey();
    }

    public int minimum() {
        return val2idxset.firstKey();
    }
}
