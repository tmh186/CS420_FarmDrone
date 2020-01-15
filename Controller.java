import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Controller {

    @FXML
    private Pane Map;
    @FXML
    private AnchorPane Tview;
    @FXML
    private TextField X;
    @FXML
    private TextField Y;
    @FXML
    private Text Error;
    @FXML
    private TreeView <FarmComponent> tree;
    @FXML
    private Label valuePrice;
    @FXML
    private Label marketPrice;



    Drone drone = new Drone("Drone",(float)12.0,0,0,(float)12.5,(float)12.5,15);
    Drone drone2 = new Drone("Drone",(float)12.0,0,0,(float)12.5,(float)12.5,15);

    Adapter AdaptedDrone = new Adapter(drone2); //the drone is now adapted to give physical commands
    ///////this runs at first set up//////
    @FXML
    public void initialize() {
       Map.getChildren().add(drone.getShape());
       Error.setVisible(false);

        Rectangle temp = new Rectangle();
        temp.setFill(Color.RED);
        temp.setWidth(50);
        temp.setHeight(50);
        temp.relocate(0,0);
        Map.getChildren().add(temp);

        Map.getChildren().set(0,drone.getShape()).toFront();
       makeTree();
       Tview.getChildren().add(tree);

        tree.setOnMouseClicked(e->{
            ValueVisitor vis = new ValueVisitor();
            MarketVisitor vis2 = new MarketVisitor();


            tree.getSelectionModel().getSelectedItem().getValue().accept(vis);
            tree.getSelectionModel().getSelectedItem().getValue().accept(vis2);

            valuePrice.setText("$ "+vis.value());
            marketPrice.setText("$ " +vis2.value());
        });}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void makeTree(){
        TreeItem<FarmComponent> root;
        root = new TreeItem<FarmComponent>();
        root.setExpanded(true);
        tree = new TreeView<FarmComponent>(root);
        tree.setShowRoot(true);
        root.setValue(new Farm());

        //makeBranch(drone,root);
        addContext();}

    private void addContext() {

        ContextMenu menu = new ContextMenu();

        MenuItem menu1B = new MenuItem("Edit All");
        MenuItem menu2B = new MenuItem("Add New Item");
        MenuItem menu3B = new MenuItem("Delete This");
        MenuItem menu4B = new MenuItem("Fly To Sim");
        MenuItem menu5B = new MenuItem("Edit Price");
        MenuItem menu6B = new MenuItem("Rename");
        MenuItem menu7B = new MenuItem("Change Market Value");
        MenuItem menu8B = new MenuItem("Fly To Real");

        menu1B.setOnAction(e -> {
            EditSelf.display(tree.getSelectionModel().getSelectedItem().getValue());});
/////////
        menu2B.setOnAction(e->{
             FarmComponent temp= NewIteam.display();
             makeBranch(temp,tree.getSelectionModel().getSelectedItem());});
/////////
        menu3B.setOnAction(e->{
            tree.getSelectionModel().getSelectedItem().getValue().getShape().setVisible(false);
            TreeItem c = tree.getSelectionModel().getSelectedItem();

            if (c.getParent().getValue() instanceof Farm){
                    Farm temp = (Farm) c.getParent().getValue();
                    temp.removeComponet((FarmComponent) c.getValue());}

            if (c.getParent().getValue() instanceof ItemContainer){
                    ItemContainer temp = (ItemContainer) c.getParent().getValue();
                    temp.removeComponet((FarmComponent) c.getValue());
                    if(c.getValue() instanceof ItemContainer){
                        ItemContainer temp2 = (ItemContainer)c.getValue();
                        temp2.removeAll();}}

            if(c.getValue() instanceof Item){
                ItemContainer temp = (ItemContainer) c.getParent().getValue();
                temp.removeComponet(tree.getSelectionModel().getSelectedItem().getValue());}

            c.getParent().getChildren().remove(c);});
/////////
        menu4B.setOnAction(e->{
            transiton1(tree.getSelectionModel().getSelectedItem().getValue().getXpos(),tree.getSelectionModel().getSelectedItem().getValue().getYpos());});
/////////
        menu5B.setOnAction(e->{
            EditSelf.EditPrice(tree.getSelectionModel().getSelectedItem().getValue());});
////////
        menu6B.setOnAction(e->{
            EditSelf.EditName(tree.getSelectionModel().getSelectedItem().getValue());
            tree.refresh();});

        menu7B.setOnAction(e->{
            EditSelf.EditMPrice(tree.getSelectionModel().getSelectedItem().getValue());});

        menu8B.setOnAction(e->{
            try {AdaptedDrone.gotoXY(tree.getSelectionModel().getSelectedItem().getValue().getXpos(),tree.getSelectionModel().getSelectedItem().getValue().getYpos());
            }catch (InterruptedException e1) {e1.printStackTrace();}
        });


        menu.getItems().addAll(menu1B,menu2B,menu6B,menu4B,menu8B,menu5B,menu7B,menu3B);
        tree.setContextMenu(menu);}

/////////////////////////////////////////////////////////////////////////////////
    public void makeBranch(FarmComponent obj,TreeItem parent){

        if (parent.getValue() instanceof ItemContainer || parent.getValue() instanceof Farm){

            if(parent.getValue() instanceof Farm){
                ((Farm) parent.getValue()).addComponent(obj);}

            if(parent.getValue() instanceof ItemContainer){
                ((ItemContainer) parent.getValue()).addComponent(obj);}

            TreeItem<FarmComponent> item = new TreeItem();
            item.setValue(obj);
            parent.getChildren().add(item);
            Map.getChildren().add(obj.getShape());
        }

        if(!(parent.getValue() instanceof ItemContainer || parent.getValue() instanceof Farm)){
            parent = parent.getParent();
            makeBranch(obj,parent);}}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // this is button1
    public void Button1() throws InterruptedException {
        AdaptedDrone.farmScan();}

    //this is button2
    public void Button2() throws InterruptedException {
        int temp3 = Integer.parseInt(X.getText());
        int temp4 = Integer.parseInt(Y.getText());
            AdaptedDrone.gotoXY(temp3,temp4);
    }



    public void FullScan() {
        if(drone.getXpos() !=0.0 && drone.getYpos() != 0.0){
            path2(0,0);}
        else othertransiton();}


    public void ButtonPath(){
        Error.setVisible(false);
        int temp3 = Integer.parseInt(X.getText());
        int temp4 = Integer.parseInt(Y.getText());

        temp3 = Math.abs(temp3);
        temp4 = Math.abs(temp4);

        int x = (temp3-drone.getXpos());
        int y = (temp4-drone.getYpos());

        if(x + drone.getXpos() > 800 || y + drone.getYpos() >600){
            error();
        }else{
            //path(temp3, temp4);
            transiton1(temp3, temp4);}}


    public void error(){
        Error.setVisible(true);}

    public void path(int temp3, int temp4) {

        int temp1 = drone.getXpos();
        int temp2 = drone.getYpos();

        if (temp3> 750){temp3=750;}
        if (temp4> 550){temp4=550;}

        drone.getShape().setVisible(false);

        System.out.println(temp1 + " " + temp2 + " " + temp3 + " " + temp4 + " ");

        Circle transition = new Circle();
        transition.setFill(Color.AQUAMARINE);
        transition.setRadius(25);
        transition.relocate(temp1, temp2);

        Map.getChildren().add(transition);


        TranslateTransition move = new TranslateTransition();

        move.setDuration(Duration.seconds(8));
        move.setToX(0.0);
        move.setToY(0.0);
        move.setNode(transition);
        transition.relocate(temp3, temp4);
        move.play();
        drone.setXYpos(temp3, temp4);

        move.setOnFinished(e -> {
            drone.getShape().setVisible(true);
            transition.setVisible(false);
            Map.getChildren().remove(transition);});
    }


    public void path2(int temp3, int temp4) {

        int temp1 = drone.getXpos();
        int temp2 = drone.getYpos();
        drone.getShape().setVisible(false);

        Circle transition = new Circle();
        transition.setFill(Color.AQUAMARINE);
        transition.setRadius(25);
        transition.relocate(temp1, temp2);

        Map.getChildren().add(transition);
        TranslateTransition move = new TranslateTransition();

        move.setDuration(Duration.seconds(8));
        move.setToX(temp3 - temp1);
        move.setToY(temp4 - temp2);
        move.setNode(transition);
        move.play();
        drone.setXYpos(temp3, temp4);

        move.setOnFinished(e -> {
            transition.setVisible(false);
            Map.getChildren().remove(transition);
            othertransiton();});}

    private void othertransiton() {
        Circle transition = new Circle();
        transition.setFill(Color.AQUAMARINE);
        transition.setRadius(25);
        transition.relocate(drone.getXpos(),drone.getYpos());
        Map.getChildren().add(transition);

        drone.getShape().setVisible(false);

        Path route = new Path();
        route.getElements().add(new MoveTo(0.0-drone.getXpos(),0.0-drone.getYpos()));
        route.getElements().add(new LineTo(0.0,0.0));
        route.getElements().add(new LineTo(750.0,0.0));
        route.getElements().add(new LineTo(750.0,150.0));
        route.getElements().add(new LineTo(0.0,150.0));
        route.getElements().add(new LineTo(0.0,300.0));
        route.getElements().add(new LineTo(750.0,300.0));
        route.getElements().add(new LineTo(750.0,450.0));
        route.getElements().add(new LineTo(0.0,450.0));
        route.getElements().add(new LineTo(0.0,550.0));
        route.getElements().add(new LineTo(750.0,550.0));
        route.getElements().add(new LineTo(0.0,0.0));

        drone.setXYpos(0,0);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(route);
        pathTransition.setDuration(Duration.seconds(50));
        pathTransition.setNode(transition);
        pathTransition.play();


        pathTransition.setOnFinished(e -> {
            drone.getShape().setVisible(true);
            transition.setVisible(false);
            Map.getChildren().remove(transition);});}

    private void transiton1(int temp3, int temp4) {
        Circle transition = new Circle();
        transition.setFill(Color.AQUAMARINE);
        transition.setRadius(25);
        transition.relocate(drone.getXpos(),drone.getYpos());
        Map.getChildren().add(transition);

        drone.getShape().setVisible(false);

        Path route = new Path();
        route.getElements().add(new MoveTo(0.0-drone.getXpos(),0.0-drone.getYpos()));
        route.getElements().add(new LineTo(0.0,0.0));
        route.getElements().add(new LineTo(temp3,temp4));
        route.getElements().add(new LineTo(drone.getCmdCntrX(),drone.getCmdCntrY()));


        drone.setXYpos(0,0);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(route);
        pathTransition.setDuration(Duration.seconds(12));
        pathTransition.setNode(transition);
        pathTransition.play();


        pathTransition.setOnFinished(e -> {
            drone.getShape().setVisible(true);
            transition.setVisible(false);
            Map.getChildren().remove(transition);});}
}


