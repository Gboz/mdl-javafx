package controllers;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
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

	private int pom1, pom2, pom3;
	private int hh1, hh2, mm1, mm2;
	private int dn = 0, dnPom = 0;

	public void compute() {

		LocalDate localDate = beginDate.getValue();
		LocalDate localDate2 = endDate.getValue();

		// 19/Jun/17 9:01 AM
		// 25/Jun/17 11:10 PM

		Period period = Period.between(localDate, localDate2);

		pom1 = localDate.getDayOfMonth();
		pom2 = localDate2.getDayOfMonth();
		pom3 = pom2 - pom1;
		hh1 = Integer.valueOf(input1.getText());
		hh2 = Integer.valueOf(input2.getText());
		mm1 = Integer.valueOf(input3.getText());
		mm2 = Integer.valueOf(input4.getText());

		// mamy petle dni w miesi¹cu
		System.out.println("### BEGIN ###");
		for (int i = 1; i <= 30; i++) {
			// sprawdzamy czy dzieñ miesiêca spe³nia warunek
			if (i >= pom1 && i <= pom2) {
				System.out.println("<" + i + ">");
				System.out.println("POM1: " + pom1);
				System.out.println("POM2: " + pom2);
				System.out.println("POM3: " + pom3);
				System.out.println("HH1: " + hh1);
				System.out.println("HH2: " + hh2);
				System.out.println("MM1: " + mm1);
				System.out.println("MM2: " + mm2);
				// petla godzin w dniu
				for (int j = 1; j <= 24; j++) {
					// liczymy czas od 8 do 16
					if (i == pom1 && (j >= hh1 && j < 16)) {
						dnPom++;
					}
					
					if (i > pom1 && i < pom2 &&(j >= 8 && j < 16)) {
						dn++;
					}
					
					if (i == pom2 && (j >= 8 && j < hh2)) {
						dnPom++;
					}
					
					System.out.println(j + " | " + dn);
					System.out.println(j + " || " + dnPom);
				}
			}

		}
		System.out.println("<<< " + dn + " >>>");
		System.out.println("<<< " + dnPom + " >>>");
		System.out.println("### END ###");

		result.setText("dni: " + period.getDays() + "\nmiesi¹ce: " + period.getMonths() + "\nlata" + period.getYears()
				+ "\ndni 1: " + pom1 + "\ndni2 2: " + pom2 + "\nró¿nica 3: " + pom3 + "\ngodziny czasu 1" + hh1
				+ "\ngodziny czasu 2" + hh2 + "\nminuty czasu 1" + mm1 + "\nminuty czasu 2" + mm2
				+ "\ngodziny spêdzone nad zadaniem: " + dn
		);

		dn = 0;
		dnPom = 0;
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
