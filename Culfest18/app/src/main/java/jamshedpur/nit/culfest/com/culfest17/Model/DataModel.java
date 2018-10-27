package jamshedpur.nit.culfest.com.culfest17.Model;

/**
 * Created by aditya314 on 12/30/2017.
 */

public class DataModel {

    String question;
    String answer;

    public DataModel(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

}