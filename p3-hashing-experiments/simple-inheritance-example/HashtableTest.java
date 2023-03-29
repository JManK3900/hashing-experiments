import java.util.*;


//RUN java HashTableTest 1 0.90 #<-(0 through 2)

public class HashTableTest
{
    public static void main(String[] args) throws Excpetion
    {
        int debugLevel=0;

        if(args.length==3) degubLevel=Integer.parseInt(args[2]);
        //if(debugLevel<0 || debugLevel>2) throw new IllegalArgumentExpection("Java HashTableTest <dateType> <loadFactor> [<debugLevel>]");
        if(debugLevel<0 || debugLevel>2) throw new IllegalArgumentExpection("Debug level must be between 0 and 2");

        double loadFactor == Double.parseDouble(args[1]);

        switch(Integer.parseInt(args[0]))
        {
            case 1: //ints
                HashTable<Integer> lph = new HashTable<Integer>(loadFactor, 95791);
                HashTable<Integer> dh = new HashTable<Integer>(loadFactor, 95791)
                {
                    int h2(int keyval)
                    {
                        return 1 + pMod(keyval, capacity()-2);
                    }
                }
                lph.setDebugLevel(debugLevel); //@@@
                dh.setDebugLevel(debugLevel); //@@@
                Random r = new Random();
                while(lph.size() != lph.maxSize())
                {
                    int foo;
                    lph.put(foo = r.nextInt());
                    dh.put(foo);
                }
                System.out.println(lph);
                System.out.println(dh);

                


            break;
            case 2: //dates(longs)
            break;
            case 3: // strings
            break;
        }
    }
}