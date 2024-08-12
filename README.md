I got asked questions regarding hashing like it is some kind of rocket science i decided to take a look in more details.
This repo recorded the types of collision handling methods such as linear probing, quadratic probing etc.

Practical Implications

    Memory Planning: When designing systems that use large data structures like HashMap, it’s essential to consider the memory footprint. This includes understanding the expected number of entries, the load factor, and the overhead associated with each entry.
    Garbage Collection (GC): Java’s garbage collector (GC) plays a role in managing memory, but if your HashMap is very large, GC pauses can become a significant issue, affecting application performance.
    Tuning the JVM: For applications that use large HashMaps, you may need to tune the JVM settings (like heap size) to ensure that there’s enough memory available.

Physical Memory (RAM): The total memory available in the system limits how much data can be stored. If your HashMap grows too large and the system runs out of physical memory, your program might start to use virtual memory (swap space), which can significantly slow down performance. In extreme cases, the program might crash with an OutOfMemoryError.

JVM Heap Space: In Java, the JVM has a heap space that is allocated for your application. The size of this heap is also a limiting factor. You can configure the heap size using JVM options (-Xms for initial heap size and -Xmx for maximum heap size). If the HashMap grows too large and the heap space is exhausted, the JVM will throw an OutOfMemoryError.

Resources used to learn about this topic:
Visit the Repository: Go to the GitHub mirror and navigate to src/java.base/share/classes/java/util/HashMap.java.

Search for Key Methods: Look for methods like resize, put, get, and hash.

Examine Collision Resolution: Check how HashMap handles collisions and the transformation of linked lists to trees.
