import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemContainer extends FarmComponent{

    private String    name;
    private Float     price;
    private int    xpos;
    private int    ypos;
    private Float     lenght;
    private Float     width;
    private int     height;
    private Rectangle shape = new Rectangle();
    private ArrayList<FarmComponent> contianer = new ArrayList <FarmComponent> ();
    private Float     Mprice;
    private Float     netPrice;

    ItemContainer(String Name,Float Price,int Xpos,int Ypos,Float Lenght, Float Width,Float Height){
        name = Name; price = Price; xpos = Xpos; ypos = Ypos; lenght = Lenght; width = Width; Height = Height;
        shape = new Rectangle();

        shape.setStroke(Color.GOLD);
        shape.setStrokeWidth(5.0);
        shape.setFill(new Color(0,0.0,0.0,0.0));

        shape.setWidth(Width);
        shape.setHeight(Lenght); //this needs to be lenght so that its a square and not a cube
        shape.relocate(xpos,ypos);}

    public void redraw(){
        shape.relocate(xpos,ypos);}

    public void addComponent (FarmComponent component){
        contianer.add(component);}

    public void removeComponet(FarmComponent component){
        contianer.remove(component);}

    public void removeAll(){
        Iterator iterator = contianer.iterator();

        while (iterator.hasNext()){

            FarmComponent curr = (FarmComponent)iterator.next();

                if(curr instanceof ItemContainer){
                    ((ItemContainer)curr).removeAll();}

            curr.getShape().setVisible(false);
            iterator.remove();}}

    public Float getNetPrice() {
        netPrice = Float.valueOf(0);

        for(int i =0; i<contianer.size();i++){
            netPrice += contianer.get(i).getNetPrice();}

        return netPrice + price;}

//////////////////////////////////////////////////////////////////////
    @Override
    public void SetName(String Name) {
        name =Name;}

    @Override
    public void SetPrice(Float Price) {
        price = Price;}

    @Override
    public void setXpos(int Xpos) {
        xpos = Xpos;
        this.redraw();}

    @Override
    public void setYpos(int Ypos) {
        ypos = Ypos;
        this.redraw();}

    @Override
    public void setLenght(Float Lenght) {
        lenght = Lenght;}

    @Override
    public void setWidth(Float Width) {
        width = Width;}

    @Override
    public void setHeight(int Height) {
        height = Height;}

    @Override
    public void setXYpos(int Xpos, int Ypos) {
        xpos = Xpos;
        ypos = Ypos;
        redraw();
    }

    @Override
    public void setMprice(Float mprice) {
        Mprice = mprice;}

    @Override
    public void accept(Visitor visitor) {
        visitor.visitItemContainer(this);}

    @Override
    public Float getMprice() {
        Float temp = Float.valueOf(0);

        for(int i =0; i<contianer.size();i++){
            temp += contianer.get(i).getNetPrice();}

        return temp + Mprice;}

    @Override
    public String toString() {
        return name;}

    @Override
    public String getName() {
        return name;}

    @Override
    public Float getPrice() {
        return price;}

    @Override
    public int getXpos() {
        return xpos;}

    @Override
    public int getYpos() {
        return ypos;}

    @Override
    public Float getLenght() {
        return lenght;}

    @Override
    public Float getWidth() {
        return width;}

    @Override
    public int getHeight() {
        return height;}

    @Override
    public Shape getShape() {
        return shape;}
//////////////////////////////////////////////////////////////////////

    public String getShortToSting(){
        Iterator iterator = contianer.iterator();
        String temp = ("{"+name);
        while (iterator.hasNext()){
            FarmComponent current = (FarmComponent)iterator.next();
            temp = temp+ ("{"+(current).getName()+"}"); }
        temp = temp +"}";
        return temp;}}
