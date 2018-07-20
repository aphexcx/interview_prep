package actualinterviews;
//Please use this Google doc to code during your interview.
// To free your hands for coding, we recommend that you use a headset or a phone with speaker option.


//        System.getTimeMillis()
// 19298492384
// 19298492385

//class ExpiringMap<K, V>:
//        put(K key, V value, long duration); // 1) store the key, value in storage
////2) store the expiration time in expirationTimes (currentTimeMillis + duration)
//
//        get(K key); // return the value if it’s not expired
//// if it is expired, delete it from both storage and expirationTimes
//        HashMap<K,V> storage = new HashMap<K,V>()
//        HashMap<K,long> expirationTimes = new HashMap()


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

class ExpiringMap<K, V> {
    private HashMap<K, V> storage = new HashMap<K, V>();
    private HashMap<K, Long> expirationTimes = new HashMap<K, Long>();

    void put(K key, V value, long duration) throws IllegalArgumentException {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must not be negative.");
        }
        storage.put(key, value);
        expirationTimes.put(key, System.currentTimeMillis() + duration);

        //cleanup pass
        for (K k : expirationTimes.keySet()) {
            if (expirationTimes.get(k) < System.currentTimeMillis()) {
                // expired, remove from both maps
                storage.remove(k);
                expirationTimes.remove(k);
            }
        }
    }

    @Nullable
    V get(@NotNull K key) {
        if (expirationTimes.get(key) == null) {
            return null;
        }
        if (expirationTimes.get(key) <= System.currentTimeMillis()) {
            return storage.get(key);
        } else {
            return null;
        }
    }

}
