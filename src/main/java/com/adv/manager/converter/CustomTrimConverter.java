package com.adv.manager.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


public class CustomTrimConverter implements Converter<String, Date> {    

@Override    
public Date convert(String source) {    
	 if(source != null){//如果从浏览器传入字符串不等于�?��转换
         source = source.trim();//去除前后空格
         if(source.equals("")){ 
             source = null;
         }
         if(source!=null){//去除空格后不为空则开始转�?
             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
             try {
                 return simpleDateFormat.parse(source);
             } catch (ParseException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
                 return null;
             }
         }

     }
     return null;

 }
}