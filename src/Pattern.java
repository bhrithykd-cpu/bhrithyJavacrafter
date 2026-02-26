public class Pattern {
    public static void main(String[] args) {
        //
        /*pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);*/
        pattern5(5);
    }

    static void pattern1(int n){
        System.out.println("Pattern 1");
        for (int i = 1; i <= n; i++) {//no. of row
            //for every row run the col
            for (int j = 1; j <= n; j++) {//no. of col = row size
                System.out.print("* ");
            }
            //when one row is printed,we need to print a new line
            System.out.println();
        }
    }
    static void pattern2(int n){
        System.out.println("Pattern 2");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n){
        System.out.println("Pattern 3");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n) {
        System.out.println("Pattern 4");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }

    static void pattern5(int n) {
        System.out.println("Pattern 5");
        for (int i = 1; i <= 2*n; i++) {
            int totalRow = i>5?2*n-i:i;
            for (int j = 1; j <= totalRow; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    static void pattern6(int n) {
        System.out.println("Pattern 6");
        for (int i = 1; i <= 2*n; i++) {

            int totalRow = i>5?2*n-i:i;
            int noOfSpaces = n - totalRow;
            for(int s=1;s<noOfSpaces;s++){
                System.out.println(" ");
            }
            for (int j = 1; j <= totalRow; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


}
