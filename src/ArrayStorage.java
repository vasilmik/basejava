/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];

    private int count;

    void clear() {
        count = 0;
    }

    void save(Resume r) {
        storage[count] = r;
        count++;
    }

    void delete(String uuid) {

        int index = 10000;

        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].uuid)) {
                index = i;
            }
        }

        if (index < 10000) {
            for (int i = index; i < count; i++) {
                storage[i] = storage[i + 1];
            }
            count--;
        }
    }

    int size() {
        return count;
    }

    Resume get(String uuid) {

        for (int i = 0; i < count; i++) {
            if(uuid.equals(storage[i].uuid)){
                return storage[i];
            }
        }

        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] storageSize = new Resume[count];

        for (int i = 0; i < count; i++) {
            storageSize[i] = storage[i];
        }
        return storageSize;
    }

}
