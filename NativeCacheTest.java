import org.junit.jupiter.api.Test;

class NativeCacheTest {

    @Test
    void get() {
        NativeCache nc = new NativeCache(5, Integer.class);
        nc.put("a", 111);
        nc.put("b", 222);
        nc.put("c", 333);
        nc.put("d", 444);
        nc.put("e", 555);
        for (Object i : nc.values) {
            System.out.println(i);
        }
        System.out.println("------------");
        nc.get("a");
        nc.get("e");
        nc.get("a");
        nc.get("b");
        nc.get("a");
        nc.get("a");
        nc.get("d");
        nc.get("a");
        nc.get("a");
        nc.get("d");
        nc.get("d");
        nc.get("a");
        nc.get("b");
        nc.get("d");
        for (Object i : nc.hits) {
            System.out.println(i);
        }
        nc.put("xxx",000);
        nc.get("xxx");
        nc.get("xxx");
        nc.get("xxx");
        nc.put("zzz",777);
        nc.get("zzz");
        nc.get("zzz");
        nc.get("zzz");
        nc.put("yyy",888);
        nc.get("yyy");
//        nc.put("qqq",999);
        nc.put("yyy",3000);
        System.out.println("------------");
        for (Object i : nc.values) {
            System.out.println(i);
        }
        System.out.println("------------");
        for (Object i : nc.hits) {
            System.out.println(i);
        }
    }
}