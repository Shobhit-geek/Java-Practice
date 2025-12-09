package Collections.MapInterface.Others;

public class HashTable {
    
    // ✅ 1️⃣ Hashtable
    // ✔ What it is

    // Legacy class (since Java 1.0)
    // Stores data in key–value pairs
    // Thread-safe (all methods synchronized → slow)
    // Does NOT allow null key or null value

    // ✔ Internal Working

    // Uses buckets (hashing) like HashMap.
    // Every method uses synchronized, so only one thread can operate at a time → performance is poor.

    // ✔ Null Rule

    // ❌ No null key
    // ❌ No null value
    // Reason: synchronization + internal implementation can’t handle nulls safely.

    // ✔ Iteration Type
    // Fail-fast (throws ConcurrentModificationException)

    // ✔ Example
    // Hashtable<String, Integer> table = new Hashtable<>();

    // table.put("A", 10);
    // table.put("B", 20);

    // System.out.println(table);

    // for(String key : table.keySet()){
    //     System.out.println(key + " = " + table.get(key));
    // }

    // ✔ When to Use?
    // Never in new projects
    // Only if working on very old codebases
}
