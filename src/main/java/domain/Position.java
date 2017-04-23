package domain;

/**
 * Contains information about one positiion in order
 * @author KostyaHrishenko
 */
public class Position {
    private Goods goods;
    private int count;
    public Position(Goods goods ,int count) {
        setGoods(goods);
        setCount(count);
    }

    /**
     *
     * @return goods id position
     */
    public Goods getGoods() {
        return goods;
    }

    /**
     * Change goods in position
     * @param goods
     */
    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    /**
     *
     * @return count of goods in position
     */
    public int getCount() {
        return count;
    }

    /**
     * Change goods count in posotion
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }
}

