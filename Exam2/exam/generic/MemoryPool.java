public class MemoryPool {
    public MemoryPool(int size) {
        managedPool = new Object[size];
        inUse = new boolean[size];
    }
    public int allocate() {
        for(int index=0; index < inUse.length; ++index) {
            if(!inUse[index]) {
                inUse[index] = true;
                return index;
            }
        }
        throw new IndexOutOfBoundsException("Pool elements exhausted");
    }
    public Integer get(int index) {
        return (Integer) managedPool[index];
    }
    public void set(int index, Integer element) {
        managedPool[index] = element;
    }
    public void free(int index) {
        if(!inUse[index]) {
            throw new IndexOutOfBoundsException("Returned unallocated element " + index);
        }
        inUse[index] = false;
    }
    
    private Object[] managedPool;
    private boolean[] inUse;
}
