package com.joker.module.wechat.domain.cardvoucher;

/**
 * Created by zhangjian on 2016/11/18.
 */
public class CashCard extends Card {


    private Cash cash;


    public CashCard() {
        super(CARD_TYPE_CASH);
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public class Cash {
        /**
         * base_info	是	JSON结构	见上述示例。	基本的卡券数据，见下表，所有卡券通用。
         */
        private BaseInfo baseInfo;
        private AdvancedInfo advancedInfo;

        /**
         * least_cost	是	int	10000	代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0。
         */
        private int leastCost;
        /**
         * reduce_cost	是	int	10000	代金券专用，表示减免金额。（单位为分）
         */
        private int reduceCost;

        public BaseInfo getBaseInfo() {
            return baseInfo;
        }

        public void setBaseInfo(BaseInfo baseInfo) {
            this.baseInfo = baseInfo;
        }

        public AdvancedInfo getAdvancedInfo() {
            return advancedInfo;
        }

        public void setAdvancedInfo(AdvancedInfo advancedInfo) {
            this.advancedInfo = advancedInfo;
        }

        public int getLeastCost() {
            return leastCost;
        }

        public void setLeastCost(int leastCost) {
            this.leastCost = leastCost;
        }

        public int getReduceCost() {
            return reduceCost;
        }

        public void setReduceCost(int reduceCost) {
            this.reduceCost = reduceCost;
        }
    }
}
