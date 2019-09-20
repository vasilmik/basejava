package storage;

import model.Resume;

public interface Storage {

    void clear();

    void update(Resume resume);

    void save(Resume resume);

    void delete(String uuid);

    int size();

    Resume get(String uuid);

    Resume[] getAll();

}
