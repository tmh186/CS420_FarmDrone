import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Iterator;

public class Farm extends FarmComponent {

    private String name = "TeamE_Farm";
    private Float Mprice;
    private Float netPrice;
    private ArrayList<FarmComponent> contianer = new ArrayList<FarmComponent>();
    private int height;


    public void addComponent (FarmComponent component){
        contianer.add(component);}

    public void removeComponet(FarmComponent component){
        if (component instanceof ItemContainer){
            ItemContainer temp = (ItemContainer)component;
            temp.removeAll();}

        contianer.remove(component);}

    @Override
    public void SetName(String Name) {
        name=Name;}

    @Override
    public void SetPrice(Float Price) {}

    @Override
    public void setXpos(int Xpos) {}

    @Override
    public void setYpos(int Ypos) {}

    @Override
    public void setLenght(Float Lenght) {}

    @Override
    public void setWidth(Float Width) {}

    @Override
    public void setHeight(int Height) {}

    @Override
    public void setXYpos(int Xpos,int Ypos) {}

    @Override
    public void setMprice(Float mprice) {}

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFarm(this);}

    @Override
    public Float getNetPrice() {
        netPrice = Float.valueOf(0);

        for(int i =0; i<contianer.size();i++){
            netPrice += contianer.get(i).getNetPrice();}

        return netPrice;}

    @Override
    public Float getMprice() {
        Float temp = Float.valueOf(0);

        for(int i =0; i<contianer.size();i++){
            temp += contianer.get(i).getMprice();}

        return temp;}

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Float getPrice() {
        return null;
    }

    @Override
    public int getXpos() {
        return Integer.parseInt(null);
    }

    @Override
    public int getYpos() {
        return Integer.parseInt(null);
    }

    @Override
    public Float getLenght() {
        return null;
    }

    @Override
    public Float getWidth() {
        return null;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
