public class ValueVisitor extends Visitor {

    private Float total;

    public ValueVisitor(){
        total = Float.valueOf(0);}


    public Float value(){
        return total;}

    @Override
    public void visitItem(Item item) {
        total = Float.valueOf(0);
        total = item.getPrice();
        //System.out.println(total);
        }

    @Override
    public void visitItemContainer(ItemContainer itemContainer) {
        total = Float.valueOf(0);
        total = itemContainer.getNetPrice();
        //System.out.println(total);
    }

    @Override
    public void visitFarm(Farm farm) {
        total = Float.valueOf(0);
        total = farm.getNetPrice();
        //System.out.println(total);

    }
}
