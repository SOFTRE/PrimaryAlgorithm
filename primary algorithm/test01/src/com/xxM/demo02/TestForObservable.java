package com.xxM.demo02;

import java.util.Observable;
import java.util.Observer;

class House extends Observable{
    private double price;
    public House(double price){
        this.price=price;
    }
    public void setPrice(double price){
        if (price>this.price){
            super.setChanged();
            super.notifyObservers(price);
        }
        this.price=price;
    }
}

class Person implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Observable){
            if (arg instanceof Double){
                System.out.println("房子涨价了，新价格为:"+arg);
            }
        }
    }
}

/**
 * @Author Mr Liu
 */
public class TestForObservable {
    public static void main(String[] args) {
        Person personA=new Person();
        Person personB=new Person();
        Person personC=new Person();
        House house=new House(9000);
        house.addObserver(personA);
        house.addObserver(personB);
        house.addObserver(personC);
        house.setPrice(10000);
    }
}
