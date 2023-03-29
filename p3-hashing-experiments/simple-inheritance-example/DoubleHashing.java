public class DoubleHashing<K> extends Hashtable{

  public DoubleHashing(double loadFactor, int capacity){
    super(loadFactor,capacity);
  }

  @Override
  protected int h(Object element, int probe) {

    // pMod(key.hashCode(), tablesize);
    int h1 = pMod(element.hashCode(), capacity());
    //1 + pMod(key.hashCode(), tablesize - 2);
    int h2 = 1 + pMod(element.hashCode(), capacity() -2);
    // h(k,i) = (h1(k) + ih2(k)) mod m;
    int h2Final = ((h1 * element.hashCode()) + (probe * h2 * element.hashCode())) % capacity();

    return h2Final;
  }

  
}
