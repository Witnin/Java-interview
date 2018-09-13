 public class MyTest {
    static int a = 0;
    static int b = 0;
    //
    static AtomicInteger atomicInt = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {//
            Thread t = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {//
                        a = a + 1;
                        b++;
                        atomicInt.incrementAndGet();//
                    }
                }
            };
            t.start();
        }
        // 
        while (Thread.activeCount() > 1) {
            Thread.sleep(1000);
        }
        System.out.println("a=a+1:" + a);
        System.out.println("b++:" + b);
        System.out.println("last:" + atomicInt.get());
    }
}