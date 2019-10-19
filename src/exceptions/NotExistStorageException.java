package exceptions;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("ERROR: Not exist element",uuid);
    }
}
