import javafx.scene.shape.*;

public abstract class FarmComponent {

    public abstract void SetName  (String Name);
    public abstract void SetPrice (Float Price);
    public abstract void setXpos  (int Xpos);
    public abstract void setYpos  (int Ypos);
    public abstract void setLenght(Float Lenght);
    public abstract void setWidth (Float Width);
    public abstract void setHeight(int Height);
    public abstract void setXYpos (int Xpos,int Ypos);
    public abstract void setMprice(Float mprice);

    public abstract void accept(Visitor vistor);

    public abstract Float  getNetPrice();
    public abstract Float  getMprice();
    public abstract String toString();
    public abstract String getName();
    public abstract Float  getPrice();
    public abstract int    getXpos();
    public abstract int    getYpos();
    public abstract Float  getLenght();
    public abstract Float  getWidth();
    public abstract int    getHeight();
    public abstract Shape  getShape();
}
