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
    private DatePicker beginDate, endDate, parPicker;

    @FXML
    private Label result;

    private int beginDay, endDay;
    private int beginHour, endHour, beginMinute, endMinute;
    private int resultHours = 0, resultMinutes = 0;

    public void compute() {

        try {
            initVars();
            System.out.println("### BEGIN ###");
            // mamy petle dni w miesiącu
            for (int i = 1; i <= 30; i++) {
                // sprawdzamy czy dzień miesiąca spełnia warunek
                // true, gdy natrafimy na wybrany okres czasu
                if (i >= beginDay && i <= endDay && (i != 3 && i != 4 && i != 10 && i != 11 && i != 17 && i != 18 && i != 24 && i != 25)) {
                    // petla godzin w dniu
                    for (int j = 1; j <= 24; j++) {
                        // liczymy czas od 8 do 16 dla pierwszego dnia zakresu
                        if (i == beginDay && (j >= 8 && j < 16 && j >= beginHour)) {
                            // jeżeli nie trafimy na godzinę rozpoczęcia zakresu spełniamy warunek
                            if (j != beginHour && j > beginHour) {
                                resultHours++;
                            } else {
                                // else gdy mamy do czynienia z godziną rozpoczęcia zakresu korzystamy z pętli minut
                                for (int x = 1; x <= 60; x++) {
                                    // jeżeli
                                    if (x > beginMinute) {
                                        resultMinutes++;
                                    }
                                }
                            }
                        }
                        // liczymy godziny pomiędzy pierwszym a ostatnim dniem zakresu
                        if (i > beginDay && i < endDay && (j >= 8 && j < 16)) {
                            resultHours++;
                        }
                        // liczymy czas od 8 do 16 dla drugiego dnia zakresu
                        if (i == endDay && (j >= 8 && j <= endHour && j < 16)) {

                            if (j != endHour) {
                                resultHours++;
                            } else {
                                for (int x = 1; x <= 60; x++) {
                                    if (x <= endMinute) {
                                        resultMinutes++;
                                    }
                                }
                            }
                        }
                    }
                }

            }

            resultHours = resultHours + (resultMinutes / 60);
            resultMinutes = resultMinutes % 60;

            result.setText(resultHours + "h " + resultMinutes + "min");

            resultHours = 0;
            resultMinutes = 0;
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

        beginDay = localDate.getDayOfMonth();
        endDay = localDate2.getDayOfMonth();
        beginHour = Integer.valueOf(input1.getText());
        endHour = Integer.valueOf(input2.getText());
        beginMinute = Integer.valueOf(input3.getText());
        endMinute = Integer.valueOf(input4.getText());
    }

}
