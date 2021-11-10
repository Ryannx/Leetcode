package LC_714;

public class LC_714 {
    public int maxProfit(int[] prices, int fee) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int buy = 0;
        int sell = 0;
        int preBuy = Integer.MIN_VALUE / 2;
        int preSell = 0;
        for (int i = 0; i < len; i++) {
            buy = Math.max(preBuy, preSell - prices[i]);
            sell = Math.max(preSell, preBuy + prices[i] - fee);
            preBuy = buy;
            preSell = sell;
        }

        return sell;
    }
}
