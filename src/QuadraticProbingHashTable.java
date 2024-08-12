import java.util.Arrays;

public class QuadraticProbingHashTable {
	private Integer[] hashTable;
    private int tableSize;
    private int size;

    public QuadraticProbingHashTable(int size) {
        tableSize = size;
        hashTable = new Integer[tableSize];
        Arrays.fill(hashTable, null);  // Initialize table with nulls
    }

    private int hashFunction(int key) {
        return key % tableSize;
    }
    
    private void resizeTable() {
        int newSize = findNextPrime(tableSize * 2);
        Integer[] newHashTable = new Integer[newSize];
        Arrays.fill(newHashTable, null);

        for (Integer key : hashTable) {
            if (key != null) {
                int index = key % newSize;
                int i = 0;
                while (newHashTable[(index + i * i) % newSize] != null) {
                    i++;
                }
                newHashTable[(index + i * i) % newSize] = key;
            }
        }

        hashTable = newHashTable;
        tableSize = newSize;
    }
//    
//    public void insert(int key) {
//        int index = hashFunction(key);
//        int i = 0;
//
//        // Quadratic probing
//        while (hashTable[(index + i * i) % tableSize] != null) {
//            i++;
//            if (i == tableSize) {
//                // This means the table is full and no empty slot was found
//                System.out.println("HashTable is full, cannot insert key: " + key);
//                return;
//            }
//        }
//
//        // Insert the key at the calculated index
//        hashTable[(index + i * i) % tableSize] = key;
//    }
   // refactored code
    public void insert(int key) {
        if (size >= tableSize / 2) {
            resizeTable();
        }

        int index = hashFunction(key);
        int i = 0;

        // Quadratic probing
        while (hashTable[(index + i * i) % tableSize] != null) {
            i++;
        }

        // Insert the key at the calculated index
        hashTable[(index + i * i) % tableSize] = key;
        size++;
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
    
    private int findNextPrime(int num) {
        while (!isPrime(num)) {
            num++;
        }
        return num;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
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


//result without using Prime resulting in clustering
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

//using Primme
//Index 0: null
//Index 1: null
//Index 2: null
//Index 3: null
//Index 4: null
//Index 5: null
//Index 6: null
//Index 7: 99
//Index 8: 77
//Index 9: 55
//Index 10: 33
//Index 11: null
//Index 12: null
//Index 13: null
//Index 14: null
//Index 15: null
//Index 16: null
//Index 17: null
//Index 18: null
//Index 19: 88
//Index 20: 66
//Index 21: 44
//Index 22: 22

