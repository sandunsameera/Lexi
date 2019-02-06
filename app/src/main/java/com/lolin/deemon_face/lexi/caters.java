package com.lolin.deemon_face.lexi;

public class caters {
    public String Name,Age,Experience;
    public caters(){

    }


    public caters(String Name,String Age,String Experience){
        this.Name = Name;
        this.Age = Age;
        this.Experience = Experience;
    }


    public String getName (){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }

    public String getAge(){return Age;}
    public void setAge (String Age){this.Age = Age;}

    public String getExperience(){return  Experience;}
    public void setExperience(String experience){this.Experience = experience;}
}








