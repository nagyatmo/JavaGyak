package OOP.practise;

public class main {
    public static void main(String[] args){
        Room haloSzoba = new Room(20,true);
        House newHouse = new House("Deak Ferenc utca 31", haloSzoba);
        newHouse.enterRoom();
        System.out.println(newHouse.getRoom().getArea());
    }
}
