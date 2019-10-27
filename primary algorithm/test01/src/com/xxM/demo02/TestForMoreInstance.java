package com.xxM.demo02;
class Sex{
    public static final int Man_cmd=1;
    public static final int Woman_cmd=2;
    private static Sex man=new Sex("男");
    private static Sex woman=new Sex("女");
    private String title;
    private Sex(String title){
        this.title=title;
    }
    public static Sex getInstance(int cmd){
        switch (cmd){
            case Man_cmd:
                return man;
            case Woman_cmd:
                return woman;
        }
        return null;
    }
    @Override
    public String toString(){
        return this.title;
    }
}

/**
 * @Author Mr Liu
 */
public class TestForMoreInstance {
    public static void main(String[] args) {
        Sex sex=Sex.getInstance(Sex.Man_cmd);
        System.out.println(sex.toString());
    }
}
