package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    private static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count;

    abstract protected int getIndex(String uuid);

    public void clear() {
        count = 0;
        Arrays.fill(storage,null);
    }

    public int size() {
        return count;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage,count);
    }

    public Resume get(String uuid) {

        int index = getIndex(uuid);

        if(index==-1){
            System.out.println("ERROR: (get) Not find element");
            return null;
        }else {
            return storage[index];
        }

    }
}
