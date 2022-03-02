/**
 * "choose your adventure" game based on a pirate on a treasure quest
 *
 * modified 20210811
 * date 20210811
 *
 * @filename ChooseYourAdventure.java
 * @author Emily Su
 * @version 1.0
 */
import java.util.Scanner;

public class ChooseYourAdventure {

    public static void main(String[] args) {

        Scanner keyedInput = new Scanner(System.in);

        String response;

        // beginning of story is told to user
        System.out.println("");
        System.out.println("---Choose Your Own Adventure Game: Pirate and Treasure Edition---");
        System.out.println("");
        System.out.println("You are a pirate who wants to find buried treasure. Currently, you are with your crew on a ship in the middle of the sea.");
        System.out.println("You have a treasure map, but a part of it is smudged. Although some of the map is still legible, the smudge has left you unsure of whether you should sail to island A or island B to find the treasure.");
        System.out.println("");
        System.out.println("Do you go to island A or island B?");
        System.out.println("");
        System.out.println("Please only enter \"A\" or \"B\" to make your choice:"); // https://stackoverflow.com/questions/3844595/how-can-i-make-java-print-quotes-like-hello#:~:text=print(%22%5C%22Hello%5C,r%22%20and%20%22%5Cn%22
        System.out.println("(Do not include the apostrophes! Your response must be in ALL UPPERCASE)");
        System.out.println("");
        response = keyedInput.nextLine();

        // prompts user to choose
        if (response.equals("A")) {
            System.out.println("");
            System.out.println("...");
            System.out.println("");
            System.out.println("You sail your ship to island A. Once there, you notice that the island is unexpectedly rocky and dangerous. Just your luck!");
            System.out.println("You realize that you might need your crew to help you with the rest of your treasure quest, but you also realize that they might not be capable of surviving while traversing this island.");
            System.out.println("You do not want to die, but you also do not want your crew to get hurt.");
            System.out.println("");
            System.out.println("Do you traverse the island with your crew or alone?");
            System.out.println("");
            System.out.println("Please only enter \"WITH CREW\" or \"ALONE\" to make your choice:"); // https://stackoverflow.com/questions/3844595/how-can-i-make-java-print-quotes-like-hello#:~:text=print(%22%5C%22Hello%5C,r%22%20and%20%22%5Cn%22 
            System.out.println("(Do not include the apostrophes! Your response must be in ALL UPPERCASE)");
            System.out.println("");
            response = keyedInput.nextLine();
            if (response.equals("WITH CREW")) {
                System.out.println("");
                System.out.println("...");
                System.out.println("");
                System.out.println("You bring your crew along with you. Together, you all seem to traverse the rocky island quite easily...");
                System.out.println("...Until all of your crewmates get distracted by a nearby butterfly while climbing a steep rock!");
                System.out.println("They all fall off the side of the rock to their deaths.");
                System.out.println("Since you are so focused on climbing the rock, you do not realize until you finish climbing. When you find out, you are overcome by grief and sorrow.");
                System.out.println("");
                System.out.println("Do you continue on your quest or take some time to mourn?");
                System.out.println("");
                System.out.println("Please only enter \"CONTINUE\" or \"MOURN\" to make your choice:"); // https://stackoverflow.com/questions/3844595/how-can-i-make-java-print-quotes-like-hello#:~:text=print(%22%5C%22Hello%5C,r%22%20and%20%22%5Cn%22
                System.out.println("(Do not include the apostrophes! Your response must be in ALL UPPERCASE)");
                System.out.println("");
                response = keyedInput.nextLine();
                if (response.equals("CONTINUE")) {
                    System.out.println("");
                    System.out.println("...");
                    System.out.println("");
                    System.out.println("You try your best to stay strong and carry on without your crew to find the treasure. You tell yourself, \"It's what they would've wanted.\"");
                    System.out.println("Eventually, you find a treasure chest in a large open crevice of a rock that you are climbing. It's not buried treasure, but it'll do.");
                    System.out.println("You bring the treasure chest back to your ship and sail off to other islands on your own.");
                    System.out.println("");
                    System.out.println("You are not dead, but you certainly feel like you are, as the crewmates who felt like family to you are no longer with you.");
                    System.out.println("");
                    System.out.println("Ending 1 of 8:");
                    System.out.println("The living ghost");
                    System.out.println("");
                    System.out.println("You can rerun the program to make different decisions on your adventure!");
                    System.out.println("");
                    System.out.println("---The End---");
                    System.out.println("");
                } else if (response.equals("MOURN")) {
                    System.out.println("");
                    System.out.println("...");
                    System.out.println("");
                    System.out.println("You mourn over the deaths of your crewmates.");
                    System.out.println("Eventually, you decide to set up a fire to commemorate your dead crew. You use some nearby branches and the cigarette lighter in your pocket to make the fire.");
                    System.out.println("You stand there, solemnly. It is such a sad yet beautiful moment...");
                    System.out.println("...Unfortunately for you, your luck seems to be horrible today.");
                    System.out.println("A bear has come to you, attracted by the light of the fire.");
                    System.out.println("Once seeing you, the bear that is much larger and stronger than you attacks you.");
                    System.out.println("It quickly kills you. ");
                    System.out.println("You are dead.");
                    System.out.println("");
                    System.out.println("Ending 2 of 8:");
                    System.out.println("Fourth time's the charm?");
                    System.out.println("");
                    System.out.println("You can rerun the program to make different decisions on your adventure!");
                    System.out.println("");
                    System.out.println("---The End---");
                    System.out.println("");
                } else {
                    System.out.println("The response you entered is invalid. Please manually run the program again.");
                }
            } else if (response.equals("ALONE")) {
                System.out.println("");
                System.out.println("...");
                System.out.println("");
                System.out.println("You travel alone so that your crew can remain safe on the ship.");
                System.out.println("While climbing the many rocks on the island, you become hungry.");
                System.out.println("There is a nearby berry bush, but you do not know if the berries on it are safe to eat.");
                System.out.println("");
                System.out.println("Do you pick and eat a berry?");
                System.out.println("");
                System.out.println("Please only enter \"YES\" or \"NO\" to make your choice:"); // https://stackoverflow.com/questions/3844595/how-can-i-make-java-print-quotes-like-hello#:~:text=print(%22%5C%22Hello%5C,r%22%20and%20%22%5Cn%22
                System.out.println("(Do not include the apostrophes! Your response must be in ALL UPPERCASE)");
                System.out.println("");
                response = keyedInput.nextLine();
                if (response.equals("YES")) {
                    System.out.println("");
                    System.out.println("...");
                    System.out.println("");
                    System.out.println("You cautiously eat a berry...");
                    System.out.println("...Miraculously, the berry that you ate gives you the ability to fly!");
                    System.out.println("Your body starts to hover and move around in the air. However, you are so shocked that you get distracted while flying.");
                    System.out.println("You accidentally hit a tall rock, which kills you. ");
                    System.out.println("You are dead.");
                    System.out.println("");
                    System.out.println("Ending 3 of 8:");
                    System.out.println("That was berry unexpected");
                    System.out.println("");
                    System.out.println("You can rerun the program to make different decisions on your adventure!");
                    System.out.println("");
                    System.out.println("---The End---");
                    System.out.println("");
                } else if (response.equals("NO")) {
                    System.out.println("");
                    System.out.println("...");
                    System.out.println("");
                    System.out.println("You do not eat any of the berries.");
                    System.out.println("On the rest of your quest, you only see more and more rocks. The chances of finding any source of food, whether it is safe or not, are now extremely slim.");
                    System.out.println("Eventually, while trying to read the treasure map in order to figure out where to go, you simply die of starvation.");
                    System.out.println("You are dead.");
                    System.out.println("");
                    System.out.println("Ending 4 of 8:");
                    System.out.println("Tell my grandkids that I died in battle");
                    System.out.println("");
                    System.out.println("You can rerun the program to make different decisions on your adventure!");
                    System.out.println("");
                    System.out.println("---The End---");
                    System.out.println("");
                } else {
                    System.out.println("The response you entered is invalid. Please manually run the program again.");
                }
            } else {
                System.out.println("The response you entered is invalid. Please manually run the program again.");
            }
        } else if (response.equals("B")) {
            System.out.println("");
            System.out.println("...");
            System.out.println("");
            System.out.println("You sail your ship to island B. Right before the ship safely reaches the island, sudden huge waves crash into your ship!");
            System.out.println("You know you can escape to the island from the ship crash safely while saving one other person or two objects with you.");
            System.out.println("Other than yourself, the most important person to you on this ship is your first mate Dylan.");
            System.out.println("Meanwhile, the two most important objects that you should take with you from this ship are the treasure map and your sword.");
            System.out.println("It's times like these when you wish you wore a belt...");
            System.out.println("");
            System.out.println("Do you save your first mate Dylan or take the treasure map and your sword?");
            System.out.println("");
            System.out.println("Please only enter \"DYLAN\" or \"MAP AND SWORD\" to make your choice:"); // https://stackoverflow.com/questions/3844595/how-can-i-make-java-print-quotes-like-hello#:~:text=print(%22%5C%22Hello%5C,r%22%20and%20%22%5Cn%22
            System.out.println("(Do not include the apostrophes! Your response must be in ALL UPPERCASE)");
            System.out.println("");
            response = keyedInput.nextLine();
            if (response.equals("DYLAN")) {
                System.out.println("");
                System.out.println("...");
                System.out.println("");
                System.out.println("You save Dylan while escaping the ship crash. He's a heavy guy, but for you, he's as light as a feather.");
                System.out.println("Dylan is forever grateful for your kind deed.");
                System.out.println("Together, the two of you try to venture through this island's many mazes of tall trees. Unfortunately, your map has probably dissolved in the sea by now, so the trip is quite confusing.");
                System.out.println("You find a path to follow, which you walk on for some time...");
                System.out.println("...Until you reach a fork in the path.");
                System.out.println("");
                System.out.println("Do you take the path on the left or on the right?");
                System.out.println("");
                System.out.println("Please only enter \"LEFT\" or \"RIGHT\" to make your choice:"); // https://stackoverflow.com/questions/3844595/how-can-i-make-java-print-quotes-like-hello#:~:text=print(%22%5C%22Hello%5C,r%22%20and%20%22%5Cn%22
                System.out.println("(Do not include the apostrophes! Your response must be in ALL UPPERCASE)");
                System.out.println("");
                response = keyedInput.nextLine();
                if (response.equals("LEFT")) {
                    System.out.println("");
                    System.out.println("...");
                    System.out.println("");
                    System.out.println("You choose to walk on the left path.");
                    System.out.println("While walking, you and Dylan are suddenly attacked by five strong tigers!");
                    System.out.println("Neither you nor Dylan were prepared for a fight, so you both die.");
                    System.out.println("You are dead.");
                    System.out.println("");
                    System.out.println("Ending 5 of 8:");
                    System.out.println("The road not taken");
                    System.out.println("");
                    System.out.println("You can rerun the program to make different decisions on your adventure!");
                    System.out.println("");
                    System.out.println("---The End---");
                    System.out.println("");
                } else if (response.equals("RIGHT")) {
                    System.out.println("");
                    System.out.println("...");
                    System.out.println("");
                    System.out.println("You choose to walk on the right path.");
                    System.out.println("You and Dylan walk for a long time...");
                    System.out.println("...Until you find a random treasure chest resting on the ground in front of you!");
                    System.out.println("The chest seems to be unopened and looks as if it was left behind by someone who dragged it here previously.");
                    System.out.println("It's not buried treasure, but it's a lucky find. It'll do.");
                    System.out.println("You and Dylan celebrate finding this treasure!");
                    System.out.println("");
                    System.out.println("This treasure quest seems to be over and successful, but your new challenge to survive on this island or to find a way to get off is only starting to begin.");
                    System.out.println("");
                    System.out.println("Ending 6 of 8:");
                    System.out.println("Happily ever after... for now");
                    System.out.println("");
                    System.out.println("You can rerun the program to make different decisions on your adventure!");
                    System.out.println("");
                    System.out.println("---The End---");
                    System.out.println("");
                } else {
                    System.out.println("The response you entered is invalid. Please manually run the program again.");
                }
            } else if (response.equals("MAP AND SWORD")) {
                System.out.println("");
                System.out.println("...");
                System.out.println("");
                System.out.println("You save your treasure map and your sword while safely escaping the ship crash. You don't look back.");
                System.out.println("On the island, you easily navigate your way with the map to the supposed site of the buried treasure: a cave.");
                System.out.println("In front of the entrance to the cave, there is a wolf that appears to be searching for food. It roams around the area, slowly...");
                System.out.println("");
                System.out.println("Do you fight the wolf or wait for it to leave?");
                System.out.println("");
                System.out.println("Please only enter \"FIGHT\" or \"WAIT\" to make your choice:"); // https://stackoverflow.com/questions/3844595/how-can-i-make-java-print-quotes-like-hello#:~:text=print(%22%5C%22Hello%5C,r%22%20and%20%22%5Cn%22
                System.out.println("(Do not include the apostrophes! Your response must be in ALL UPPERCASE)");
                System.out.println("");
                response = keyedInput.nextLine();
                if (response.equals("FIGHT")) {
                    System.out.println("");
                    System.out.println("...");
                    System.out.println("");
                    System.out.println("You want to fight the wolf. You charge, yelling your pirate heart out!");
                    System.out.println("Unfortunately for you, you are more tired from your adventure at this point than you realize, so your sword feels to be much heavier than it usually is.");
                    System.out.println("As a result, your ability to wield your sword has diminished greatly. You do not put up a good fight against the hungry wolf.");
                    System.out.println("With a loud howl, the wolf kills you.");
                    System.out.println("You are dead.");
                    System.out.println("");
                    System.out.println("Ending 7 of 8:");
                    System.out.println("Should've used your pirate brain");
                    System.out.println("");
                    System.out.println("You can rerun the program to make different decisions on your adventure!");
                    System.out.println("");
                    System.out.println("---The End---");
                    System.out.println("");
                } else if (response.equals("WAIT")) {
                    System.out.println("");
                    System.out.println("...");
                    System.out.println("");
                    System.out.println("You hide nearby and plan to wait until the wolf leaves the area.");
                    System.out.println("Hours and hours pass by...");
                    System.out.println("...Until the wolf finally walks away! Hooray!");
                    System.out.println("However, before you can even move to enter the cave, Dylan appears out of nowhere!");
                    System.out.println("He seems to have somehow survived the ship crash, and he is raging with fury because of your treachery!");
                    System.out.println("Dylan attacks you as an act of revenge!");
                    System.out.println("He wields two sharp swords while you only have one. This advantage allows him to kill you, against your best wishes.");
                    System.out.println("You are dead.");
                    System.out.println("");
                    System.out.println("Ending 8 of 8:");
                    System.out.println("Materialistic man");
                    System.out.println("");
                    System.out.println("You can rerun the program to make different decisions on your adventure!");
                    System.out.println("");
                    System.out.println("---The End---");
                    System.out.println("");
                } else {
                    System.out.println("The response you entered is invalid. Please manually run the program again.");
                }
            } else {
                System.out.println("The response you entered is invalid. Please manually run the program again.");
            }
        } else {
            System.out.println("The response you entered is invalid. Please manually run the program again.");
        }

        keyedInput.close(); // src: vmso during class  

    }

}
