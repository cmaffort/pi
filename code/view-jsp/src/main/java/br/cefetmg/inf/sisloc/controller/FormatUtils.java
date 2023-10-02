package br.cefetmg.inf.sisloc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {
    
    public static String formatDateJdbc(String data){
        SimpleDateFormat f = new SimpleDateFormat("dd/mm/yyyy");
        Date d1 = null;
        try {
            d1 = f.parse(data);            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        
        data = format.format(d1);
        
        return data;        
       
    }
    
    
    public static String formatDateUser(String data){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        Date d1 = null;
        try {
            d1 = f.parse(data);            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        
        data = format.format(d1);
        
        return data;       
        
    }
    
}
