import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Item extends FarmComponent{
    private String   name;
    private Float    price;
    private int   xpos;
    private int   ypos;
    private Float    lenght;
    private Float    width;
    private int    height;
    private Circle   shape = new Circle();
    private Float    Mprice;


    ///needs a draw call////
    Item(String Name,Float Price,int Xpos,int Ypos,Float Lenght, Float Width,Float Height){
        name = Name; price = Price; xpos = Xpos; ypos = Ypos; lenght = Lenght; width = Width; Height = Height;

        shape.setStroke(Color.DARKGREEN);
        shape.setStrokeWidth(5.0);
        shape.setFill(new Color(0,0.0,0.0,0.0));
        shape.setRadius(25);
        shape.relocate(xpos,ypos);}

    public void redraw(){
        shape.relocate(xpos,ypos);}


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
        redraw();}

    @Override
    public void setYpos(int Ypos) {
        ypos = Ypos;
        redraw();}

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
        visitor.visitItem(this);}

    @Override
    public Float getNetPrice() {
        return price;}

    @Override
    public Float getMprice() {
        return Mprice;
    }

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
}
