public class MarketVisitor extends Visitor {

    private Float total;

    public MarketVisitor(){
        total = Float.valueOf(0);}

    public Float value(){
        return total;}

    @Override
    public void visitItem(Item item) {
        total = Float.valueOf(0);
        total = item.getMprice();
        //System.out.println(total);
    }

    @Override
    public void visitItemContainer(ItemContainer itemContainer) {
        total = Float.valueOf(0);
        total = itemContainer.getMprice();
        //System.out.println(total);
    }

    @Override
    public void visitFarm(Farm farm) {
        total = Float.valueOf(0);
        total = farm.getMprice();
        //System.out.println(total);

    }
}
