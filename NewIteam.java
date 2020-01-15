import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewIteam {

    static FarmComponent temp;

    public static FarmComponent display(){
        Stage popupwindow=new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Editor");

        Label edit= new Label("New Object");
        Line line = new Line();
        line.setEndX(300);

        Label name = new Label("Name");
        Label price = new Label("Price");
        Label mprice = new Label("Market Value");
        Label xpos = new Label("Xpos");
        Label ypos = new Label("Ypos");
        Label lenght = new Label("Lenght");
        Label width = new Label("Width");
        Label height = new Label("Height");

        TextField namei = new TextField();
        TextField pricei = new TextField();
        TextField marketi = new TextField();
        TextField xposi = new TextField();
        TextField yposi = new TextField();
        TextField lenghti = new TextField();
        TextField widthi = new TextField();
        TextField heighti = new TextField();

        ChoiceBox cb = new ChoiceBox();
        cb.setItems(FXCollections.observableArrayList("Item Container","Item"));
        cb.getSelectionModel().selectFirst();
        Label addeding = new Label("What Item Are You Adding");



        Button sub= new Button("Submit Changes");
        sub.setOnAction(e -> {
            if(cb.getSelectionModel().getSelectedItem().equals("Item Container") && !(namei.textProperty().isEmpty().get() && pricei.textProperty().isEmpty().get()&& marketi.textProperty().isEmpty().get() && xposi.textProperty().isEmpty().get() && yposi.textProperty().isEmpty().get()&&
                    lenghti.textProperty().isEmpty().get() && widthi.textProperty().isEmpty().get() && heighti.textProperty().isEmpty().get())){

                    temp = new ItemContainer(namei.getText(),Float.parseFloat(pricei.getText()),Integer.parseInt(xposi.getText()),Integer.parseInt(yposi.getText()),Float.parseFloat(lenghti.getText()),
                            Float.parseFloat(widthi.getText()),Float.parseFloat(heighti.getText()));

                    temp.setMprice(Float.parseFloat(marketi.getText()));}

            if(cb.getSelectionModel().getSelectedItem().equals("Item") && !(namei.textProperty().isEmpty().get() && pricei.textProperty().isEmpty().get() && marketi.textProperty().isEmpty().get() && xposi.textProperty().isEmpty().get() && yposi.textProperty().isEmpty().get()&&
                    lenghti.textProperty().isEmpty().get() && widthi.textProperty().isEmpty().get() && heighti.textProperty().isEmpty().get())){

                temp = new Item(namei.getText(),Float.parseFloat(pricei.getText()),Integer.parseInt(xposi.getText()),Integer.parseInt(yposi.getText()),Float.parseFloat(lenghti.getText()),
                        Float.parseFloat(widthi.getText()),Float.parseFloat(heighti.getText()));

                temp.setMprice(Float.parseFloat(marketi.getText()));}


        popupwindow.close();});

        VBox layout= new VBox(10);
        layout.getChildren().addAll(edit,line,addeding,cb,name,namei,price,pricei,mprice,marketi,xpos,xposi,ypos,yposi,lenght,lenghti,width,widthi,height,heighti,sub);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 650);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
        return temp;

    }}
