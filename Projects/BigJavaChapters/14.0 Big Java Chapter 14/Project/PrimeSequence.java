/*
* Class sequence that implements Sequence
*/

public class PrimeSequence implements Sequence {
    int p=1;
    @Override
    public int next() {
        boolean isPrime = true;
        while (isPrime){
            p++;
            for(int d=2;d*d<=p;d++) {
                if (p%d == 0)
                    isPrime = false;
            }
            if(isPrime)
                    return p;
                isPrime = true;
            }
return 0;
    }
}
