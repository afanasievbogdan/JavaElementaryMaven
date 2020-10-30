package HomeWork25;

import java.util.*;

public class MyMap<KEY, VALUE>{

    private final Map<KEY, VALUE> map;
    private final Deque<KEY> queue;
    final int limit;

    public MyMap (int limit) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        this.limit = limit;
    }

    public void put(KEY key, VALUE value) {
        VALUE oldValue = map.put(key, value);
        if (oldValue != null) {
            queue.removeFirstOccurrence(key);
        }
        queue.addFirst(key);

        if (map.size() > limit) {
            final KEY removedKey = queue.removeLast();
            map.remove(removedKey);
        }
    }

    public VALUE get(KEY key) {
        queue.removeFirstOccurrence(key);
        queue.addFirst(key);
        return map.get(key);
    }

    public void clear() {
        queue.clear();
        map.clear();
    }

    public String values() {
        return map.values().toString();
    }
}
