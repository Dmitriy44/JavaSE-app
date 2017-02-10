/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    final int ARRAY_SIZE=10000;
    Resume[] storage = new Resume[ARRAY_SIZE];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++)
            storage[i] = null;
        size = 0;
    }

    void save(Resume r) {
        if (getIndex(r.uuid) != -1) {
            System.out.println("Element with uuid = "+r.uuid+" already contained in storage.");
        } else {
            storage[size++] =  r;
        }
    }

    Resume get(String uuid) {
        int index=getIndex(uuid);
        if (index==-1){
            System.out.println("Element with uuid = "+uuid+" is not found.");
            return null;
        }
        return storage[index];
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(storage, index + 1, storage, index, numMoved);
            storage[--size] = null;
        } else {
            System.out.println("Element with uuid = "+uuid+" is not found.");
        }

    }

    int getIndex(String uuid){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }
        }
        return index;
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
