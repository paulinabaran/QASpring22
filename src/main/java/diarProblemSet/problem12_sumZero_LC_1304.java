package diarProblemSet;

public class problem12_sumZero_LC_1304 {
    public static void main(String[] args){
        reusableMethods.arrayResultPrint(sumZero(3));
    }
    public static int[] sumZero(int n)
    {
        int[] result = new int[n];
        for(int i=-(n/2),k=0; i<=n/2 ; i ++,k++)
        {
            if(n%2==0&&i==0)
                i++;
            result[k]=i;
        }
        return result;
    }
}
