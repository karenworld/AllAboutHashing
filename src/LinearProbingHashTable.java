import java.util.Arrays;

public class LinearProbingHashTable {
	private Integer[] hashTable;
	private int tableSize;

	public LinearProbingHashTable(int size) {
		tableSize = size;
		hashTable = new Integer[tableSize];
		Arrays.fill(hashTable, null); // Initialize table with nulls
	}

	private int hashFunction(int key) {
		return key % tableSize;
	}

	public void insert(int key) {
		int index = hashFunction(key);

		// Linear probing
		while (hashTable[index] != null) {
			index = (index + 1) % tableSize; // Move to the next slot
		}

		hashTable[index] = key;
	}

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
		LinearProbingHashTable lpHashTable = new LinearProbingHashTable(11);

		// Insert some keys
		int[] keys = { 22, 33, 44, 55, 66, 77, 88, 99 };
		for (int key : keys) {
			lpHashTable.insert(key);
		}

		lpHashTable.displayTable();
	}
	
//Index 0: 22
//	Index 1: 33
//	Index 2: 44
//	Index 3: 55
//	Index 4: 66
//	Index 5: 77
//	Index 6: 88
//	Index 7: 99
//	Index 8: null
//	Index 9: null
//	Index 10: null
}
