		
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;


public class EnergyManagementSystem extends Application {
    private Admin admin;
    private List<Customer> customers;
    private TextField usernameField;
    private PasswordField passwordField;
    private Stage primaryStage;
    private String filename = "data.txt";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        admin = new Admin();
        customers = new ArrayList<>();
        loadDataFromFile(); // Load data from file
        showLoginForm();
    }

    private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String password = parts[1];
                    double conlimit = Double.parseDouble(parts[2]);
                    addUser(username, password, conlimit);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Customer customer : customers) {
                writer.write(customer.getUsername() + "," + customer.getPassword() + "," + customer.getConlimit());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLoginForm() {
    	
    	 Label heading = new Label();
         Text text = new Text("Welcome To Energy Management System");
         text.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 30));
         text.setFill(Color.WHITE);
         text.setUnderline(true);
         StackPane stackPane = new StackPane(text);
         stackPane.setPadding(new Insets(0, 0, 0, 20)); // Add left padding of 20 pixels
         heading.setGraphic(stackPane);
         
         

        
        // Add left padding of 20 pixels
        

//        Label heading = new Label("ENERGY MANAGEMENT SYSTEM");
//        heading.setFont(Font.font("Arial", 15));
//        heading.setTextFill(Color.ALICEBLUE);
//        heading.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 25));
//        heading.setTextFill(Color.WHITE);
//        heading.setUnderline(true);
//        heading.setGraphic(heading);

        
      
        
      
       
       
        

        Label usernameLabel = new Label("Username:");
        usernameLabel.setFont(Font.font("Georgia", 15));
        usernameLabel.setTextFill(Color.WHITE);
        HBox hb2 = new HBox(10);
        
        hb2.setStyle("-fx-alignment: center;");
        usernameField = new TextField();
        hb2.getChildren().addAll(usernameLabel,usernameField);
        Label passwordLabel = new Label("Password:");
        HBox hb3 = new HBox(10);
       
        hb3.setStyle("-fx-alignment: center;");
        passwordLabel.setFont(Font.font("Georgia", 15));
        passwordLabel.setTextFill(Color.WHITE);
        passwordField = new PasswordField();
        hb3.getChildren().addAll(passwordLabel,passwordField);
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(80);
        loginButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");

        loginButton.setOnAction(e -> handleLogin());
        loginButton.setOnMouseEntered(event -> {
            // Set hover style
        	loginButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");});
        
        loginButton.setOnMouseExited(event -> {
            // Set normal style
        	loginButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });
        Button signUpButton = new Button("Sign Up");
        signUpButton.setPrefWidth(80);
        signUpButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");

        signUpButton.setOnAction(e -> showSignUpForm());
       
        signUpButton.setOnMouseEntered(event -> {
            // Set hover style
        	signUpButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");});
        signUpButton.setOnMouseEntered(event -> {
            // Set hover style
        	signUpButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");});

//        StackPane.add(heading, 0, 0);
//        gridPane.add(signUpButton, 1, 4);
//        gridPane.add(usernameLabel, 0, 1);
//        gridPane.add(usernameField, 1, 1);
//        gridPane.add(passwordLabel, 0, 2);
//        gridPane.add(passwordField, 1, 2);
//        gridPane.add(loginButton, 1, 3);
        HBox hb4 = new HBox(10);
        hb4.getChildren().addAll(loginButton,signUpButton);
        
        hb4.setStyle("-fx-alignment: center;");
        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(heading,hb2);
        hbox.setStyle("-fx-alignment: center;");
        VBox vbox = new VBox(20);
        
        Pane pane = new HBox(50);
        
        
//        try {
//            Image image = new Image(getClass().getResourceAsStream("6.png"));
//            BackgroundImage backgroundImage = new BackgroundImage(image,
//                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
//            Background background = new Background(backgroundImage);
//            pane.setBackground(background);
//        } catch (Exception e) {
//            // Handle exception if the image file is not found
//            e.printStackTrace();
//        }
        
        Image image = new Image("7.png");
        BackgroundImage im=new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bGround=new Background(im);
        pane.setBackground(bGround);
        pane.getChildren().addAll(vbox);
//        stackPane.getChildren().add(pane);
        vbox.getChildren().addAll(hbox,hb2,hb3,hb4);
        vbox.setStyle("-fx-alignment: center;");
        
        
        Scene scene = new Scene(pane, 700, 400);
//        gridPane.setStyle("-fx-background-color: #898C8B;");// Set background color
        primaryStage.setTitle("Login and Sign up");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equalsIgnoreCase(admin.getUsername()) && password.equalsIgnoreCase(admin.getPassword())) {
            showAdminDashboard();
        } 
        else {
            int userIndex = customerLogin(username, password);
            if (userIndex != -1) {
                showUserDashboard(userIndex);
            }
            else {
                showAlert("Invalid login credentials!");
            }
        }
    }

    private void showSignUpForm() {
        Stage signUpStage = new Stage();
        signUpStage.setTitle("Sign Up");
        
        
        
      
        Label heading = new Label();

        
        Text text  = new Text("SIGN UP");
        text.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 35));
        text.setFill(Color.WHITE);
        text.setUnderline(true);
        heading.setGraphic(text);
        StackPane stackPane = new StackPane(text);
        heading.setPadding(new Insets(0, 10, 0, 275)); // Add left padding of 20 pixels
        heading.setGraphic(stackPane);
        
        Label nusernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        nusernameLabel.setFont(Font.font("Georgia", 15));
        nusernameLabel.setTextFill(Color.WHITE);
        HBox hb2 = new HBox(10);
        hb2.getChildren().addAll(nusernameLabel,usernameField);
        hb2.setStyle("-fx-alignment: center;");


        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordLabel.setFont(Font.font("Georgia", 15));
        passwordLabel.setTextFill(Color.WHITE);
        
        
        HBox hb3 = new HBox(10);
        hb3.getChildren().addAll(passwordLabel,passwordField);
        hb3.setStyle("-fx-alignment: center;");

        
        Label ConLimitLabel = new Label("Units To Be Used");
        TextField Conlimit = new TextField();
        
        ConLimitLabel.setFont(Font.font("Georgia", 15));
        ConLimitLabel.setTextFill(Color.WHITE);
        HBox hb4 = new HBox(10);
        hb4.getChildren().addAll(ConLimitLabel,Conlimit);
        hb4.setStyle("-fx-alignment: center;");


        Button signUpButton = new Button("Sign Up");
        
        signUpButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String Conlimits = Conlimit.getText();
            double conlimit = Double.parseDouble(Conlimits);
            addUser(username, password, conlimit);
            signUpStage.close();
        });
        
        signUpButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        signUpButton.setPrefWidth(80);
        signUpButton.setOnMouseEntered(event -> {
            // Set hover style
        	signUpButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        signUpButton.setOnMouseExited(event -> {
            // Set normal style
        	signUpButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });
//        gridPane.add(heading,0,0);
//        gridPane.add(usernameLabel, 0, 1);
//        gridPane.add(usernameField, 1, 1);
//        gridPane.add(passwordLabel, 0, 2);
//        gridPane.add(passwordField, 1, 2);
//        gridPane.add(ConLimitLabel, 0, 3);
//        gridPane.add(Conlimit, 1, 3);
//        gridPane.add(signUpButton, 1, 4);
        
        HBox hb5 = new HBox(10);
        hb5.getChildren().addAll(signUpButton);
        hb5.setStyle("-fx-alignment: center;");

        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(heading,hb2,hb3,hb4);
        hbox.setStyle("-fx-alignment: center;");
        VBox vbox = new VBox(20);

        Pane pane = new HBox(50);
        Image image = new Image("3.png");
        BackgroundImage im=new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bGround=new Background(im);
        pane.setBackground(bGround);
        pane.getChildren().addAll(vbox);

        vbox.getChildren().addAll(hbox,hb2,hb3,hb4,hb5);
        vbox.setStyle("-fx-alignment: center;");
        Scene scene = new Scene(pane, 700, 400);

        signUpStage.setScene(scene);
        signUpStage.show();
    }

    private int customerLogin(String username, String password) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (username.equalsIgnoreCase(customer.getUsername()) && password.equalsIgnoreCase(customer.getPassword())) {
                return i;
            }
        }
        return -1;
    }

    private void showAdminDashboard() {
    	 Label heading = new Label();
         Text text = new Text("Admin Dashboard");
         text.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 35));
         text.setFill(Color.WHITE);
         text.setUnderline(true);
         heading.setGraphic(text);
         StackPane stackPane = new StackPane(text);
         stackPane.setPadding(new Insets(0, 0, 0, 35)); // Add left padding of 20 pixels
         heading.setGraphic(stackPane);
      
        
        Button viewUsersButton = new Button("View Number of Users");
        viewUsersButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        viewUsersButton.setPrefWidth(100);
        viewUsersButton.setOnMouseEntered(event -> {
            // Set hover style
        	viewUsersButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        viewUsersButton.setOnMouseExited(event -> {
            // Set normal style
        	viewUsersButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });
        viewUsersButton.setOnAction(e -> showAlert("Total number of users: " + customers.size()));

        Button signOutButton = new Button("Sign Out");
        signOutButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        signOutButton.setPrefWidth(100);
        signOutButton.setOnMouseEntered(event -> {
            // Set hover style
        	signOutButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        signOutButton.setOnMouseExited(event -> {
            // Set normal style
        	signOutButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });
        
        
        signOutButton.setOnAction(e -> showLoginForm());

//        vbox.getChildren().addAll(viewUsersButton, signOutButton);
//        v1.getChildren().addAll(heading);
//        borderPane.setTop(v1);
//        borderPane.setCenter(vbox);

        HBox hb2 = new HBox(10);
        hb2.getChildren().addAll(signOutButton,viewUsersButton);
        hb2.setStyle("-fx-alignment: center;");



        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(heading);
        hbox.setStyle("-fx-alignment: center;");
        VBox vbox = new VBox(20);

        Pane pane = new HBox(50);
        Image image = new Image("12.png");
        BackgroundImage im=new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bGround=new Background(im);
        pane.setBackground(bGround);
        pane.getChildren().addAll(vbox);

        vbox.getChildren().addAll(hbox,hb2);
        vbox.setStyle("-fx-alignment: center;");
        Scene scene = new Scene(pane, 700, 400);
        primaryStage.setTitle("Admin Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showUserDashboard(int userIndex) {
        Label heading = new Label();

//    	HBox hbox = new HBox(10);
//        HBox h1 = new HBox(15);
        Text text = new Text("Welcome to User Dashboard");
        StackPane stackPane = new StackPane(text);

        stackPane.setPadding(new Insets(0,0,0,75));
        stackPane.setAlignment(Pos.CENTER);
      
        text.setUnderline(true);
        heading.setGraphic(text);
        text.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 38));
        text.setFill(Color.WHITE);
        heading.setGraphic(stackPane);
        
        Button addApplianceButton = new Button("Add Appliance");
        addApplianceButton.setOnAction(e -> showAddApplianceDialog(userIndex));
        addApplianceButton.setPrefWidth(105);
        addApplianceButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");

        addApplianceButton.setOnMouseEntered(event -> {
            // Set hover style
        	addApplianceButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        addApplianceButton.setOnMouseExited(event -> {
            // Set normal style
        	addApplianceButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });

        Button consumptionReportButton = new Button("Consumption Report");
        consumptionReportButton.setOnAction(e -> showConsumptionReport(userIndex));
        consumptionReportButton.setPrefWidth(110);
        consumptionReportButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");

        consumptionReportButton.setOnMouseEntered(event -> {
            // Set hover style
        	consumptionReportButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        consumptionReportButton.setOnMouseExited(event -> {
            // Set normal style
        	consumptionReportButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });

        Button logOutButton = new Button("Log Out");
        logOutButton.setOnAction(e -> showLoginForm());
        logOutButton.setPrefWidth(105);
        logOutButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");

        logOutButton.setOnMouseEntered(event -> {
            // Set hover style
        	logOutButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        logOutButton.setOnMouseExited(event -> {
            // Set normal style
        	logOutButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });
        
        
        HBox hb2 = new HBox(20);
        hb2.getChildren().addAll(addApplianceButton,consumptionReportButton,logOutButton);
        hb2.setStyle("-fx-alignment: center;");
//        vbox.getChildren().addAll(addApplianceButton, consumptionReportButton, logOutButton);
//        v1.getChildren().addAll(heading);
//        borderPane.setTop(v1);
//        borderPane.setCenter(vbox);
        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(heading,hb2);
        hbox.setStyle("-fx-alignment: center;");
        VBox vbox = new VBox(20);

        Pane pane = new HBox(50);
        Image image = new Image("6.png");
        BackgroundImage im=new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bGround=new Background(im);
        pane.setBackground(bGround);
        pane.getChildren().addAll(vbox);

        vbox.getChildren().addAll(hbox,hb2);
        vbox.setStyle("-fx-alignment: center;");

        
        

        Scene scene = new Scene(pane, 700, 400);
        primaryStage.setTitle("User Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAddApplianceDialog(int userIndex) {

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add Appliance");
    	Label heading = new Label();
        Text text = new Text("ADD APPLIANCE");
        text.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 35));
        text.setFill(Color.WHITE);
        text.setUnderline(true);
        heading.setGraphic(text);
        StackPane stackPane = new StackPane(text);
        stackPane.setPadding(new Insets(0, 10, 0, 85)); // Add left padding of 20 pixels
        heading.setGraphic(stackPane);

        Label nameLabel = new Label("Appliance Name:");
        TextField nameField = new TextField();
        nameLabel.setStyle("-fx-text-fill: white;");
        HBox hb2 = new HBox(10);
        hb2.getChildren().addAll(nameLabel,nameField);
        hb2.setStyle("-fx-alignment: center;");

        Label usageLabel = new Label("Usage per Minute:");
        TextField usageField = new TextField();
        usageLabel.setStyle("-fx-text-fill: white;");
        HBox hb3 = new HBox(10);
        hb3.getChildren().addAll(usageLabel,usageField);
        hb3.setStyle("-fx-alignment: center;");
        Label numbermin = new Label("Usage Minutes:");
        TextField minField = new TextField();
        numbermin.setStyle("-fx-text-fill: white;");
        HBox hb4 = new HBox(10);
        hb4.getChildren().addAll(numbermin,minField);
        hb4.setStyle("-fx-alignment: center;");

        Button addButton = new Button("Add");
        addButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        addButton.setPrefWidth(80);
        addButton.setOnMouseEntered(event -> {
            // Set hover style
        	addButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        addButton.setOnMouseExited(event -> {
            // Set normal style
        	addButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });
        
        
        Button backButton = new Button("Back");
        
        backButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        backButton.setPrefWidth(80);
        backButton.setOnMouseEntered(event -> {
            // Set hover style
        	backButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        backButton.setOnMouseExited(event -> {
            // Set normal style
        	backButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });
        backButton.setOnAction(e -> showUserDashboard(userIndex));
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            double usagePerMin = Double.parseDouble(usageField.getText());
            double Min = Double.parseDouble(minField.getText());
            customers.get(userIndex).addAppliance(name, usagePerMin, Min);
            dialogStage.close();
        });
        
        HBox hb5 = new HBox(10);
        hb5.getChildren().addAll(addButton,backButton);
        hb5.setStyle("-fx-alignment: center;");
        
        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(heading,hb2);
        hbox.setStyle("-fx-alignment: center;");
        VBox vbox = new VBox(20);

        Pane pane = new HBox(50);
        Image image = new Image("8.png");
        BackgroundImage im=new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bGround=new Background(im);
        pane.setBackground(bGround);
        pane.getChildren().addAll(vbox);

        vbox.getChildren().addAll(hbox,hb2,hb3,hb4,hb5);
        vbox.setStyle("-fx-alignment: center;");
        Scene scene = new Scene(pane, 700, 400);

//        gridPane.add(nameLabel, 0, 0);
//        gridPane.add(nameField, 1, 0);
//        gridPane.add(usageLabel, 0, 1);
//        gridPane.add(usageField, 1, 1);
//        gridPane.add(numbermin, 0, 2);
//        gridPane.add(minField, 1, 2);
//        gridPane.add(addButton, 1, 3);
//        gridPane.add(backButton, 2, 3);
//
//        borderPane.setCenter(gridPane);
//
//        Scene scene = new Scene(borderPane, 700, 400);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    private void showConsumptionReport(int userIndex) {
        Customer user = customers.get(userIndex);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        Label appliancesLabel = new Label("Appliances used by you:");
        ListView<String> appliancesListView = new ListView<>();
        appliancesListView.getItems().addAll(user.getAppNames());

        double rem = user.getConlimit() - user.getConsumption();
        double con = user.getConlimit() - rem;

        PieChart pc = new PieChart();
        PieChart.Data s1 = new PieChart.Data("Remaining Units", rem);
        PieChart.Data s2 = new PieChart.Data("Used Units", con);
        pc.getData().add(s1);
        pc.getData().add(s2);

        Label alertLabel = new Label(user.isAlert() ? "You are pushing your consumption limits" : "You are good to go");
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        backButton.setPrefWidth(80);
        backButton.setOnMouseEntered(event -> {
            // Set hover style
        	backButton.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        backButton.setOnMouseExited(event -> {
            // Set normal style
        	backButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });
        backButton.setOnAction(e -> showUserDashboard(userIndex));

        vbox.getChildren().addAll(appliancesLabel, appliancesListView, pc, alertLabel, backButton);

        Scene scene = new Scene(vbox, 700, 400);
        scene.setFill(Color.BLACK);
        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Consumption Report");
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Users");
        alert.setHeaderText("PLATFORM USERS ");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void addUser(String username, String password, double conlimit) {
        Customer customer = new Customer(username, password, conlimit);
        customers.add(customer);
        saveDataToFile(); // Save data to file
    }

    public void start1(Stage primaryStage) {
        this.primaryStage = primaryStage;
        admin = new Admin();
        customers = new ArrayList<>();
        loadDataFromFile(); // Load data from file
        showLoginForm();
    }
}
