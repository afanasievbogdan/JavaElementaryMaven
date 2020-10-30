package HomeWork25;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Data data1 = new Data(1, "data1");
        Data data2 = new Data(2, "data2");
        Data data3 = new Data(3, "data3");
        Data data4 = new Data(4, "data4");

        System.out.print(data1 + ", ");
        System.out.print(data2 + ", ");
        System.out.println(data3);

        MyCache myCache = new MyCache(5, 3);

        myCache.put(data1);
        myCache.put(data2);
        myCache.put(data3);

        myCache.showCacheData(); // cash map with data1, data2, data3

        myCache.get(1);
        myCache.get(1);

        myCache.put(data4);

        myCache.showCacheData(); // cash map with data1, data4, data3

        Thread.sleep(5001);

        myCache.showCacheData(); // empty cash map
    }



}
