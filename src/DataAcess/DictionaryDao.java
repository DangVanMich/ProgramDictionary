package DataAcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Dictionary;
import view.Validation;


public class DictionaryDao {
    
    private static DictionaryDao instance= null;
    private Validation validation;
    private ArrayList<Dictionary> list_dic;
    public DictionaryDao(){
        validation= new Validation();
        list_dic= new ArrayList<>();
    }
    
    public static DictionaryDao Instance(){
        if(instance==null){
            synchronized(DictionaryDao.class){
                if(instance==null){
                    instance= new DictionaryDao();
                }
            }
        }
        return instance;
    }
    
    public void addWord(HashMap<String, String> hm, String filename){ 
        System.out.println("------------ Add Word ------------");
        while(true){
            if(!validation.checkFileExist(filename)){
                return;
            }
            loadData(hm, filename);
            String english= validation.checkInputString("Enter English: ");
            if(hm.containsKey(english)){
                System.out.println("You want to update the mean of keyword?(Y/N)");
                if(validation.checkInputYesNo()){
                 //   System.out.println("Please enter the mean of keyword: ");
                    String mean= validation.checkInputString("Please enter the mean of keyword: ");
                    hm.put(english, mean);                 
                    updateData(filename,hm);
                }
            }else{
                //System.out.print("Enter Vietnamese: ");
                String vietnamese= validation.checkInputString("Enter Vietnamese: ");
                hm.put(english, vietnamese);           
                updateData(filename,hm);                
            } 
            System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen");
            if(!validation.checkInputYesNo()){
                return;
            }
        }
    }
    
    public void loadData(HashMap<String, String> hm, String filename){
        File file= new File(filename);
        try {
            FileReader fr= new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            String line;
            if((line= br.readLine())!=null){
                String[] dic= line.split(":");
                hm.put(dic[0], dic[1].trim());                
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.err.println("Error load data from file!");
        }
    }
    
    public void updateData(String filename, HashMap<String, String> hm){
        File file= new File(filename);
        try {
            FileWriter fw= new FileWriter(file, false);
            for (Map.Entry<String, String> entry : hm.entrySet()) {
                String key = entry.getKey();
                String val = entry.getValue();
                Dictionary dic= new Dictionary(key, val);
                fw.write(dic+"\n");                
            }            
            fw.close();                        
        } catch (Exception e) {
            System.err.println("Error write to file!");
        }
    }
    
    public void deleteWord(HashMap<String, String> hm, String filename){
        System.out.println("----------- Delete Word -------------");
        
        String english= validation.checkInputString("Enter English: ");
        if(hm.containsKey(english)){
            hm.remove(english);
            updateData(filename, hm);
            System.out.println("Successful!");
        }else{
            System.out.println("Word no exist!");
        }
    }
    
    public void translateWord(HashMap<String, String> hm){
        System.out.println("----------Translate Word ----------");
        
        String english= validation.checkInputString("Enter English: ");
        if(hm.containsKey(english)){
            System.out.println("Vietnamese: "+hm.get(english));                        
        }else{
            System.out.println("Word no exist!");
        }
    }
}