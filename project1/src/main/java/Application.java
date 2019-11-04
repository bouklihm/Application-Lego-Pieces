

public class Application {
    public static void main(String[] args) {
        Player player = XmlReader.xmlReader();
        System.out.println(player.getId()+" "+player.getName()+" "+player.getGoals());
    }
}
