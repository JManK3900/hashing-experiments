import java.util.*;


//RUN java HashTableTest 1 0.90 #<-(0 through 2)

public class HashtableTest
{
    public static void main(String[] args) throws Exception
    {
        int debugLevel=0;

        if(args.length==3) debugLevel=Integer.parseInt(args[2]);
        //if(debugLevel<0 || debugLevel>2) throw new IllegalArgumentExpection("Java HashTableTest <dateType> <loadFactor> [<debugLevel>]");
        if(debugLevel<0 || debugLevel>2) throw new IllegalArgumentException("Debug level must be between 0 and 2");

        double loadFactor = Double.parseDouble(args[1]);

        switch(Integer.parseInt(args[0]))
        {
            case 1: //ints
                LinearProbing<Integer> lphi = new LinearProbing<Integer>(loadFactor, 95791);
                DoubleHashing<Integer> dhi = new DoubleHashing<Integer>(loadFactor, 95791);
                // {
                //     int h2(int keyval)
                //     {
                //         return 1 + pMod(keyval, capacity()-2);
                //     }
                // }
                lphi.setDebugLevel(debugLevel); //@@@
                dhi.setDebugLevel(debugLevel); //@@@
                Random r = new Random();
                while(lphi.size != lphi.maxSize)
                {
                    int foo;
                    lphi.put(foo = r.nextInt());
                    dhi.put(foo);
                }
                System.out.println(lphi);
                System.out.println(dhi);

                


            break;
            case 2: //dates(longs)
                LinearProbing<Long> lphl = new LinearProbing<Long>(loadFactor, 95791);
                DoubleHashing<Long> dhl = new DoubleHashing<Long>(loadFactor, 95791);
                lphl.setDebugLevel(debugLevel);
                dhl.setDebugLevel(debugLevel);

                long current = new Date().getTime();

            break;
            case 3: // strings
                LinearProbing<String> lphs = new LinearProbing<String>(loadFactor, 95791);
                DoubleHashing<String> dhs = new DoubleHashing<String>(loadFactor, 95791);
                lphs.setDebugLevel(debugLevel);
                dhs.setDebugLevel(debugLevel);

            break;
        }
    }
}