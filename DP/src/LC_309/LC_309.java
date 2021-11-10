package LC_309;

public class LC_309 {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 前天，昨天，今天
        int buy1 = 0;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE / 2;
        int sell2 = 0;
        int buy3 = 0;
        int sell3 = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            buy3 = Math.max(buy2, sell1 - prices[i]);
            sell3 = Math.max(sell2, buy2 + prices[i]);
            buy1 = buy2;
            sell1 = sell2;
            buy2 = buy3;
            sell2 = sell3;
        }

        return sell3;
    }

    public static void main(String[] args) {
        LC_309 lc_309 = new LC_309();
        int[] prices = {1,2,3,0,2};
        System.out.println(lc_309.maxProfit(prices));
    }
}
