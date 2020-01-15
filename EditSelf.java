import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.*;


    public class EditSelf {


        public static void display(FarmComponent obj){
            Stage popupwindow=new Stage();

            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Editor");

            Label edit= new Label("Editing: "+obj.getName());
            Line line = new Line();
            line.setEndX(300);

            Label name = new Label("Name");
            Label price = new Label("Price");
            Label xpos = new Label("Xpos");
            Label ypos = new Label("Ypos");
            Label lenght = new Label("Lenght");
            Label width = new Label("Width");
            Label height = new Label("Height");

            TextField namei = new TextField(); namei.setText(obj.toString());
            TextField pricei = new TextField(); pricei.setText(""+obj.getPrice());
            TextField xposi = new TextField(); xposi.setText(""+obj.getXpos());
            TextField yposi = new TextField(); yposi.setText(""+obj.getYpos());
            TextField lenghti = new TextField(); lenghti.setText(""+obj.getLenght());
            TextField widthi = new TextField(); widthi.setText(""+obj.getWidth());
            TextField heighti = new TextField(); heighti.setText(""+obj.getHeight());



            Button sub= new Button("Submit Changes");
            sub.setOnAction(e -> {
                if(!(namei.textProperty().isEmpty().get() && pricei.textProperty().isEmpty().get() && xposi.textProperty().isEmpty().get() && yposi.textProperty().isEmpty().get()&&
                        lenghti.textProperty().isEmpty().get() && widthi.textProperty().isEmpty().get() && heighti.textProperty().isEmpty().get())){

                        obj.SetName(namei.getText()); obj.SetPrice(Float.parseFloat(pricei.getText()));
                        obj.setXpos(Integer.parseInt(xposi.getText()));  obj.setYpos(Integer.parseInt(yposi.getText()));
                        obj.setLenght(Float.parseFloat(lenghti.getText()));obj.setWidth(Float.parseFloat(widthi.getText()));
                        obj.setHeight(Integer.parseInt(heighti.getText()));

                popupwindow.close();}});

            VBox layout= new VBox(10);
            layout.getChildren().addAll(edit,line,name,namei,price,pricei,xpos,xposi,ypos,yposi,lenght,lenghti,width,widthi,height,heighti,sub);
            layout.setAlignment(Pos.BASELINE_LEFT);
            Scene scene1= new Scene(layout, 300, 600);
            popupwindow.setScene(scene1);
            popupwindow.showAndWait();}


        public static void EditName (FarmComponent obj){
            Stage popupwindow=new Stage();

            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Editor");

            Label edit= new Label("Editing: "+obj.getName());
            Line line = new Line();
            line.setEndX(300);

            Label name = new Label("Name");
            TextField namei = new TextField(); namei.setText(obj.toString());

            Button sub= new Button("Submit Changes");
            sub.setOnAction(e -> {
                if(!(namei.textProperty().isEmpty().get())){
                    obj.SetName(namei.getText());
                    popupwindow.close();}});


            VBox layout= new VBox(10);
            layout.getChildren().addAll(edit,line,name,namei,sub);
            layout.setAlignment(Pos.BASELINE_CENTER);
            Scene scene1= new Scene(layout, 300, 150);
            popupwindow.setScene(scene1);
            popupwindow.showAndWait();}


        public static void EditPrice (FarmComponent obj){
            Stage popupwindow=new Stage();

            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Editor");

            Label edit= new Label("Editing: "+obj.getName());
            Line line = new Line();
            line.setEndX(300);

            Label price = new Label("Price");
            TextField pricei = new TextField(); pricei.setText(String.valueOf(obj.getPrice()));

            Button sub= new Button("Submit Changes");
            sub.setOnAction(e -> {
                if(!(pricei.textProperty().isEmpty().get())){
                    obj.SetPrice(Float.valueOf(pricei.getText()));
                    popupwindow.close();}});


            VBox layout= new VBox(10);
            layout.getChildren().addAll(edit,line,price,pricei,sub);
            layout.setAlignment(Pos.BASELINE_CENTER);
            Scene scene1= new Scene(layout, 300, 150);
            popupwindow.setScene(scene1);
            popupwindow.showAndWait();}

        public static void EditMPrice (FarmComponent obj){
            Stage popupwindow=new Stage();

            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Editor");

            Label edit= new Label("Editing: "+obj.getName());
            Line line = new Line();
            line.setEndX(300);

            Label price = new Label("Price");
            TextField pricei = new TextField(); pricei.setText(String.valueOf(obj.getMprice()));

            Button sub= new Button("Submit Changes");
            sub.setOnAction(e -> {
                if(!(pricei.textProperty().isEmpty().get())){
                    obj.setMprice(Float.valueOf(pricei.getText()));
                    popupwindow.close();}});


            VBox layout= new VBox(10);
            layout.getChildren().addAll(edit,line,price,pricei,sub);
            layout.setAlignment(Pos.BASELINE_CENTER);
            Scene scene1= new Scene(layout, 300, 150);
            popupwindow.setScene(scene1);
            popupwindow.showAndWait();}}