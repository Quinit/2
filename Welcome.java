/*
 * A test code for beginner
 * @author Quinit
 * @version 1.0
 */

import static java.lang.Math.*;

//顶层定义
enum Size {X,Z,M};

public class Welcome {
    public enum Size {X,Z,M};
    public static void main(String[] args){
        String greeting = "Welcome to Core Java!";
        System.out.println(greeting);
        for(int i =0;i<greeting.length();i++){
            System.out.println("=");
        }
        System.out.println("");
        CLASS a = new CLASS("Test");
        System.out.println(a.getRecore());
        CLASS.main(args);
  

    }

    public static void test(){
        //整数
        int NumA = 2147483647; //注释
        System.out.println(NumA);
        long NumB = 9223372036854775807L;
        System.out.println(NumB);
        short NumC = 32767;
        System.out.println(NumC);
        byte NumD = (byte) 0b1000_0011;
        System.out.println(NumD);


        //浮点数
        float NumE = 0x4.5p108f;
        System.out.println(NumE);
        double NumF = 3.8e198d;
        System.out.println(NumF);
        //isNaN?
        Double.isNaN(NumF);

        //字符
        char NumG = 0;
        System.out.println(NumG);

        //布尔值
        boolean NumH = false;
        System.out.println(NumH);
    }

    public static void math(){
        enum Sze {X,Z,M};//局部枚举 java16+
        var NumA = 1;
        System.out.println(NumA + 1);
        final var A_SPECIAL_VAL = 4;
        sqrt(NumA);
        int code = 0;
        String seasonString = switch(code){
            case 0 -> "spring";
            default -> "?";
        };

    }

    //常量类
    public static final int A_FINAL_INT = 2;
    public enum Sie {X,Z,M};//类中
    //
    
    public static void str(){
        String str = "1561656";
        if(str.equals(str));
        if(str.equalsIgnoreCase(str));
        if(str.length() == 0 );
        if(str.equals(""));
        if(str != null && str.length() != 0 );
    }
    CLASS a = new CLASS("Test");

}

