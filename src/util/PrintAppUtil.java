package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PrintAppUtil {

    public static final String ICON_IMAGE_LOC = "/img/icon.png";
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static void setStageIcon(Stage stage) {
        stage.getIcons().add(new Image(ICON_IMAGE_LOC));
    }

//    public static Object loadWindow(URL loc, String title, Stage parentStage) {
//        Object controller = null;
//        try {
//            FXMLLoader loader = new FXMLLoader(loc);
//            Parent parent = loader.load();
//            controller = loader.getController();
//            Stage stage = null;
//            if (parentStage != null) {
//                stage = parentStage;
//            } else {
//                stage = new Stage(StageStyle.DECORATED);
//            }
//            stage.setTitle(title);
//            stage.setScene(new Scene(parent));
//            stage.show();
//            setStageIcon(stage);
//        } catch (IOException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return controller;
//    }
//
//    public static Float getFineAmount(int totalDays) {
//        Preferences pref = Preferences.getPreferences();
//        Integer fineDays = totalDays - pref.getnDaysWithoutFine();
//        Float fine = 0f;
//        if (fineDays > 0) {
//            fine = fineDays * pref.getFinePerDay();
//        }
//        return fine;
//    }
//
//    public static void initPDFExprot(StackPane rootPane, Node contentPane, Stage stage, List<List> data) {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Save as PDF");
//        FileChooser.ExtensionFilter extFilter
//                = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
//        fileChooser.getExtensionFilters().add(extFilter);
//        File saveLoc = fileChooser.showSaveDialog(stage);
//        ListToPDF ltp = new ListToPDF();
//        boolean flag = ltp.doPrintToPdf(data, saveLoc, ListToPDF.Orientation.LANDSCAPE);
//        JFXButton okayBtn = new JFXButton("Okay");
//        JFXButton openBtn = new JFXButton("View File");
//        openBtn.setOnAction((ActionEvent event1) -> {
//            try {
//                Desktop.getDesktop().open(saveLoc);
//            } catch (Exception exp) {
//                AlertMaker.showErrorMessage("Could not load file", "Cant load file");
//            }
//        });
//        if (flag) {
//            AlertMaker.showMaterialDialog(rootPane, contentPane, Arrays.asList(okayBtn, openBtn), "Completed", "Member data has been exported.");
//        }
//    }

    public static String formatDateTimeString(Date date) {
        return DATE_TIME_FORMAT.format(date);
    }

    public static String getDateString(Date date) {
        return DATE_FORMAT.format(date);
    }
}