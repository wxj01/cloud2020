/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/18 0018 18:15
 */
public class testHwData {
    public static void main(String[] args) {

        System.out.println("121 是不是回文数："+isPalindrome(121));
    }


    public static Boolean  isPalindrome(int x){

        // 负数 不满足
        if(x < 0 ){
            return  false;
        }

        // 将整型 转 String
        String s = String.valueOf(Integer.valueOf(x));
        char[] chars = s.toCharArray();

        // 第一种思路 反转 和  s 值 比较是否相同
        StringBuffer sb = new StringBuffer();
        for (int i = chars.length-1 ; i >=0; i-- ){
            sb.append(chars[i]);
        }

        if(s.equals(sb.toString())){
            return true;
        }

        return false;
    }

}
