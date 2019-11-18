import org.w3c.dom.Document
import org.w3c.dom.Node
import org.xml.sax.InputSource
import java.io.File
import java.io.StringReader


import javax.xml.parsers.DocumentBuilderFactory


fun main() {
    val xmlComputation = XmlComputation()
    val player =  xmlComputation.mapPlayer(xmlComputation.parseXml())
    println(player)
}


