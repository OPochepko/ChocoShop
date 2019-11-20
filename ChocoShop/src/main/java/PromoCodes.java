public enum PromoCodes {

    DECIMATION(0, 10), SENATOR(0, 100);

    public int getFixDiscount() {
        return fixDiscount;
    }

    public int getPercentDiscount() {
        return percentDiscount;
    }

    private int fixDiscount;
    private int percentDiscount;

    PromoCodes(int fixDiscount, int percentDiscount) {
        this.fixDiscount = fixDiscount;
        this.percentDiscount = percentDiscount;
    }
}
