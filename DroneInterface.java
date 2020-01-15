import javafx.scene.shape.Shape;

 interface DroneInterface {

     void redraw();
    /*
    redraws the image of the drone
     */

    //////////////////////////////////////////////////////////////////////
    void SetName(String Name);
    /*
    sets the name of the drone
     */

    void SetPrice(Float Price);
    /*
    sets the name of the drone
     */

    void setXpos(int Xpos);
    /*
    sets the x position of the drone
     */

    void setYpos(int Ypos);
    /*
   sets the y position of the drone
     */

    void setLenght(Float Lenght);
    /*
    sets the length of the drone
     */

    void setWidth(Float Width);
    /*
    sets the width of the drone
     */

    void setHeight(int h);
    /*
    sets the height of the drone
     */

    void setXYpos(int Xpos, int Ypos);
    /*
    sets the x and y positions of the drone
     */

    void setMprice(Float mprice);
    /*
    sets the MPrice of the drone
     */

    void accept(Visitor visitor);
    /*
    accepts a visitor object
     */

    Float getNetPrice();
    /*
    returns the name of the drone
     */

    Float getMprice();
    /*
    returns the Mprice of the drone
     */

    @Override
    String toString();
    /*
    returns the description of the drone
     */

    String getName();
    /*
    returns the name of the drone
     */

    Float getPrice();
    /*
    returns the price of the drone
     */

    int getXpos();
    /*
    returns the x position of the drone
     */

    int getYpos();
    /*
    returns the y position of the drone
     */

    Float getLenght();
    /*
    returns the length of the drone
     */

    Float getWidth();
    /*
    returns the width of the drone
     */

    int getHeight();
    /*
    returns the height of the drone
     */

    Shape getShape();
    /*
    returns the shape of the drone
     */

    void setFlying(boolean b);
    /*
    sets whether the drone is flying or not
     */

    boolean getFlying();
    /*
    returns returns whether the drone is flying or not
     */

    void setCmdCntrX(int x);
    /*
    sets the x coordinate of the drone's command center
     */

    int getCmdCntrX();
    /*
    returns the x coordinate of the drone's command center
     */

    void setCmdCntrY(int y);
    /*
    sets the y coordinate of the drone's command center
     */

    int getCmdCntrY();
    /*
    returns the y coordinate of the drone's command center
     */

    void setOrientation(int x);
    /*
    sets the orientation of the drone in degrees
     */

    int getOrientation();
     /*
    gets the orientation of the drone in degrees
     */







}
