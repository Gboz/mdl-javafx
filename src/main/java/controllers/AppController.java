package controllers;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {

    private MainController mainController;

    @FXML
    private TextField input1, input2, input3, input4;

    @FXML
    private DatePicker beginDate, endDate;

    @FXML
    private Label result;

    private int pom1, pom2;
    private int hh1, hh2, mm1, mm2;
    private int dn = 0, mn = 0;

    public void compute() {
        try {
            initVars();
            // mamy petle dni w miesi�cu
            System.out.println("### BEGIN ###");
            for (int i = 1; i <= 30; i++) {
                // sprawdzamy czy dzie� miesi�ca spe�nia warunek
                if (i >= pom1 && i <= pom2) {
                    // petla godzin w dniu
                    for (int j = 1; j <= 24; j++) {
                        // liczymy czas od 8 do 16
                        if (i == pom1 && (j >= hh1 && j < 16)) {
                            dn++;
                            if (j == hh1) {
                                for (int x = 1; x <= 60; x++) {
                                    if (x > mm1) {
                                        mn++;
                                    }
                                }
                            }
                        }
                        if (i > pom1 && i < pom2 && (j >= 8 && j < 16)) {
                            dn++;
                        }
                        if (i == pom2 && (j >= 8 && j < hh2)) {
                            dn++;

                            if (j == hh2 - 1) {
                                for (int x = 1; x <= 60; x++) {
                                    if (x <= mm2) {
                                        mn++;
                                    }
                                }
                            }
                        }
                    }
                }

            }
            result.setText(dn + "h " + mn + "min");

            dn = 0;
            mn = 0;
        } catch (Exception e) {
            result.setText("enter valid date!");
            System.out.println("### ERROR ###");
        }
        System.out.println("### END ###");
    }

    @FXML
    public void backButton() {
        mainController.loadMenuScreen();
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void initVars() {
        LocalDate localDate = beginDate.getValue();
        LocalDate localDate2 = endDate.getValue();

        // 19/Jun/17 9:01 AM
        // 25/Jun/17 11:10 PM

        pom1 = localDate.getDayOfMonth();
        pom2 = localDate2.getDayOfMonth();
        hh1 = Integer.valueOf(input1.getText());
        hh2 = Integer.valueOf(input2.getText());
        mm1 = Integer.valueOf(input3.getText());
        mm2 = Integer.valueOf(input4.getText());
    }

}
