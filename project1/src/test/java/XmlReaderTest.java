import org.junit.Assert;
import org.junit.Test;

public class XmlReaderTest {

    @Test
    public void testXmlReader(){

        Player testPlayer = new Player(1, "Marouan Boukli", 5);
        Player xmlPlayer = XmlReader.xmlReader();
        System.out.println(xmlPlayer.getId()+" "+xmlPlayer.getName()+" "+xmlPlayer.getGoals());
        Assert.assertEquals(xmlPlayer.getName(), testPlayer.getName());
        Assert.assertEquals(xmlPlayer.getGoals(), testPlayer.getGoals());
    }
}
