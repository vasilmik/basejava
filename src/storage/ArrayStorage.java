package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void saveNewResume(Resume resume){
        storage[count] = resume;
        count++;
    }

    @Override
    void updateResume(Resume resume, int index) {
        storage[index] = resume;
    }

    @Override
    void deleteResume(int index) {
        for (int i = index; i < count; i++) {
            storage[i] = storage[i + 1];
        }
    }

    @Override
    public int getIndex(String uuid){

        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getIndex(Resume r){

        for (int i = 0; i < count; i++) {
            if (r.uuid.equals(storage[i].uuid)) {
                return i;
            }
        }
        return -1;
    }
}
