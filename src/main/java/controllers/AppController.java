package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {

    private MainController mainController;

    @FXML
    private TextField input1, input2, input3, input4, parserPicker1, parserPicker2;

    @FXML
    private DatePicker beginDate, endDate;

    @FXML
    private Label result, resultFromParser;

    private int beginDay, endDay;
    private int beginHour, endHour, beginMinute, endMinute;
    private int resultHours = 0, resultMinutes = 0;

    private int pBeginDay, pEndDay;
    private int pBeginHour, pEndHour, pBeginMinute, pEndMinute;
    private int pResultHours = 0, pResultMinutes = 0;


    public void parse() {
        try {
            System.out.println("### BEGIN ###");
            initVarsToParse();
            for (int i = 1; i <= 30; i++) {
                if (i >= pBeginDay && i <= pEndDay && (i != 3 && i != 4 && i != 10 && i != 11 && i != 17 && i != 18 && i != 24 && i != 25)) {
                    for (int j = 1; j <= 24; j++) {
                        if (i == pBeginDay && (j >= 8 && j < 16 && j >= pBeginHour)) {
                            if (j != pBeginHour && j > pBeginHour) {
                                pResultHours++;
                            } else {
                                for (int x = 1; x <= 60; x++) {
                                    if (x > pBeginMinute) {
                                        pResultMinutes++;
                                    }
                                }
                            }
                        }
                        if (i > pBeginDay && i < pEndDay && (j >= 8 && j < 16)) {
                            pResultHours++;
                        }
                        if (i == pEndDay && (j >= 8 && j <= pEndHour && j < 16)) {
                            if (j != pEndHour) {
                                pResultHours++;
                            } else {
                                for (int x = 1; x <= 60; x++) {
                                    if (x <= pEndMinute) {
                                        pResultMinutes++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            pResultHours = pResultHours + (pResultMinutes / 60);
            pResultMinutes = pResultMinutes % 60;

            resultFromParser.setText(pResultHours + "h " + pResultMinutes + "min");

            pResultHours = 0;
            pResultMinutes = 0;
        } catch (Exception e) {
            resultFromParser.setText("enter valid date!");
            System.out.println("### ERROR ###");
        }
        System.out.println("### END ###");
    }

    public void initVarsToParse() {
        String pattern1 = parserPicker1.getText();
        String[] parts = pattern1.split(" ");
        List<String> list = new ArrayList<String>();
        System.out.println("DEBUG " + list);
        for (String var : parts) {
            list.add(var);
        }
        String[] parts2 = list.get(0).split("/");
        System.out.println("DEBUG " + list);
        list.remove(0);
        System.out.println("DEBUG " + list);
        for (int i = 0; i < parts2.length; i++) {
            list.add(parts2[i]);
        }
        String[] parts3 = list.get(0).split(":");
        System.out.println("DEBUG " + list);
        list.remove(0);
        for (int i = 0; i < parts3.length; i++) {
            list.add(parts3[i]);
        }
        System.out.println(list);
        pBeginDay = Integer.valueOf(list.get(0));
        pBeginHour = Integer.valueOf(list.get(3));
        pBeginMinute = Integer.valueOf(list.get(4));
        System.out.println(pBeginDay + " " + pBeginHour + " " + pBeginMinute);

        //second
        String pattern2 = parserPicker2.getText();
        String[] parts4 = pattern2.split(" ");
        List<String> list2 = new ArrayList<String>();
        System.out.println("DEBUG " + list2);
        for (String var : parts4) {
            list2.add(var);
        }
        System.out.println("DEBUG " + list2);
        String[] parts5 = list2.get(0).split("/");
        list2.remove(0);
        System.out.println("DEBUG " + list2);
        for (int i = 0; i < parts5.length; i++) {
            list2.add(parts5[i]);
        }
        System.out.println("DEBUG " + list2);
        String[] parts6 = list2.get(0).split(":");
        list2.remove(0);
        for (int i = 0; i < parts6.length; i++) {
            list2.add(parts6[i]);
        }
        System.out.println(list2);
        pEndDay = Integer.valueOf(list2.get(0));
        pEndHour = Integer.valueOf(list2.get(3));
        pEndMinute = Integer.valueOf(list2.get(4));
        System.out.println(pEndDay + " " + pEndHour + " " + pEndMinute);

        list.removeAll(list);
        list2.removeAll(list2);
    }

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

}
