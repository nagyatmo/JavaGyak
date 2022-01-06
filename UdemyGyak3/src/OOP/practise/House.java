package OOP.practise;

public class House {
    private String address;
    private Room room;

    public House(String address, Room room) {
        this.address = address;
        this.room = room;
    }

    public String getAddress() {
        return address;
    }

    public Room getRoom() {
        return room;
    }

    public void enterRoom(){
        room.enterRoom();
    }
}
