public class Adapter implements PhysicalDrone {
    //this is where any new functions and functionality for the drone to meet 2nd half of project requirements
    //are supposed to be added.
    //physical drone stuff is here now too, but can also add stuff to affect display.
    //think of this class like "indirectly implementing PhysicalDrone interface for drone.

    private PhysicalDroneTello TelloAdap = new PhysicalDroneTello(); //allows us to send commands to physical drone

    Drone drone; //our input drone object

    public Adapter(Drone d) {
        drone = d;
        setSpeed(1); //moves physical drone to, what should be, 1 foot a second. Needs testing to align with display
    }

    public void setDrone(Drone Drone) {
        drone = Drone;
    }

    public Drone getDrone() {
        return drone;
    }

    public void beginProgram() {
        TelloAdap.beginProgram();
    }

    public void endProgram() {
        TelloAdap.endProgram();
    }

    public void takeoff() {
        TelloAdap.takeoff();
        drone.setFlying(true); //drone is now flying
    }

    public void land() {
        TelloAdap.land();
        drone.setFlying(false); //drone has landed
    }

    public void streamOn() {
        TelloAdap.streamOn();
    }

    public void streamOff() {
        TelloAdap.streamOff();
    }

    public void missionPadOn() {
        TelloAdap.missionPadOn();
    }

    public void missionPadOff() {
        TelloAdap.missionPadOff();
    }

    public void missionPadDirection(int param) {
        TelloAdap.missionPadDirection(param);
    }

    public void flyUpward(int up) {
        if (up < 20 || up > 500) return;
        TelloAdap.flyUpward(up);
    }

    public void flyDown(int down) {
        if (down < 20 || down > 500) return;
        TelloAdap.flyDown(down);
    }

    public void flyForward(int front) {
        if (front < 20) {
            return;
        } else {
            if (front > 500) {
                //make up for remainder of drone overflow movement (under 1001)
                TelloAdap.flyForward(((front-500)/Constants.PIXELS_TO_ONE_MODEL_FOOT)* Constants.CENTIMETERS_PER_MODEL_FOOT);
                TelloAdap.flyForward((500/Constants.PIXELS_TO_ONE_MODEL_FOOT) * Constants.CENTIMETERS_PER_MODEL_FOOT);
            } else {
                //normal movement
                TelloAdap.flyForward((front/Constants.PIXELS_TO_ONE_MODEL_FOOT) * Constants.CENTIMETERS_PER_MODEL_FOOT);
            }
        }
    }

    public void flyBackward(int back) {
        if (back < 20 || back > 500) return;
        TelloAdap.flyBackward((back/Constants.PIXELS_TO_ONE_MODEL_FOOT) * Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

    public void flyLeft(int left) {
        if (left < 20 || left > 500) return;
        TelloAdap.flyLeft((left/Constants.PIXELS_TO_ONE_MODEL_FOOT) * Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

    public void flyRight(int right) {
        if (right < 20 || right > 500) return;
        TelloAdap.flyRight((right/Constants.PIXELS_TO_ONE_MODEL_FOOT) * Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

    public void gotoXYZ(int x, int y, int z, int speed) throws InterruptedException {
        if (x < -500 || x > 500 || y < -500 || y > 500 || z < -500 || z > 500
                || speed < 10 || speed > 100) return;
        TelloAdap.gotoXYZ(x/Constants.PIXELS_TO_ONE_MODEL_FOOT,y/Constants.PIXELS_TO_ONE_MODEL_FOOT,z/Constants.PIXELS_TO_ONE_MODEL_FOOT,speed* Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

    public void gotoMissionPadXYZ(int x, int y, int z, int speed, String ID) throws InterruptedException {
        if (x < -500 || x > 500 || y < -500 || y > 500 || z < -500 || z > 500
                || speed < 10 || speed > 100) return;
        TelloAdap.gotoMissionPadXYZ(x/Constants.PIXELS_TO_ONE_MODEL_FOOT,y/Constants.PIXELS_TO_ONE_MODEL_FOOT,z/Constants.PIXELS_TO_ONE_MODEL_FOOT,speed* Constants.CENTIMETERS_PER_MODEL_FOOT,ID);
    }

    public void flyCurve(int x1, int y1, int z1, int x2, int y2, int z2, int speed) {
        if (x1 < -500 || x1 > 500 || y1 < -500 || y1 > 500 || z1 < -500 || z1 > 500 ||
                x2 < -500 || x2 > 500 || y2 < -500 || y2 > 500 || z2 < -500 || z2 > 500
                || speed < 10 || speed > 60) return;
        TelloAdap.flyCurve(x1/Constants.PIXELS_TO_ONE_MODEL_FOOT,y1/Constants.PIXELS_TO_ONE_MODEL_FOOT,z1/Constants.PIXELS_TO_ONE_MODEL_FOOT,x2/Constants.PIXELS_TO_ONE_MODEL_FOOT,y2/Constants.PIXELS_TO_ONE_MODEL_FOOT,z2/Constants.PIXELS_TO_ONE_MODEL_FOOT,speed* Constants.CENTIMETERS_PER_MODEL_FOOT);
    }

    public void flyCurveMissionPad(int x1, int y1, int z1, int x2, int y2, int z2, int speed, String ID) {
        if (x1 < -500 || x1 > 500 || y1 < -500 || y1 > 500 || z1 < -500 || z1 > 500 ||
                x2 < -500 || x2 > 500 || y2 < -500 || y2 > 500 || z2 < -500 || z2 > 500
                || speed < 10 || speed > 60) return;
        TelloAdap.flyCurveMissionPad(x1/Constants.PIXELS_TO_ONE_MODEL_FOOT,y1/Constants.PIXELS_TO_ONE_MODEL_FOOT,z1/Constants.PIXELS_TO_ONE_MODEL_FOOT,x2/Constants.PIXELS_TO_ONE_MODEL_FOOT,y2/Constants.PIXELS_TO_ONE_MODEL_FOOT,z2/Constants.PIXELS_TO_ONE_MODEL_FOOT,speed* Constants.CENTIMETERS_PER_MODEL_FOOT,ID);
    }

    public void turnCW(int degrees) {
        if (degrees < 1 || degrees > 360) return;
        TelloAdap.turnCW(degrees); //rotate physical drone right
    }

    public void turnCCW(int degrees) {
        if (degrees < 1 || degrees > 360) return;
        TelloAdap.turnCCW(degrees); //rotate physical drone left
    }

    public void flip(String direction) {
        TelloAdap.flip(direction);
    }

    public void jumpMissionPad(int x, int y, int z, int speed, int yaw, String ID1, String ID2) {
        // TODO Auto-generated method stub
        //I assume this is to jump to the drone's command center
    }

    public void hoverInPlace(int seconds) throws InterruptedException {
        System.out.println("Hovering " + seconds + " seconds...");
        TelloAdap.hoverInPlace(seconds);
    }

    public void stopInPlace() {
        TelloAdap.stopInPlace();
    }

    public void setSpeed(int speed) {
        if (speed < 10 || speed > 100) return;
        TelloAdap.setSpeed((speed/Constants.PIXELS_TO_ONE_MODEL_FOOT) * Constants.CENTIMETERS_PER_MODEL_FOOT);

    }

    public double getSpeed() {
       return TelloAdap.getSpeed();
    }

    public int getBattery() {
        return TelloAdap.getBattery();
    }

    public int getFlightTime() {
        return TelloAdap.getFlightTime();
    }

    public int getHeight() {
        return TelloAdap.getHeight();
    }

    public int getTemp() {
        return TelloAdap.getTemp();
    }

    public int getAttitudePitch() {
        return TelloAdap.getAttitudePitch();
    }

    public int getAttitudeRoll() {
        return TelloAdap.getAttitudeRoll();
    }

    public int getAttitudeYaw() {
        return TelloAdap.getAttitudeYaw();
    }

    public double getBarometer() {
        return TelloAdap.getBarometer();
    }

    public double getAccelerationX() {
        return TelloAdap.getAccelerationX();
    }

    public double getAccelerationY() {
        return TelloAdap.getAccelerationY();
    }

    public double getAccelerationZ() {
        return TelloAdap.getAccelerationZ();
    }

    public int getTOF() {
        return TelloAdap.getTOF();
    }

    public String getWIFI() {
        return TelloAdap.getWIFI();
    }

    public String getVersionSDK() {
        return TelloAdap.getVersionSDK();
    }

    public String getSerialNumber() {
        return TelloAdap.getSerialNumber();
    }

    //physical  drone commands

    //PIXELS_TO_ONE_MODEL_FOOT = 25; // on screen pixels to one real world foot
    //CENTIMETERS_PER_MODEL_FOOT = 30; // centimeters to feet conversion for flight commands

    //here we go...
    public void moveTo(int X, int Y) {
        //moves the physical drone to input x,y coordinates

        //move the drone to target location
        //Controller runs on Double values, but PhysicalDrone runs on int. Convert over.
        int Xpos = drone.getXpos();
        int Ypos = drone.getYpos();
        double TravelLength;
        double TravelHeight;
        int angle;
        double hypotenuse;
        double OppOverAdj;

        System.out.println("Moving from (" + Xpos + ", " + Ypos + ") to (" + X + ", " + Y + ")...");

        checkFlight(); //make sure the drone is flying before moving

        //if the current physical drone's x position is greater than the x position at target location...
        if(Xpos>X) {
            //if the current physical drone's y position is greater than the y position at target location...
            if(Ypos>Y) {
                System.out.println("DroneX>DestX; DroneY>DestY");
                //x variable
                TravelLength = (Xpos-X);
                //y variable
                TravelHeight = (Ypos-Y);

                //calculate hypotenuse (distance the physical drone will actually fly)
                hypotenuse =  (int) Math.hypot(TravelLength,TravelHeight);
                System.out.println("Distance to checkpoint: " + hypotenuse);

                //get angle of right triangle...
                OppOverAdj = TravelHeight/TravelLength;
                angle = (int) Math.toDegrees(Math.atan((OppOverAdj)));
                System.out.println("Calculated angle = " + angle);

                //turn the drone to the direction of the destination... (drones orientation should've already been zeroed)
                //direction of quadrant 2 so turn left and subtract angle from 180.
                turnCCW(180 - angle);

                drone.setOrientation(drone.getOrientation() - (180 - angle)); //update orientation variable
                orientCheck();

                //move drone forward to destination...
                flyForward((int) Math.round((hypotenuse)));
                getDrone().setXYpos(X,Y); //update drone location

                System.out.println("Arrived at checkpoint...");

                //Done relocating drone! Now zero the drone's orientation...
                zeroOrientation();
            }

            //if the current physical drone's y position is less than the y position at target location...
            if(Ypos<Y) {
                System.out.println("DroneX>DestX; DroneY<DestY");
                //x variable
                TravelLength = Xpos-X;
                //y variable
                TravelHeight = Y-Ypos;

                //calculate hypotenuse (distance the physical drone will actually fly)
                hypotenuse = (int) Math.round(Math.hypot(TravelLength,TravelHeight));
                System.out.println("Distance to checkpoint: " + hypotenuse);

                //get angle of right triangle...
                OppOverAdj = TravelHeight/TravelLength;
                angle = (int) Math.toDegrees(Math.atan(OppOverAdj));
                System.out.println("Calculated angle = " + angle);

                //turn the drone to the direction of the destination...  (drones orientation should've already been zeroed)
                //direction of quadrant 1 so turn right and subtract angle from 180.
                turnCW(180 - angle);

                drone.setOrientation(drone.getOrientation() + (180-angle)); //update orientation variable
                orientCheck();

                //move drone forward to destination...
                flyForward((int) Math.round((hypotenuse)));
                getDrone().setXYpos(X,Y); //update drone location

                System.out.println("Arrived at checkpoint...");

                //Done relocating drone! Now zero the drone's orientation...
                zeroOrientation();
            }

            //if the current physical drone's y position is less than the y position at target location...
            if(Ypos==Y) {
                System.out.println("DroneX>DestX; DroneY=DestY");
                //x variable
                TravelLength = Xpos-X;
                System.out.println("Distance to checkpoint: " + TravelLength);

                //turn the drone to the direction of the destination...  (drones orientation should've already been zeroed)
                zeroOrientation(); //just in case...
                System.out.println("Calculated angle = " + 180);
                turnCW(180);

                drone.setOrientation(drone.getOrientation() + 180); //update orientation variable
                orientCheck();

                //move drone forward to destination...
                flyForward((int)TravelLength);
                getDrone().setXYpos(X,Y); //update drone location

                System.out.println("Arrived at checkpoint...");

                //Done relocating drone! Now zero the drone's orientation...
                zeroOrientation();
            }
        }

        //if the current physical drone's x position is less than the x position at target location...
        if(Xpos<X) {
            //if the current physical drone's y position is greater than the y position at target location...
            if(Ypos>Y) {
                System.out.println("DroneX<DestX; DroneY>DestY");
                //x variable
                TravelLength = X - Xpos;
                //y variable
                TravelHeight = Ypos - Y;

                //calculate hypotenuse (distance the physical drone will actually fly)
                hypotenuse = (int) Math.round(Math.hypot(TravelLength,TravelHeight));
                System.out.println("Distance to checkpoint: " + hypotenuse);

                //get angle of right triangle...
                OppOverAdj = TravelHeight/TravelLength;
                angle = (int) Math.toDegrees(Math.atan(OppOverAdj));
                System.out.println("Calculated angle = " + angle);

                //turn the drone to the direction of the destination... (drones orientation should've already been zeroed)
                //direction of quadrant 3 so turn left
                turnCCW(angle);
                drone.setOrientation(drone.getOrientation() - angle); //update orientation variable

                //move drone forward to destination...
                flyForward((int) Math.round((hypotenuse)));
                getDrone().setXYpos(X,Y); //update drone location

                System.out.println("Arrived at checkpoint...");

                //Done relocating drone! Now zero the drone's orientation...
                zeroOrientation();
            }

            //if the current physical drone's y position is less than the y position at target location...
            if(Ypos<Y) {
                System.out.println("DroneX<DestX; DroneY<DestY");
                //x variable
                TravelLength = X - Xpos;
                //y variable
                TravelHeight = Y - Ypos;

                //calculate hypotenuse (distance the physical drone will actually fly)
                hypotenuse = (int) Math.round(Math.hypot(TravelLength,TravelHeight));
                System.out.println("Distance to checkpoint: " + hypotenuse);

                //get angle of right triangle...
                OppOverAdj = TravelHeight/TravelLength;
                angle = (int) Math.toDegrees(Math.atan(OppOverAdj));
                System.out.println("Calculated angle = " + angle);

                //turn the drone to the direction of the destination...  (drones orientation should've already been zeroed)
                //direction of quadrant 4 so turn right
                turnCW(angle);
                drone.setOrientation(drone.getOrientation() + angle); //update orientation variable

                //move drone forward to destination...
                flyForward((int) Math.round((hypotenuse)));
                getDrone().setXYpos(X,Y); //update drone location

                System.out.println("Arrived at checkpoint...");

                //Done relocating drone! Now zero the drone's orientation...
                zeroOrientation();
            }

            //if the current physical drone's y position is equal to the y position at target location...
            if(Ypos==Y) {
                System.out.println("DroneX<DestX; DroneY=DestY");
                //x variable
                TravelLength = X - Xpos;

                //physical drone should already be facing the direction of the destination...  (drones orientation should've already been zeroed)
                System.out.println("Distance to checkpoint: " + TravelLength);

                System.out.println("Calculated angle = " + 0);

                //move drone forward to destination...
                flyForward((int)TravelLength);
                getDrone().setXYpos(X,Y); //update drone location

                System.out.println("Arrived at checkpoint...");

                //Done relocating drone! Now zero the drone's orientation...
                zeroOrientation();
            }
        }

        //if the current physical drone's x position is equal to the x position at target location...
        if(Xpos==X) {
            //if the current physical drone's y position is greater than the y position at target location...
            if(Ypos>Y) {
                System.out.println("DroneX=DestX; DroneY>DestY");
                //y variable
                TravelHeight = Ypos - Y;

                System.out.println("Distance to checkpoint: " + TravelHeight);

                System.out.println("Calculated angle = " + 90);

                //turn the drone to the direction of the destination... (drones orientation should've already been zeroed)
                //direction of quadrants 2 and 3 so turn left
                turnCCW(90);
                drone.setOrientation(drone.getOrientation() - 90); //update orientation variable

                //move drone forward to destination...
                flyForward((int)TravelHeight);
                getDrone().setXYpos(X,Y); //update drone location

                System.out.println("Arrived at checkpoint...");

                //Done relocating drone! Now zero the drone's orientation...
                zeroOrientation();
            }

            //if the current physical drone's y position is less than the y position at target location...
            if(Ypos<Y) {
                System.out.println("DroneX=DestX; DroneY<DestY");
                //y variable
                TravelHeight = Y - Ypos;

                System.out.println("Distance to checkpoint: " + TravelHeight);

                System.out.println("Calculated angle = " + 90);

                //turn the drone to the direction of the destination...  (drones orientation should've already been zeroed)
                //direction of quadrants 1 and 4 so turn right
                turnCW(90);
                drone.setOrientation(drone.getOrientation() + 90); //update orientation variable

                //move drone forward to destination...
                flyForward((int)TravelHeight);
                getDrone().setXYpos(X,Y); //update drone location

                System.out.println("Arrived at checkpoint...");

                //Done relocating drone! Now zero the drone's orientation...
                zeroOrientation();
            }

            //if the current physical drone's y position is less than the y position at target location...
            if(Ypos==Y) {
                System.out.println("DroneX=DestX; DroneY=DestY");

                System.out.println("Distance to checkpoint: " + 0);

                System.out.println("Calculated angle = " + 0);

                // DO NOTHING! You're already there!
                getDrone().setXYpos(X,Y); //update drone location

                System.out.println("Arrived at checkpoint...");

                //Done relocating drone! Now zero the drone's orientation...
                zeroOrientation();
            }
        }
    }

    public void checkFlight(){
        //checks if drone has already taken off. If yes, drone will carry out command in the air. If no, drone takes off and carries out command.
        if ((drone.getFlying()) || (getHeight()>0)) {
            System.out.println("Currently flying...");
        } else {
            takeoff();
        }
    }

    //required movements, check assignment documentation for required instructions

    //DRONE NEEDS TO START AT (0,0) (Top left of a landscape picture-type farm) facing the direction of (800,0) (Top right of a landscape picture-type farm)
    //required movement #1
    public void gotoXY(int x, int y) throws InterruptedException {
        //makes drone visit a location, rotate 360 degrees, hover for a few seconds, then return to the command center
        TelloAdap.beginProgram();
        checkFlight(); //make sure the drone is flying
        flyUpward(60);
        moveTo(x,y); //go to location
        zeroOrientation();
        turnCW(360); //rotate 360 degrees
        zeroOrientation();
        hoverInPlace(3); //hover
        return2CmdCntr(); //go back to command center
        zeroOrientation();
        land(); //yes
        TelloAdap.endProgram();
    }

    //required movement #2
    public void farmScan() throws InterruptedException {
        //makes drone zigzag the entire area of the farm then return to the command center and land
        TelloAdap.beginProgram();
        checkFlight();
        flyUpward(60);

        moveTo(0,0); //top left of farm
        moveTo(800, 0); //top right of farm
        moveTo(800,150);
        moveTo(0,150);
        moveTo(0, 300);
        moveTo(800, 300);
        moveTo(800,450);
        moveTo(0,450);
        moveTo(0,600);  //bottom left of farm
        moveTo(800,600); //bottom left of farm


        /*
        //test farm scale
        moveTo(0,0);
        moveTo(300, 0);
        moveTo(300,100);
        moveTo(0,100);
        moveTo(0, 150);
        moveTo(300, 150);
        moveTo(300,200);
        moveTo(0,200);
        moveTo(0,250);
        moveTo(300,250);
        */

        System.out.println("Scan complete!");
        return2CmdCntr();
        land();
        TelloAdap.endProgram();
    }

    public void return2CmdCntr() {
        //moves drone to command center
        System.out.println("Returning to command center...");
        zeroOrientation();
        moveTo(drone.getCmdCntrX(), drone.getCmdCntrY()); //move
        zeroOrientation();
    }

    public void zeroOrientation() {
        //turns drone back to default orientation to do actions. Should be called before AND after all operations.
        orientCheck();
        if(!(drone.getOrientation() == 0)) {
            //if orientation is positive, rotate counter clockwise
            if(drone.getOrientation()>0) {
                System.out.println("Orientation reset");
                turnCCW(drone.getOrientation());
                drone.setOrientation(0);
            } else { //if orientation is negative, rotate clockwise
                System.out.println("Orientation reset");
                turnCW(drone.getOrientation());
                drone.setOrientation(0);
            }
        }
        orientCheck(); //just in case...
    }

    public void orientCheck() {
        //used to keep track of the orientation of the drone. Call every time orientation is changed.
        if(drone.getOrientation()>=360) { //max degrees is 360, so reset to 0 and leave remainder
            drone.setOrientation(drone.getOrientation() - 360);
        }

        if(drone.getOrientation()<=-360) { //minimum degrees is -360, so reset to 0 and leave remainder
            drone.setOrientation(drone.getOrientation() + 360);
        }
    }
}
