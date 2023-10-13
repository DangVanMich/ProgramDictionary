/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Dictionary {
    private String English;
    private String Vietname;

    public Dictionary() {
    }

    public Dictionary(String English, String Vietname) {
        this.English = English;
        this.Vietname = Vietname;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String English) {
        this.English = English;
    }

    public String getVietname() {
        return Vietname;
    }

    public void setVietname(String Vietname) {
        this.Vietname = Vietname;
    }

    @Override
    public String toString() {
        return  English + ": " + Vietname ;
    }
       
}
