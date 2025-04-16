package question3;

public class Q3 {

    public void count(){
        int counter = 1;

        while(counter < 100){
            counter++;
            try{
                if(isPrime(counter)){
                    String message = counter + " is a prime number!";
                    throw new MyCustomException(message);
                }
            } catch (MyCustomException e){
                System.out.println(e.getMessage());
            }
        }

    }

    private boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

}
