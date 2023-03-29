import java.util.*;

public class HashTable<K>
(
    HashObject[] array;
    int dupeCount = 0;
    int probeCount = 0;
    int size = 0;
    int maxSize;
    double loadFactor = 0.5;
    static int debugLevel = 0;
    

    //**************************************************************************************************** */
    //**************Constructors************************************************************************** */
    //**************************************************************************************************** */


    public HashTable(){
        array = new HashObject[101];
        maxSize = 1 + (int)loadFactor*capacity();
    }

    public HashTable(double loadFactor, int capacity){
        this.loadFactor = loadFactor;
        array = new HashObject[capacity];
        maxSize = 1 + (int)loadFactor*capacity();
    }

    //**************************************************************************************************** */
    //***********Inner Class Declerations***************************************************************** */
    //**************************************************************************************************** */

    static class HashObject
    {
        Object k;
        int dupeCount=0;
        int probeCount=0;


        public HashObject(Object k)
        {
            this.k=k;
        }

        public boolean equals(Object o)
        {
            if(o==this) return true;

            if(!(0 instanceof HashObject)) return false;

            HashObject o2 = (HashObject)o;
            reutnr o2.k.equals(this.k);
        }

        public String toString()
        {
            switch(debugLevel)
            {
                case 0:
                    return "" + k;
                case 1:
                    return "" + 
                case 2:
                   return "" + k + " " + probeCount + " " + dupeCount;

            }
        }

        public Object getKey()
        {
            return k;
        }
    }

    //**************************************************************************************************** */
    //**************Method Definition********************************************************************* */
    //**************************************************************************************************** */

    int h2(int keyval)
    {
        return 1;
    }

    private vodi reHash()
    {
        System.out.println("Uh oh");
        System.exit(-1);
    }

    public void put(K k)
    {
        if(size==maxSize) reHash();
        int i;
        int c=0;
        do
        {
            i = pMod(pMod(k.hashCode(),capacity()) + c*h2(k.hashCode()), capacity());
            if(array[i]!=null) array[i].probeCount++;
            probeCount++;
            c++;
        } while(array[i]!=null && !array[i].k.equals(k));

        if(array[i]!=null)
        {
            array[i].dupeCount++;
            dupeCount++;
        }
        else
        {
            array[i] = new HashObject(k);
            array[i].probeCount = c;
            probeCount += c;
            size++; //@@@
        }

    }

    int public pMod(int dvd, int div)
    {
        int q = dvd%div;
        if(q<0) q+=div;
        return q;
    }

    public void setDebugLevel(int d)
    {
        debugLevel = d;
    }


    public int capacity(){
        return array.length;
    }

)