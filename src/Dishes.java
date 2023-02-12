public enum Dishes {
    PASTA ("Pasta"),
    LASAGNA("Lasagna"),
    PIZZA("Pizza");

    private String name;

    Dishes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
