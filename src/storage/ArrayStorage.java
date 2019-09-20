package storage;

import model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume resume) {

        if(count==storage.length){
            System.out.println("ERROR: (save) Array full");
            return;
        }

        int index = getIndex(resume.uuid);

        if(index>=0){
            System.out.println("ERROR: (save) Find element index = "+index);
            return;
        }else{
            storage[count] = resume;
            count++;
        }

    }

    public void update(Resume resume){

        int index = getIndex(resume.uuid);

        if(index==-1){
            System.out.println("ERROR: (update) Not find element");
            return;
        }else{
            storage[index] = resume;
        }
    }

    public void delete(String uuid) {

        int index = getIndex(uuid);

        if(index==-1){
            System.out.println("ERROR: (delete) Not find element");
            return;
        }else {
            for (int i = index; i < count; i++) {
                storage[i] = storage[i + 1];
            }
            count--;
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
}
