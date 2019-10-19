import model.Resume;
import storage.ListStorage;

/**
 * Test for your storage.ArrayStorage implementation
 */
public class MainTestListStorage {

    static final ListStorage LIST_STORAGE = new ListStorage();

    public static void main(String[] args) {

        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r4 = new Resume("uuid4");

        LIST_STORAGE.save(r1);
        LIST_STORAGE.save(r2);
        LIST_STORAGE.save(r3);
        printAll();

        LIST_STORAGE.update(r4);
        LIST_STORAGE.save(r3);
        LIST_STORAGE.save(r4);

        r4.uuid = "uuid44";
        LIST_STORAGE.update(r4);

        System.out.println("Get r1: " + LIST_STORAGE.get(r1.uuid));
        System.out.println("Get r4: " + LIST_STORAGE.get(r4.uuid));
        System.out.println("Size: " + LIST_STORAGE.size());

        System.out.println("Get dummy: " + LIST_STORAGE.get("dummy"));

        printAll();
        LIST_STORAGE.delete(r1.uuid);
        printAll();
        LIST_STORAGE.clear();
        printAll();

        System.out.println("Size: " + LIST_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : LIST_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
