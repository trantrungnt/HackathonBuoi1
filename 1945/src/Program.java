/**
 * Created by Anh on 3/5/2016.
 */
public class Program {
    public static void main(String[] args) {

        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();

    }
}
