package com.common;

public class Matches {
    /*匹配数字*/
   public  static  String numPrice="^\\d+(\\.\\d+)?";
   public  static  String num="^[0-9]*[1-9][0-9]*$";
/*"^\\d+$"　　//非负整数（正整数   +   0）
  "^[0-9]*[1-9][0-9]*$"　　//正整数
  "^((-\\d+)|(0+))$"　　//非正整数（负整数   +   0）
  "^-[0-9]*[1-9][0-9]*$"　　//负整数
  "^-?\\d+$"　　　　//整数
  "^\\d+(\\.\\d+)?$"　　//非负浮点数（正浮点数   +   0）
  "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$"　　//正浮点数
  "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$"　　//非正浮点数（负浮点数   +   0）
  "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$"　　//负浮点数
  "^(-?\\d+)(\\.\\d+)?$"　　//浮点数*/
    public static void main(String[] args) {
        if("5510.5".matches(num))
            System.out.println("nice");
    }
}
