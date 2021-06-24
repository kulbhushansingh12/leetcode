package leetcode;

//https://leetcode.com/problems/the-kth-factor-of-n/
public class KthFactor {
   // 12,3
   public int kthFactor(int n, int k) {
      if (k > ((n/2)+1)) {
         return -1;
      }
      int factor = 1;
      --k;
      for (int i = 2; i<=n/2 && k>0;i++) {
         if (n%i == 0) {
            --k;
            factor = i;
         }
      }

      return k == 1 ? n : (k > 1)? -1 : factor;
   }

   public static void main(String[] args) {
      KthFactor kthFactor = new KthFactor();
      System.out.println(kthFactor.kthFactor(12,3));
      System.out.println(kthFactor.kthFactor(7,2));
      System.out.println(kthFactor.kthFactor(4,4));
   }
}
