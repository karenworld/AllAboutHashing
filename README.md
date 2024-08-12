I got asked questions regarding hashing like it is some kind of rocket science i decided to take a look in more details.
This repo recorded the types of collision handling methods such as linear probing, quadratic probing etc.

Practical Implications

    Memory Planning: When designing systems that use large data structures like HashMap, it’s essential to consider the memory footprint. This includes understanding the expected number of entries, the load factor, and the overhead associated with each entry.
    Garbage Collection (GC): Java’s garbage collector (GC) plays a role in managing memory, but if your HashMap is very large, GC pauses can become a significant issue, affecting application performance.
    Tuning the JVM: For applications that use large HashMaps, you may need to tune the JVM settings (like heap size) to ensure that there’s enough memory available.

Physical Memory (RAM): The total memory available in the system limits how much data can be stored. If your HashMap grows too large and the system runs out of physical memory, your program might start to use virtual memory (swap space), which can significantly slow down performance. In extreme cases, the program might crash with an OutOfMemoryError.

JVM Heap Space: In Java, the JVM has a heap space that is allocated for your application. The size of this heap is also a limiting factor. You can configure the heap size using JVM options (-Xms for initial heap size and -Xmx for maximum heap size). If the HashMap grows too large and the heap space is exhausted, the JVM will throw an OutOfMemoryError.

Memory Estimation: Engineers estimate the memory usage of the data structures they plan to use, such as hash tables. This involves understanding the typical size of objects, the number of objects, and the overhead of the data structure itself.
Profiling and Monitoring: Engineers use tools like profilers and memory analyzers during development to monitor the actual memory usage and adjust accordingly. They might run tests with different loads to see how the system behaves under stress.
Load Factor and Capacity Tuning: Engineers decide on initial capacities and load factors for hash tables based on their understanding of expected data sizes and access patterns. These decisions are often revisited during testing and profiling.
Scalability Considerations: If the application is expected to handle large amounts of data or a high number of users, engineers might consider distributed caching or sharding data across multiple servers to avoid overloading a single machine's memory.

Resources used to learn about this topic:
Visit the Repository: Go to the GitHub mirror and navigate to src/java.base/share/classes/java/util/HashMap.java.

Search for Key Methods: Look for methods like resize, put, get, and hash.

Real-World Application

    Java's HashMap: Java's HashMap uses an array size that is a power of 2. 
    This allows it to use bitwise operations to calculate the index, which is faster than using modulus with a prime number.

    Custom Implementations: When implementing a hash table yourself (e.g., using quadratic or double hashing), 
    you might prefer using a prime number as the table size, especially if you're dealing with potential clustering issues.

    Using a prime number as the size of a hash table helps improve the distribution of hash values and reduces the likelihood of collisions, particularly in probing strategies like quadratic probing and double hashing. Here's why:
1. Uniform Distribution of Hash Values

When a prime number is used as the size of the hash table, it ensures that the hash values are more evenly distributed across the table. This is because prime numbers have no divisors other than 1 and themselves, which minimizes patterns in the distribution of keys that might otherwise cause clustering.
2. Reduced Collisions

Collisions occur when two different keys produce the same hash value, causing them to be placed in the same index of the hash table. When the size of the hash table is a prime number, the modulus operation (hash % tableSize) tends to produce a more uniform spread of indices. This reduces the likelihood of multiple keys hashing to the same index, especially when the keys have common factors.
3. Better Performance in Probing

In probing methods (like quadratic probing or double hashing), using a prime number as the table size ensures that the probe sequence covers all possible slots in the table before repeating. This is crucial in avoiding infinite loops and ensuring that all slots can be probed.
Example with Double Hashing

In double hashing, you have two hash functions:

    hash1(k)=kmod  tableSizehash1(k)=kmodtableSize
    hash2(k)=p−(kmod  p)hash2(k)=p−(kmodp)

Where p is typically a prime number less than tableSize. If tableSize is also a prime number, the combination of these two hash functions ensures that the sequence of probes will be more varied and cover more slots, reducing the likelihood of collisions.
4. Avoidance of Common Factors

If the table size is not a prime number and has common factors with the keys, it may cause certain slots to be favored over others, leading to clustering. For example, if the table size is an even number (like a power of 2) and many of the keys are also even, the modulus operation might produce indices that are clustered in certain parts of the table. A prime number helps avoid this by not sharing common factors with the keys, thus spreading them more evenly

    

Examine Collision Resolution: Check how HashMap handles collisions and the transformation of linked lists to trees.
