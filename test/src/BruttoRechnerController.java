import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class BruttoRechnerController implements Initializable {
    @FXML
    private TextField tfNetto;
    @FXML
    private ComboBox<String> cbUmsatzsteuer;
    @FXML
    private TextField tfBrutto;
    private String[] items = { "19 %", "16 %", "7 %" };
    private int[] values = { 19, 16, 7 };
    @FXML
    void handleButtonAction(ActionEvent event) {
        compute();
    }
    @FXML
    void handleNettoMousePressed(MouseEvent event) {
        tfBrutto.setText("");
    }
    @FXML
    void handleUmsatzsteuerMousePressed(MouseEvent event) {
        tfBrutto.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        cbUmsatzsteuer.getItems().addAll(items);
        cbUmsatzsteuer.getSelectionModel().select(0);
    }
    private void compute() {
        String input = tfNetto.getText().toString().trim();
        input = input.replace(",", "");
        double netto;
        try {
            netto = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            tfNetto.setText("");
            tfNetto.requestFocus();
            return;
        }
        int idx = cbUmsatzsteuer.getSelectionModel().getSelectedIndex();
        int value = values[idx];
        double brutto = netto * (1 + value / 100.);
        tfBrutto.setText(String.format("%.2f", brutto));
    }
}