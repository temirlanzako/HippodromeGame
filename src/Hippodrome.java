import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("first", 3, 0));
        horses.add(new Horse("second", 3, 0));
        horses.add(new Horse("third", 3, 0));
        Hippodrome hippodrome = new Hippodrome(horses);
        game = hippodrome;

        game.run();

        game.printWinner();
    }
    public void run() throws InterruptedException {
        for (int i = 1; i < 101; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move() {
        for(Horse asd : horses) {
            asd.move();
        }
    }
    public void print() {
        for(Horse asd : horses) {
            asd.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner() {
        Horse result = horses.get(0);
        for(Horse horse : horses) {
            if(horse.getDistance() > result.getDistance()) {
                result = horse;
            }
        }
        return result;
    }
    public void printWinner() {
        System.out.println("Winner is " + game.getWinner().getName() + "!");
    }
}
