import org.junit.Assert;
import org.junit.Test;

public class XmlReaderTest {

    @Test
    public void testXmlReader(){

        Player testPlayer = new Player(1, "Marouan Boukli", 5);
        Assert.assertEquals(XmlReader.xmlReader(), testPlayer);
    }
}
