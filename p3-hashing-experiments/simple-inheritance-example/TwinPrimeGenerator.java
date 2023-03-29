public class TwinPrimeGenerator{
  public static void main(String[] args) {
      generateTwinPrime(95500, 96000);
  }

  public static int generateTwinPrime(int min, int max){
    for(int i = min+2; i<=max; i++){
      if(isPrime(i) && isPrime(i-2)) return i;
    }
    return -1;
  }

  private static boolean isPrime(int n) {
    boolean prime = true;
    for(int i = 2; i <Math.sqrt(n) +1; i++){
      if(n % i == 0) {
        prime = false;
      }
    }
    return prime;
  }
}
