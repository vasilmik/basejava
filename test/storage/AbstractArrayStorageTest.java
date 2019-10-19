package storage;

import exceptions.NotExistStorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractArrayStorageTest {

    private Storage myStorage = new ArrayStorage();

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Before
    public void setUp() throws Exception{
        myStorage.clear();
        myStorage.save(new Resume(UUID_1));
        myStorage.save(new Resume(UUID_2));
        myStorage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() throws Exception {

    }

    @Test
    public void size() {
        Assert.assertEquals(3,myStorage.size());
    }

    @Test
    public void getAll() {
    }

    @Test
    public void get() {
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        myStorage.update(new Resume("DYMMI"));
    }
}