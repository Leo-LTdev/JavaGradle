package projet.Menu;

import java.util.Random;
import java.util.Scanner;

import projet.Class.Character.Aventurer;
import projet.Class.Character.AventurerFactory;
import projet.Class.Character.FactoryMonstre;
import projet.Class.Character.Monster;
import projet.Class.Character.Orc;
import projet.Class.Character.Tyranide;

public class Menu {

    public static void mainMenu(boolean inGame, Aventurer player, Scanner scanner) {
        while (inGame && player != null && player.getLife() > 0) {
            System.out.println("1 : Voir ses stats");
            System.out.println("2 : Combattre");
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
            if (nombre == 9) {
                /* Fin du jeu */
                inGame = false;
                System.out.println("Fin du jeu.");
            }
        }
    }

    public static Aventurer initPlayer(Scanner scanner) {
        System.out.println("Choisis une race parmis celle-ci :");
        System.out.println("1 : Humain");
        System.out.println("2 : Elfes");
        System.out.println("3 : Nains");

        int nombre = scanner.nextInt();
        return AventurerFactory.CreatAventurer(nombre);
    }

    public static void fight(Aventurer player, Scanner scanner) {
        Monster monster = randomMonster();
        System.out.println(infightMonster(monster)); /* Print de l'ennemi */
        boolean escape = true;
        int nombre;
        while (!player.isDead() && !monster.isDead() && escape) {
            System.out.println("1 : Attaquer");
            System.out.println("2 : Utiliser un objet");
            System.out.println("3 : Fuir");
            nombre = scanner.nextInt();
            if (nombre == 1) {
                player.dealDamage(monster);
                if (!monster.isDead()) {
                    monster.dealDamage(player);
                }
            }
            if (nombre == 3) {
                if (player.escape()) {
                    escape = false;
                } else {
                    monster.dealDamage(player);
                }
            }
        }
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
            case 1:
                return FactoryMonstre.createTyranide();
            case 2:
                return FactoryMonstre.createUndead();
            case 3:
                return FactoryMonstre.createOrc();
            default:
                return FactoryMonstre.createOrc();
        }
    }
}
