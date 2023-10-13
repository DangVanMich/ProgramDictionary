/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Repository.DictionaryRepository;
import Repository.IDictionaryRepository;
import view.Menu;

/**
 *
 * @author admin
 */
public class ProgramingDictionary extends Menu<String>{
    private IDictionaryRepository dicRepository = new DictionaryRepository();
    static String title = "Dictionary Program";
    static String[] s = new String[]{"Add New Word ", "Delete Word","Translate", "Exit"};

    public ProgramingDictionary() {
        super(title, s);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                dicRepository.addNewWord("text");
                break;
            case 2:
                dicRepository.deleteWord("text");
                break;
            case 3:
                dicRepository.translate();
                break;  
            case 4:
                System.exit(0);
            default:
                System.out.println("Your choice invalid! Pls input another choice");
        }

    }
}
