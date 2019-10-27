package com.xxM.demo03;

import java.util.Objects;

interface Pet{
    /**
     * 动物名字
     * @return
     */
    String getName();
    /**
     * 动物颜色
     * @return
     */
    String getColor();

    /**
     * 动物年龄
     * @return
     */
    int getAge();
}

class PetShop{
        private Link pets=new Link();
        public void add(Pet pet){
            this.pets.add(pet);
        }
        public void remove(Pet pet){
            this.pets.remove(pet);
        }
        public Link getPets(){
            return this.pets;
        }
        public Link search(String key){
            Link all=new Link();
            Object []result=pets.toArray();
            for (int i = 0; i < result.length; i++) {
                Pet pet=(Pet) result[i];
                if (pet.getName().contains(key)||pet.getColor().contains(key)){
                    all.add(pet);
                }
            }
            return all;
    }
}

class Dog implements Pet{
    private String name;
    private String color;
    private int age;

    public Dog() {
    }

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public String getColor(){
        return this.color;
    }
    @Override
    public int getAge(){
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age &&
                Objects.equals(name, dog.name) &&
                Objects.equals(color, dog.color);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}

class Cat implements Pet{
    private String name;
    private String color;
    private int age;

    public Cat() {
    }

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * @Author Mr Liu
 */
public class PetShoped {
    public static void main(String[] args) {
        PetShop petShop=new PetShop();
        petShop.add(new Dog("哈巴狗","褐色",2));
        petShop.add(new Dog("金毛","金色",1));
        petShop.add(new Dog("秋田犬","黄色",1));
        petShop.add(new Cat("波斯猫","白色",3));
        petShop.add(new Cat("加菲猫","黄色",1));
        petShop.add(new Cat("花卷","黑白色",2));
        Link result1=petShop.getPets();
        Object [] petSet=result1.toArray();
        for (int i = 0; i < petSet.length; i++) {
            System.out.println(petSet[i]);
        }
        System.out.println("=======================================");
        Link result2=petShop.search("黄");
        Object [] searchSet=result2.toArray();
        for (int i = 0; i < searchSet.length; i++) {
            System.out.println(searchSet[i]);
        }
    }
}
