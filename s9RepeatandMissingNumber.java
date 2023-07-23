import java.util.*;
public class RMN 
{
    public static int[] findMissingRepeatingNumbers(int[] a) 
  {
        int n = a.length; 
        int xr = 0;
        for (int i = 0; i < n; i++) {
            xr = xr ^ a[i];
            xr = xr ^ (i + 1);
        }
        int number = (xr & ~(xr - 1));
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) 
        {
            if ((a[i] & number) != 0) 
            {
                one = one ^ a[i];
            }
            else {
                zero = zero ^ a[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & number) != 0) {
                one = one ^ i;
            }
            else {
                zero = zero ^ i;
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == zero) cnt++;
        }
        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findMissingRepeatingNumbers(a);
        System.out.println("The repeating and missing numbers are: {"
                           + ans[0] + ", " + ans[1] + "}");
    }
}
