package HomeWork25;

public class MyCache {
    private final int lifeTime;
    private final MyMap<Integer, Object> data;

    public MyCache(int lifeTime, int limit){
        this.lifeTime = lifeTime;
        data = new MyMap<>(limit);
        clear();
    }

    public void put(Object value) {
        data.put(value.hashCode(), value);
    }

    public Object get(int key) {
        return data.get(key);
    }

    public synchronized void clear() {
        new Thread(() -> {
            try {
                Thread.sleep(lifeTime * 1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            data.clear();
        }).start();
    }

    public void showCacheData(){
        System.out.println(data.values());
    }
}
