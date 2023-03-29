public class LinearProbing<K> extends Hashtable{

  public LinearProbing(double loadFactor, int capacity){
    super(loadFactor,capacity);
  }

  @Override
  protected int h(Object element, int probe) { //obj we want to insert and probe

    // pMod(key.hashCode(), tablesize);
    int h1 = pMod(element.hashCode(), capacity());

    //h(k,i) = (h1(k) + i) mod m
    int h1Final = ((h1 * element.hashCode()) + probe) % capacity();

    return h1Final;
  }
    
}