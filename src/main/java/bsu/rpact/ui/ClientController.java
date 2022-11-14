package bsu.rpact.ui;

import bsu.rpact.Application;
import bsu.rpact.adapter.ImageAdapter;
import bsu.rpact.entity.ImageProcessRequest;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ClientController implements Initializable {

    private File imageFile;

    @Autowired
    private ImageAdapter adapter;

    @FXML
    public ImageView preImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    public void openFile(ActionEvent actionEvent) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image files","*.png",".*jpg","*.jpeg","*.bmp"));
        fileChooser.setTitle("Select an image");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        imageFile = fileChooser.showOpenDialog(new Stage());
        preImage.setImage(new Image(new FileInputStream(imageFile.getAbsolutePath())));
    }

    @FXML
    public void saveAs(ActionEvent actionEvent) {
        //TODO preImage -> postImage
        if(preImage==null){
            return;
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image files","*.png",".*jpg","*.jpeg","*.bmp"));
        fileChooser.setTitle("Choose directory to save");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File file = fileChooser.showSaveDialog(new Stage());
        //TODO preImage->postImage
        saveToFile(preImage.getImage(),file.getAbsolutePath(),
                FilenameUtils.getExtension(file.getAbsolutePath()));
    }

    @FXML
    public void reset(ActionEvent actionEvent) {
        preImage.setImage(null);
    }

    @FXML
    public void quit(ActionEvent actionEvent) {
        System.exit(1);
    }

    private static void saveToFile(Image image, String path, String format) {
        File outputFile = new File(path);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, format, outputFile);
        } catch (IOException ex) {
            Logger.getLogger(String.valueOf(ClientController.class)).log(Level.SEVERE, null, ex);
        }
    }

    public void start(ActionEvent actionEvent) {
        byte[] arr = new byte[0];
        try {
            arr = Files.readAllBytes(imageFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int bitLayer = 2;
        String rgb = "r";
        String text = "sample text";
        ImageProcessRequest request = new ImageProcessRequest();
        request.setArr(arr);
        request.setBitLayer(bitLayer);
        request.setRgb(rgb);
        request.setText(text);
        adapter.post(request);
    }
}
