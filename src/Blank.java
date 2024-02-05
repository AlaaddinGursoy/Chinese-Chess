public class Blank extends Item{

    public Blank() {
        color="blank";
    }

    @Override
    public String toString() {
        return "-";
    }

    @Override
    public void move(String destination) {
        return;
    }

}
