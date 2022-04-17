module EVM {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	requires opencsv;
	
	opens application to javafx.graphics, javafx.fxml;
}
