public abstract class Visitor {

    public abstract void visitItem(Item item);
    public abstract void visitItemContainer(ItemContainer itemContainer);
    public abstract void visitFarm(Farm farm);

}
