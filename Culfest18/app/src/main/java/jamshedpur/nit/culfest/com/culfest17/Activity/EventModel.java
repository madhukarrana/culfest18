package jamshedpur.nit.culfest.com.culfest17.Activity;

/**
 * Created by dellpc on 1/24/2018.
 */

public class EventModel {

    String Name;
    String Description;
    String Rules;
    String Cordinators;
    String Totalprize;
    String FirstPrize;
    String SecondPrize;
    String ThirdPrize;

    public EventModel(String name, String description, String rules, String cordinators, String totalprize, String firstPrize, String secondPrize, String thirdPrize) {
        Name = name;
        Description = description;
        Rules = rules;
        Cordinators = cordinators;
        Totalprize = totalprize;
        FirstPrize = firstPrize;
        SecondPrize = secondPrize;
        ThirdPrize = thirdPrize;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getRules() {
        return Rules;
    }

    public String getCordinators() {
        return Cordinators;
    }

    public String getTotalprize() {
        return Totalprize;
    }

    public String getFirstPrize() {
        return FirstPrize;
    }

    public String getSecondPrize() {
        return SecondPrize;
    }

    public String getThirdPrize() {
        return ThirdPrize;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setRules(String rules) {
        Rules = rules;
    }

    public void setCordinators(String cordinators) {
        Cordinators = cordinators;
    }

    public void setTotalprize(String totalprize) {
        Totalprize = totalprize;
    }

    public void setFirstPrize(String firstPrize) {
        FirstPrize = firstPrize;
    }

    public void setSecondPrize(String secondPrize) {
        SecondPrize = secondPrize;
    }

    public void setThirdPrize(String thirdPrize) {
        ThirdPrize = thirdPrize;
    }
}
