
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Singleton instance;

    @Override
    public void start(Stage primaryStage) throws Exception{
        if (instance == null){
            instance = Singleton.getInstance();
            Parent root = FXMLLoader.load(getClass().getResource("DroneGUI.fxml"));
            primaryStage.setTitle("DroneGUI");
            primaryStage.setScene(new Scene(root, 1049, 800));
            primaryStage.show();}
        else{}}


    public static void main(String[] args) {
        launch(args);}} 
