import java.util.Scanner;  // Import the Scanner class

class Java2 {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the number of lines:");
      int n = sc.nextInt();
      for (int i = 0;i<=n;i++){
          for (char ch='a'; ch <'a'+i;ch++){
              System.out.print(ch);
          }
          System.out.println();
          sc.close();
      }
  }
}
