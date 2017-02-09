/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++)
            storage[i] = null;
        size = 0;
    }

    void save(Resume r) {
        if (get(r.uuid) != null) {
            System.out.println("Element with uuid = "+r.uuid+" already contained in storage.");
        } else {
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(storage, index + 1, storage, index, numMoved);
            storage[--size] = null;
        } else {
            System.out.println("Element with uuid = "+uuid+" is not found.");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] newArray = new Resume[size];
        System.arraycopy(storage, 0, newArray, 0, size);
        return newArray;
    }

    int size() {
        return size;
    }
}
