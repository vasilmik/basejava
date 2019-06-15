/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int count;

    void clear() {

        count = 0;
    }

    void save(Resume r) {
        storage[count] = r;
        count++;
    }

    Resume get(String uuid) {
        for (Resume res : storage) {
            if (res == null) {
                return null;
            } else if (res.uuid == uuid) {
                return res;
            }
        }
        return null;
    }

    void delete(String uuid) {

        int index = 10000;

        for (int i = 0; i < count; i++) {
            if (storage[i].uuid == uuid) {
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

    int size() {
        return count;
    }
}
