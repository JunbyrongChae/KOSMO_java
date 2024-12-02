package classes.design;

public class DuckSimulation {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Duck rubber = new RubberDuck();
        Duck wood = new WoodDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();
        rubber.display();
        rubber.performFly();
        rubber.performQuack();
        wood.display();
        wood.performFly();
        wood.performQuack();
    }
}
