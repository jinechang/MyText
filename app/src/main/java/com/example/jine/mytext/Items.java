package com.example.jine.mytext;

import java.util.Date;

/**
 * Created by jine on 16-03-16.
 * create a class that represents the data from Firebase that you want to show in the ListView
 * as they are stored into the database
 */
public class Items {
    String Category;
    String Subcategory;
    String Itemname;
    String PostBy;
    int PostPrice;
    int YearsOfUse;
    String Status;
    Date PostDate;

    public Items(){super();};
    public Items(String name){
        this.Itemname = name;
    };
    public Items(String name, String seller, int price, int years, String status, Date date){
        this.Itemname = name;
        this.PostBy = seller;
        this.PostPrice = price;
        this.YearsOfUse = years;
        this.Status = status;
        this.PostDate = date;
    }

    public String getItemname(){
        return this.Itemname;
    }
    public String getCategory(){return this.Category;}
    public String getSubcategory(){return this.Subcategory;}
    public String getPostBy(){
        return this.PostBy;
    }
    public int getYearsOfUse(){
        return this.YearsOfUse;
    }
    public Date getPostDate(){
        return this.PostDate;
    }
    public int getPostPrice(){
        return this.PostPrice;
    }
    public String getStatus() {
        return this.Status;
    }

    public void setCategory(String ca){this.Category = ca;}
    public void setSubcategory(String sc){this.Subcategory = sc;}
    public void setItemname(String name){this.Itemname = name;}
    public void setPostBy(String seller){this.PostBy = seller;}
    public void setPostDate(Date date){this.PostDate = date;}
    public void setPostPrice(int price){this.PostPrice = price;}
    public void setYearsOfUse(int years){this.YearsOfUse = years;}
    public void setStatus(String sta){this.Status = sta;}

}
