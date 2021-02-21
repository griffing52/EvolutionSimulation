public class App {
    public static int fps = 60;
    private static long lastUpdate;
    
    public App() {
        lastUpdate = System.currentTimeMillis();
    }

    public void setup() {

    }

    public void loop() {

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        App a = new App();
        a.setup();

        while (true) {
            if (lastUpdate - System.currentTimeMillis() >= (1000 / fps)) {
                a.loop();
                lastUpdate = System.currentTimeMillis();
            }
            // a.loop();
            Thread.sleep(1000/fps);
        }
    }
}