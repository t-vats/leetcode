package daily.september9;

public class CountCommas2 {
    public static void main(String[] args) {
        long input = 1002;
        long commaCount = countCommas(input);
        System.out.println("Number of commas: " + commaCount);
    }

    public static long countCommas(long n) {
        if(n<1000)
            return 0;
        
        long counter = 0;
        
        if(n<1_000_000L){
            return n - 999;
        }
        counter = counter + n - 999;


        if(n<1_000_000_000)
            {
                return counter + (n - 999_999);
            } 
        counter = counter + (n - 999_999);

        if(n<1_000_000_000_000L){
            return counter + (n - 999_999_999L) ;
        }
        
        counter = counter + (n - 999_999_999L);
       
        if(n<1_000_000_000_000_000L){
            return counter + (n - 999_999_999_999L) ;
        }
       
        counter = counter + (n - 999_999_999_999L);

        return counter + 1;
    }
}
