package InterfacesAbstractInnerClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Player tim = new Player("Tim",12,2);
        Monster monster = new Monster("Yeti",10,3);
        fight(tim, monster);



        System.out.println(tim);
        System.out.println(monster);

    }

    private static void fight(Player player, Monster monster) {
        player.setHitPoints(player.getHitPoints()- monster.getStrength());
        monster.setHitPoints(monster.getHitPoints()-player.getStrength());
        saveObject(player);
        saveObject(monster);
    }


    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to create new player\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    String stringInput;
                    for(int i=0;i<4;i++){
                        switch(i){
                            case 0:
                                System.out.print("Enter new name: ");
                                stringInput = scanner.nextLine();
                                values.add(index, stringInput);
                                index++;
                                break;

                            case 1:
                                System.out.print("Enter new hitPoints: ");
                                stringInput = scanner.nextLine();
                                values.add(index, stringInput);
                                index++;
                                break;

                            case 2:
                                System.out.print("Enter new strength: ");
                                stringInput = scanner.nextLine();
                                values.add(index, stringInput);
                                index++;
                                break;

                            case 3:
                                System.out.print("Enter new weapon's name: ");
                                stringInput = scanner.nextLine();
                                values.add(index, stringInput);
                                index++;
                                break;
                        }
                    }

                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave){
        for(int i=0;i<objectToSave.write().size();i++){
            System.out.println("Saving "+objectToSave.write().get(i) + " to storage device");
        }

    }

    public static void loadObject(ISaveable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }


}
