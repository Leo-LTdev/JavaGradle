package projet.Menu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import projet.Class.Character.Aventurer;
import projet.Class.Character.AventurerFactory;
import projet.Class.Character.FactoryMonstre;
import projet.Class.Character.Monster;
import projet.Class.Character.Orc;
import projet.Class.Character.Tyranide;
import projet.Class.Object.Armor;
import projet.Class.Object.Potion;
import projet.Class.Object.Weapon;

public class Menu {

    public static Aventurer initPlayer(Scanner scanner) {
        System.out.println("Choisis une race parmis celle-ci :");
        System.out.println("1 : Humain");
        System.out.println("2 : Elfes");
        System.out.println("3 : Nains");

        int nombre = scanner.nextInt();
        return AventurerFactory.CreatAventurer(nombre);
    }

    public static void mainMenu(boolean inGame, Aventurer player, Scanner scanner) throws InterruptedException {
        while (inGame && player != null && player.getLife() > 0) {
            System.out.println("1 : Voir ses stats");
            System.out.println("2 : Combattre");
            System.out.println("3 : équiper un objet de l'inventaire");
            System.out.println("4 : Boire une potion");

            System.out.println("9 : Quitter la partie");
            int nombre = scanner.nextInt();
            if (nombre == 1) {
                /* Stats */
                player.showStats();
            }
            if (nombre == 2) {
                /* Combat */
                fight(player, scanner);
            }
            if (nombre == 3) {
                gearEquip(player, scanner);
            }
            if (nombre == 4) {
                drinkPot(player, scanner);
            }
            if (nombre == 9) {
                /* Fin du jeu */
                inGame = false;
                System.out.println("Fin du jeu.");
            }
        }
    }

    public static void drinkPot(Aventurer player, Scanner scanner) throws InterruptedException {
        ArrayList<Object> originalInventory = player.getInventory();
        ArrayList<Object> inventory = new ArrayList<>(originalInventory);
        if (inventory.isEmpty()) {
            System.err.println("Inventaire vide, retour au menu");
            Thread.sleep(1000);
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                Object actualItem = inventory.get(i);
                if (!(actualItem instanceof Potion)) {
                    inventory.remove(i);
                    i--;
                } else {
                    System.err.println(i + " : " + inventory.get(i));
                }
            }
            System.err.println("Voici ton inventaire, écrit le nombre de la potion que tu veux :");
            int choice = scanner.nextInt();
            Object Item = inventory.get(choice);
            player.drinkPotion((Potion) Item);
        }
    }

    public static void gearEquip(Aventurer player, Scanner scanner) throws InterruptedException {
        ArrayList<Object> originalInventory = player.getInventory();
        ArrayList<Object> inventory = new ArrayList<>(originalInventory);
        if (inventory.isEmpty()) {
            System.err.println("Inventaire vide, retour au menu");
            Thread.sleep(1000);
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                Object actualItem = inventory.get(i);
                if (actualItem instanceof Potion) {
                    inventory.remove(i);
                    i--;
                } else {
                    System.err.println(i + " : " + inventory.get(i));
                }
            }
            System.err.println("Voici ton inventaire, écrit le nombre de l'équipement que tu veux :");
            int choice = scanner.nextInt();
            Object Item = inventory.get(choice);
            if (Item instanceof Armor) {
                player.equipArmor((Armor) Item);
            }
            if (Item instanceof Weapon) {
                player.equipWeapon((Weapon) Item);
            }
        }
    }

    public static void fight(Aventurer player, Scanner scanner) {
        Monster monster = randomMonster();
        System.out.println(infightMonster(monster));
        /* Print de l'ennemi */
        boolean escape = true;
        int nombre;
        while (!player.isDead() && !monster.isDead() && escape) {
            System.out.println("1 : Attaquer");
            System.out.println("2 : Utiliser un objet");
            System.out.println("3 : Fuir");
            nombre = scanner.nextInt();
            if (nombre == 1) {
                damageOption(player, monster);
            }
            if (nombre == 2) {

            }
            if (nombre == 3) {
                escape = tryEscape(escape, player, monster);
            }
        }
    }

    public static void damageOption(Aventurer player, Monster monster) {
        player.dealDamage(monster);
        if (!monster.isDead()) {
            monster.dealDamage(player);
        } else if (monster.isDead()) { // Lorsque le monstre est mort
            Drops(player);
        }
    }

    public static void Drops(Aventurer player) {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0:
                Object Armor = Monster.armorDrop(randomNumber, random);
                player.setInventory(Armor);
                break;
            case 1:
                Object Weapon = Monster.weaponDrop(randomNumber, random);
                player.setInventory(Weapon);
                break;
            case 2:
                Object Potion = Monster.potionDrop(randomNumber, random);
                player.setInventory(Potion);
                break;
            default:
                Object Default = Monster.armorDrop(randomNumber, random);
                player.setInventory(Default);
                break;
        }
    }

    public static boolean tryEscape(boolean escape, Aventurer player, Monster monster) {
        if (player.escape()) {
            escape = false;
        } else {
            monster.dealDamage(player);
        }
        return escape;
    }

    public static String infightMonster(Monster monster) {
        if (monster instanceof Orc) {
            return "Vous faites face à un Orc";
        } else if (monster instanceof Tyranide) {
            return "Vous faites face à un Tyranide";
        } else {
            return "Vous faites face à un Undead";
        }
    }

    public static Monster randomMonster() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0:
                return FactoryMonstre.createOrc();
            case 1:
                return FactoryMonstre.createUndead();
            case 2:
                return FactoryMonstre.createTyranide();
            default:
                return FactoryMonstre.createOrc();
        }
    }
}
