package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

   @Override
    void saveNewResume(Resume resume) {
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

       Resume searchKey = new Resume(uuid);

       return Arrays.binarySearch(storage, searchKey);

    }

    @Override
    public int getIndex(Resume r){
        return Arrays.binarySearch(storage, r);
    }

}
