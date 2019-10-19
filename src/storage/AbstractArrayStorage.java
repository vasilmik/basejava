package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    private static final int STORAGE_LIMIT = 10000;
    Resume[] storage = new Resume[STORAGE_LIMIT];
    int count;

    public void save(Resume resume) {

        if(count==storage.length){
            throw new StorageException("ERROR:Array full",resume.uuid);
        }

        int index = getIndex(resume);

        if(index>=0){
            throw new ExistStorageException(resume.uuid);
        }else{
            saveNewResume(resume);
        }

    }

    public void update(Resume resume){

        int index = getIndex(resume);

        if(index==-1){
            throw new NotExistStorageException(resume.uuid);
        }else{
            updateResume(resume,index);
        }
    }

    public void delete(String uuid) {

        int index = getIndex(uuid);

        if(index==-1){
            throw new NotExistStorageException(uuid);
        }else {
            deleteResume(index);
            count--;
        }
    }

    public Resume get(String uuid) {

        int index = getIndex(uuid);

        if(index==-1){
            throw new NotExistStorageException(uuid);
        }else {
            return storage[index];
        }

    }

    public void clear() {
        count = 0;
        Arrays.fill(storage,0,count,null);
    }

    public int size() {
        return count;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage,count);
    }

    abstract void saveNewResume(Resume resume);
    abstract void updateResume(Resume resume,int index);
    abstract void deleteResume(int index);

   }
