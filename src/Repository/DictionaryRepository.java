/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAcess.DictionaryDao;
import java.util.ArrayList;
import java.util.HashMap;
import model.Dictionary;

/**
 *
 * @author admin
 */
public class DictionaryRepository implements IDictionaryRepository{
    HashMap<String, String> hm;

    public DictionaryRepository() {
        this.hm = new HashMap<>();
    }
   
   @Override
   public void addNewWord(String filename){
       DictionaryDao.Instance().addWord(hm, filename);
   }
   
   @Override
    public void deleteWord(String filename){
       DictionaryDao.Instance().deleteWord(hm, filename);
   }

    
   @Override
    public void translate(){
       DictionaryDao.Instance().translateWord(hm);
   } 
    
}
