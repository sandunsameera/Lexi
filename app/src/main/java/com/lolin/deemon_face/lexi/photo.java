package com.lolin.deemon_face.lexi;

import com.google.common.base.Strings;

public class photo {

    private String name,Exp,Tp;

    public photo(){

    }

    public photo(String name,String Exp,String Tp){
        this.name = name;
        this.Exp = Exp;
        this.Tp= Tp;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){

        this.name = name;

    }

    public  String getExp(){
        return  Exp;

    }

    public void setExp(String Exp){
        this.Exp;
    }

    public String getTp(){
        return  Tp;
    }

    public  void setTp(){
        this.Tp;
    }
}
