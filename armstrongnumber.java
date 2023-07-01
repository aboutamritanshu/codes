public class ArmstrongNumbers 
{
    public static void main(String[] args) {
        int limit = 1000; 
        for (int number = 1; number <= limit; number++) 
{
            if (isArmstrong(number))
{
                System.out.println(number);
            }
        }
    }

    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int digit;
        while (number > 0) {
            digit = number % 10;
            sum += Math.pow(digit, getNumberOfDigits(originalNumber));
            number /= 10;
        }
        return sum == originalNumber;
    }
    public static int getNumberOfDigits(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
