package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    List<Resume> resumeList = new ArrayList<>();

    @Override
    public void clear() {
        resumeList.clear();
    }

    @Override
    public void save(Resume resume) {

        int index = getIndex(resume);

        if (index >= 0) {
            System.out.println("ERROR: (save) Find element index = " + index);
            return;
        } else {
            resumeList.add(resume);
        }

    }

    @Override
    public void update(Resume resume) {

        int index = getIndex(resume);

        if (index == -1) {
            System.out.println("ERROR: (update) Not find element");
            return;
        } else {
            resumeList.remove(index);
            resumeList.add(index, resume);
        }

    }

    @Override
    public void delete(String uuid) {
        Resume r = new Resume(uuid);
        resumeList.remove(r);
    }

    @Override
    public int size() {
        return resumeList.size();
    }

    @Override
    public Resume get(String uuid) {

        int index = getIndex(uuid);

        if (index == -1) {
            System.out.println("ERROR: (get) Not find element");
            return null;
        } else {
            return resumeList.get(index);
        }
    }

    @Override
    public Resume[] getAll() {
        return resumeList.toArray(new Resume[0]);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume r = new Resume(uuid);
        return resumeList.indexOf(r);
    }

    @Override
    protected int getIndex(Resume r) {
        return resumeList.indexOf(r);
    }
}
