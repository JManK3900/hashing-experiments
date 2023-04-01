public abstract class Hashtable<K>
{
    HashObject[] array;
    int dupeCount = 0;
    int probeCount = 0;
    protected int size = 0;
    protected int maxSize;
    protected double loadFactor = 0.5;
    static int debugLevel = 0;
    protected int isDupe;

    protected abstract int h (Object element, int probe);
    

    //**************************************************************************************************** */
    //**************Constructors************************************************************************** */
    //**************************************************************************************************** */


    public Hashtable(){
        array = new HashObject[101];
        maxSize = 1 + (int)loadFactor*capacity();
    }

    public Hashtable(double loadFactor, int capacity){
        maxSize = capacity;
        this.loadFactor = loadFactor;
        array = new HashObject[capacity];
        maxSize = (int) (1 + Math.ceil(loadFactor*capacity()));
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

            if(!(o instanceof HashObject)) return false;

            HashObject o2 = (HashObject)o;
            return o2.k.equals(this.k);
        }

        @Override
        public String toString()
        {
            // switch(debugLevel)
            // {
            //     case 0:
            //         //System.out.println("Found a twin prime table capacity: " + ;)

            //         return "Test 1: " + k;
            //     case 1:
            //         return "Test 2: " + k;
            //     case 2:
            return k + " " + dupeCount + " " + probeCount;
            // "table[" + index + "]: " + this.key + " " + this.frequency + " " + this.probeCount

            // }
            // return "Error!";
        }

        public Object getKey()
        {
            return k;
        }
    }

    //**************************************************************************************************** */
    //**************Method Definition********************************************************************* */
    //**************************************************************************************************** */

    // int h2(int keyval)
    // {
    //     return 1;
    // }

    private void reHash()
    {
        System.out.println("Uh oh");
        System.exit(-1);
    }

    public void put(K k)
    {
        //checks if size is too big
        if(size!=maxSize){

            int i;
            int c=0;
            //runs linear probing value and inserts value
            do{
                i = h(k,c);
                if(array[i]!=null) array[i].probeCount++;
                probeCount++;
                c++;
            }while(array[i]!=null && array[i].k.equals(k));
            if(array[i]!=null)
            {
                array[i].dupeCount++;
                dupeCount++;
                isDupe = 0;
            }
            else{
                array[i] = new HashObject(k);
                array[i].probeCount = c;
                probeCount += c;
                size++;
                isDupe = 1;
            }

        }

    }

    public int pMod(int dvd, int div)
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

    public int getDupe(){
        return isDupe;
    }

    public int getProbe(){
        return probeCount;
    }

    public int getDupeCount(){
        return dupeCount;
    }

    public double getProbeAvg(){
        return probeCount/maxSize;
    }

}