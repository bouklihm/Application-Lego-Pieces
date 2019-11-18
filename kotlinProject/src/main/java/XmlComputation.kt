import org.w3c.dom.Document
import org.w3c.dom.Node
import org.xml.sax.InputSource
import java.io.File
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory

class XmlComputation {
    fun readXml(): Document {
        val xmlFile = File("src/main/resources/player.xml")

        val dbFactory = DocumentBuilderFactory.newInstance()
        val dBuilder = dbFactory.newDocumentBuilder()
        val xmlInput = InputSource(StringReader(xmlFile.readText()))
        return dBuilder.parse(xmlInput)
    }


    // goal: get id, name and goals
// constraint: do not use xpath or any 'elementByName'
// constraint: implementation must visit XML nodes
// constraint: stick to Java XML facility
    fun parseXml(): MutableMap<String, String> {
        val document = readXml()
        val playerData = mutableMapOf<String, String>()
        return keepGoingDeep(document, playerData)
    }

    fun keepGoingDeep(node: Node, playerData: MutableMap<String, String>): MutableMap<String, String>{
        val tags = getTags(node)
                .filter { it.nodeType != Node.TEXT_NODE }
                .filter { it.nodeType != Node.COMMENT_NODE }

        if (tags.isNotEmpty()) {
            tags.forEach { child ->
                if (child.attributes.item(0) != null) playerData["id"] = child.attributes.item(0).nodeValue
                keepGoingDeep(child, playerData)
            }
        } else {
            playerData[node.nodeName] = node.textContent
        }
        return playerData
    }

    fun getTags(node: Node): List<Node>  =
            if (node.hasChildNodes())  (0 until node.childNodes.length).map { index -> node.childNodes.item(index) } else emptyList()

    fun mapPlayer(playerData: MutableMap<String, String>): Player {
        var newPlayer = Player()
        newPlayer.id = playerData["id"]?.toInt()
        newPlayer.name = playerData["name"]
        newPlayer.goals = playerData["goals"]?.toInt()

        return newPlayer
    }
}
