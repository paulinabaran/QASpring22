package diarProblemSet;

public class problem13_reverseString_LC_344 {
    public static void main(String[] args)
    {
        char[] str= new char[]{'h','e','l','l','o'};
        reusableMethods.arrayResultPrint(reverseString(str));
    }

    public static char[] reverseString(char[] str){
        char[] reverse=new char[str.length];
        for(int i=str.length-1,k=0; i >=0;i--,k++){
            reverse[k]=str[i];
        }
        return reverse;
    }

}
