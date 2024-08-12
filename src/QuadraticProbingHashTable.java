import java.util.Arrays;

public class QuadraticProbingHashTable {
	private Integer[] hashTable;
    private int tableSize;

    public QuadraticProbingHashTable(int size) {
        tableSize = size;
        hashTable = new Integer[tableSize];
        Arrays.fill(hashTable, null);  // Initialize table with nulls
    }

    private int hashFunction(int key) {
        return key % tableSize;
    }
    
    public void insert(int key) {
        int index = hashFunction(key);
        int i = 0;

        // Quadratic probing
        while (hashTable[(index + i * i) % tableSize] != null) {
            i++;
            if (i == tableSize) {
                // This means the table is full and no empty slot was found
                System.out.println("HashTable is full, cannot insert key: " + key);
                return;
            }
        }

        // Insert the key at the calculated index
        hashTable[(index + i * i) % tableSize] = key;
    }

//    public void insert(int key) {
//        int index = hashFunction(key);
//        int i = 1;
//        int newIndex = index;
//
//        // Quadratic probing
//        while (hashTable[newIndex] != null) {
//            newIndex = (index + i * i) % tableSize;
//            i++;
//        }
//
//        hashTable[newIndex] = key;
//    }

    public void displayTable() {
        for (int i = 0; i < tableSize; i++) {
            if (hashTable[i] != null) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }

    public static void main(String[] args) {
        QuadraticProbingHashTable qHashTable = new QuadraticProbingHashTable(11);
        
        // Insert some keys
        int[] keys = {22, 33, 44, 55, 66, 77, 88, 99};
        for (int key : keys) {
            qHashTable.insert(key);
        }

        qHashTable.displayTable();
    }
}

//HashTable is full, cannot insert key: 88
//HashTable is full, cannot insert key: 99
//Index 0: 22
//Index 1: 33
//Index 2: null
//Index 3: 77
//Index 4: 44
//Index 5: 66
//Index 6: null
//Index 7: null
//Index 8: null
//Index 9: 55
//Index 10: null

