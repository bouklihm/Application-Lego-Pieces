import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlReader {
    public static Player xmlReader(){
        Player player = new Player();
        try {
            File file = new File("src/main/resources/player.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Player.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            player=(Player) jaxbUnmarshaller.unmarshal(file);
            System.out.println(player.getId()+" "+player.getName()+" "+player.getGoals());
        } catch (JAXBException e) {e.printStackTrace(); }
        return player;
    }
}
