package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage implements Storage {

    int count;

    abstract protected int getIndex(String uuid);
    abstract protected int getIndex(Resume r);

}
