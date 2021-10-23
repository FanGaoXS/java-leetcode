package cn.fangaoxs.day9.subject23;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/27/21:40
 * @Description:
 */
public class Solution {

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;    //num1字符串末尾
        int j = num2.length()-1;    //num2字符串末尾
        boolean add = false;        //默认add数为false（不用进1）
        while (!(i<0&&j<0&&!add)){  //如果i<0并且j<0并且add不需要进1的时候退出循环
            /**
             * 需要注意i、j越界问题，可能i已经遍历完了，但是j还没遍历完，如果此时
             * 继续遍历i则会发生数组越界，所以此时直接将num[i]视为0
             */
            int number1 = 0;
            int number2 = 0;
            if (i>=0){      //如果i>0说明字符串中还有数据
                number1 = num1.charAt(i)-48;    //ASCII码减去48为数值
            }
            if (j>=0){
                number2 = num2.charAt(j)-48;
            }
            int number = number1+number2;   //和
            if (add) {  //如果需要进1则和+1
                number += 1;
                add = false;
            }
            if (number>=10){    //如果和>=10则 下一次循环需要进1
                add = true;
                number = number%10; //并且number实际上去10的模
            }
            sb.append(number);
            i--;
            j--;
        }
        return sb.reverse().toString();//最后字符串反转
    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        String addStrings = addStrings(num1, num2);
        System.out.println("addStrings = " + addStrings);
    }
}
