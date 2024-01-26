package quiz;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
     int index=0;
     int score=0;
    private String s = new String();
@FXML
public TextField name;
public Button start;
public Button rule;
public Label question;
public Button next;
public Button submit,A,B,C,D;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start.setOnAction(event -> {
            if(index==0)
            setQuestion();
        });
        A.setOnAction(event -> {
            if(index==0)
        {question.setText("YOUR ANSWER IS CORRECT");
            score+=10;}
            else question.setText("YOUR ANSWER IS WRONG");
        });
        B.setOnAction(event -> {
            if(index==2)
            {question.setText("YOUR ANSWER IS CORRECT");
                score+=10;}
            else question.setText("YOUR ANSWER IS WRONG");
        });
        C.setOnAction(event -> {
            if(index==1)
            {question.setText("YOUR ANSWER IS CORRECT");
                score+=10;}
            else question.setText("YOUR ANSWER IS WRONG");
        });
        D.setOnAction(event -> {
            question.setText("YOUR ANSWER IS WRONG");
        });
        next.setOnAction(event -> {
            if(index!=2)
            {index++;
            setQuestion();}
            else
            question.setText(name.getText()+", YOUR SCORE = "+score);
        });
        submit.setOnAction(event -> {
                index=0;
                score=0;
                question.setText("RESTARTED SUCCESSFULLY\nClick on START BUTTON");
        });
        rule.setOnAction(event -> {
          Rules();
        });
    }
    private void Rules() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("How to play");
        alert.setHeaderText("HOW TO PLAY");
        alert.setContentText("..Choose the correct answer among the given options within time limit\n..As your answers are correct next answer appear\n");
        alert.show();
    }
    private void setQuestion(){
        if(index!=3)
        question.setText(setstring());
    }
private String setstring(){
    if(index==0)
    s = "The International Literacy Day is observed on \nA.Sep 8\nB.Nov 28\nC.May 2\nD.Sep 22\n";
    else if(index==1)
    s = "The language of Lakshadweep a Union Territory of\n India, is\nA.Tamil\nB.Hindi\nC.Malayalam\nD.Telugu\n";
    else if(index==2)
        s= "In which group of places the Kumbha Mela is  \nheld every twelve years?\nA.Ujjain. Purl; Prayag. Haridwar\nB.Prayag. Haridwar, Ujjain,. Nasik\nC.Rameshwaram. Purl, Badrinath. Dwarika\nD.Chittakoot, Ujjain, Prayag,Haridwar";
        return s;
}
}
