class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;
    
    // Constructor to initialize a player with given attributes
    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }
    
    // Getter Method to get the name of player
    public String getName() {
        return this.name;
    }

    // Getter Method to get the player's current health
    public int getHealth() {
        return health;
    }

    // Getter Method to get the player's strength value
    public int getStrengthValue() {
        return strength;
    }

    // Getter Method to get the player's attack value
    public int getAttackValue() {
        return attack;
    }

    // Method to apply damage to the player
    public void applyDamage(int damage) {
        health -= damage; // Reduce player's health by the given amount of damage
        if (health < 0)
            health = 0;
    }
}
