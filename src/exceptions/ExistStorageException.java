package exceptions;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("ERROR: Exist element", uuid);
    }
}
