

public class ArrayList implements List {
  
  private int size = 0;  
  private Object[] elementData = new Object[100];
  private int modCount = 0;
  
  public boolean add(Object o){
    if (elementData.length - size <= 0) {
      increaseCapacity();
    }
    elementData[size] = o;
    size++;
    modCount++;
    return true;
  }
  
  private void increaseCapacity() {
    elementData = Arrays.copyof(elementData, elementData.length * 2);
  }

  public boolean insert(int index, Object o){
    
  }
  
  public Object get(int index){
    checkRange(index);
    return elementData[index];  
  }
  private void checkRange(int index) {
    if (index > size) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  public Object remove(int index){
    checkRange(index);
    E removedValue = (E)elementData[index];
    int dataMov = size - index - 1;
    System.arraycopy(elementData, index + 1; elementData, index, dataMov);
    size--;
    elementData[size] == null;
    modCount++;
    return removedValue;
  }
  
  public int size(){
    return size;
  }
  
  public boolean contains(Object o) {
    for (int i = 0; i < size; i++) {
      if (o.equals(elementData[i])) {
        return true;
      }
    }
    return false;
  }

  private class iterator implements Iterator<E> {
    int next;
    int previous = -1;
    int expectedModCount = modCount;

    @overrive
    public boolean hasNext() {
      return next != size;
    }

    @overrive
    public E next() {
      checkForModification();
      int i = next;
      if (i >= size) {
        throw new NoSuchElementException();
        Object[] listArr = ArrayList.this.elementData;
        next = i + 1;
        previous = i;
        return (E)listArr[previous];
      }
    }

    @overrive
    public void remove() {
      checkForModification();
      ArrayList.this.remove[previous];
      next = previous;
      previous = -1;
    }

    final void checkForModification() {
      if (modCount != expectedModCount) {
        throw new ConcurrentModificationException();
      }
    }
  }
}