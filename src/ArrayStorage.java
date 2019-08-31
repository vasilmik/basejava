import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];

    private int count;

    void clear() {
        count = 0;
        Arrays.fill(storage,null);
    }

    void update(Resume resume){

        int index = getIndex(resume.uuid);

        if(index==-1){
            System.out.println("ERROR: (update) Not find element");
            return;
        }else{
            storage[index] = resume;
        }
    }

    void save(Resume resume) {

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

    void delete(String uuid) {

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

    int size() {
        return count;
    }

    Resume get(String uuid) {

        int index = getIndex(uuid);

        if(index==-1){
            System.out.println("ERROR: (get) Not find element");
            return null;
        }else {
            return storage[index];
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage,count);
    }

    private int getIndex(String uuid){

        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return i;
            }
        }

        return -1;

    }
}
