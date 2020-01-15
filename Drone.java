import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;



public class Drone extends FarmComponent implements DroneInterface {
    //this is TECHNICALLY where the commands to the drone display that are called in Controller are SUPPOSED to be.
    //this class is the one that the teacher wrote on the right hand side of the board, but we don't technically
    //NEED to have an interface for it.

    private String      name;
    private Float       price;
    private int      xpos;
    private int      ypos;
    private Float       lenght;
    private Float       width;
    private int       height;
    private Circle      shape = new Circle();
    //private Adapter DroneAdapter;
    private int Orientation;
    private int CmdCntrX;
    private int CmdCntrY;
    private boolean flying;

    Drone(String Name,Float Price,int Xpos,int Ypos,Float Lenght, Float Width, int Height){
        name = Name; price = Price; xpos = Xpos; ypos = Ypos; lenght = Lenght; width = Width; height = Height;

        //DroneAdapter = new Adapter();
        shape.setFill(Color.AQUAMARINE);
        shape.setRadius(25);
        shape.relocate(xpos,ypos);
        Orientation = 0;
        setCmdCntrX(Xpos);
        setCmdCntrY(Ypos);
        flying = false;
    }


    public void redraw(){
        shape.relocate(xpos,ypos);}

    //////////////////////////////////////////////////////////////////////
    @Override
    public void SetName(String Name) {
        name = Name;}

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
    public void setHeight(int h) {
        height = h;}

   @Override
    public void setXYpos(int Xpos, int Ypos) {
        xpos = Xpos;
        ypos = Ypos;
        redraw();
    }

    @Override
    public void setMprice(Float mprice) {}

    @Override
    public void accept(Visitor visitor) {}

    @Override
    public Float getNetPrice() {
        return null;
    }

    @Override
    public Float getMprice() {
        return null;
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
    public Float getWidth() { return width;}

    public int getHeight() {
        return height;
    }

    @Override
    public Shape getShape() {
        return shape;}

    public void setFlying(boolean b) {
        //changes boolean check for if the physical drone is currently in the air or not
        flying = b;
    }

    public boolean getFlying() {
        //returns if the physical drone is currently in the air or not
        return flying;
    }

    public void setCmdCntrX(int x) {
        CmdCntrX = x;
    }

    public int getCmdCntrX() {
        return CmdCntrX;
    }

    public void setCmdCntrY(int y) {
        CmdCntrY = y;
    }

    public int getCmdCntrY() {
        return CmdCntrY;
    }

    public void setOrientation(int x) {
        Orientation = x;
    }

    public int getOrientation() {
        return Orientation;
    }

    /*--------------------------------------------DEPRECATED-------------------------------------------------------------
    public void  physDroneTurnCW(int degrees){
        //turn physical drone right
        turnCW(degrees);
        Orientation = Orientation + degrees; //update orientation variable
        orientCheck(); //make sure degrees are correct
    }

    public void  physDroneTurnCCW(int degrees){
        //turn physical drone left
        turnCCW(degrees);
        Orientation = Orientation - degrees; //update orientation variable
        orientCheck(); //make sure degrees are correct
    }


    public void physDroneBeginDrone(){
        //turns physical drone program on. Call at beginning of the program
        DroneAdapter.beginProgram();
    }

    public void physDroneEndDrone(){
        //turns physical drone off. Call at end of the program
        DroneAdapter.endProgram();
    }

    public void physDroneSetSpeed(int s) {
        //adjusts physical drone flying speed
        //PIXELS_TO_ONE_MODEL_FOOT = 25; // on screen pixels to one real world foot
        DroneAdapter.setSpeed(s * Constants.PIXELS_TO_ONE_MODEL_FOOT);
    }

    public void physDroneTakeoff(){
        //makes physical drone fly. Call before movements
        DroneAdapter.takeoff();
    }

    public void physDroneLand(){
        //land physical drone. Call at the end of all drone commands
        DroneAdapter.land();
    }

    public void physDroneStreamOn(){
        //allows physical drone to receive commands. Call at beginning of the program
        DroneAdapter.streamOn();
    }

    public void physDroneStreamOff(){
        //drone can no longer receive commands. Call at end of program
        DroneAdapter.streamOff();
    }

    public void physDroneFlyUp(int n){
        //physical drone flies up on Z axis
        DroneAdapter.flyUpward(n * Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

    public void physDroneFlyDown(int n){
        //physical drone flies down on Z axis
        DroneAdapter.flyDown(n * Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

    public void physDroneFlyLeft(int n){
        //physical drone left on x axis
        DroneAdapter.flyLeft(n * Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

    public void physDroneFlyRight(int n){
        //physical drone right on x axis
        DroneAdapter.flyRight(n * Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

    public void physDroneFlyForward(int n){
        //physical drone flies forward
        DroneAdapter.flyForward(n * Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

    public void physDroneFlyBackward(int n) {
        //physical drone flies backward
        DroneAdapter.flyBackward(n * Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

     */

//////////////////////////////////////////////////////////////////////
}
