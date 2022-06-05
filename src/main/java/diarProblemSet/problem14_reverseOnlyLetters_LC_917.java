package diarProblemSet;

public class problem14_reverseOnlyLetters_LC_917 {

    public static void main(String[] args){
        String test1 = "a-bC-dEf-ghIj";
        System.out.println("Result of reverseOnlyLetters with the input of \"" + test1 + "\" is " + reverseOnlyLetters(test1));


    }
    public static String reverseOnlyLetters(String str){
        //for(int i=str.length();i>=0;i++)
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(j))){
                str = str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i) + str.substring(j + 1);
                i++;
                j--;
            }
            else{
                if(!Character.isLetter(str.charAt(i))){
                    i++;
                }
                if(!Character.isLetter(str.charAt(j))){
                    j--;
                }
            }
        }
        return str;
    }

}
