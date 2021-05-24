package game.types;

public class Recipe {
    private final Item makes;
    private final Item firstComponent, secondComponent;

    public Recipe(Item makes, Item firstComponent, Item secondComponent) {
        this.makes = makes;
        this.firstComponent = firstComponent;
        this.secondComponent = secondComponent;
    }

    public boolean isValid(String firstComponent, String secondComponent) {
        return
            this.firstComponent.getName().equals(firstComponent) && this.secondComponent.getName().equals(secondComponent) ||
            this.secondComponent.getName().equals(firstComponent) && this.firstComponent.getName().equals(secondComponent);
    }

    public Item getItem() {
        return makes;
    }
}
