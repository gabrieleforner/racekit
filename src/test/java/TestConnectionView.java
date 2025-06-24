import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.Objects;

public class TestConnectionView extends ApplicationTest {
    private TextField udpPortField;

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/racekit/StartupView.fxml")));
        stage.setScene(new Scene(root));
        stage.show();

        udpPortField = lookup("#udpPortField").query();
    }

    @Test
    public void testPortAllowOnlyNumbers() {

    }
}
