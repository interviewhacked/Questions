import java.util.Map;
import java.util.Map.Entry;

//Or there can be different subclasses of XMLNode such as class/text
enum NodeType {
	DIV, BLOCK, TEXT
}

class XMLNode {
	NodeType type;
	XMLNode[] children;
	Map<String, String> properties;

	@Override
	public String toString() {

		if (type == NodeType.TEXT) {
			return properties.get("TEXT");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("< " + type.toString());
		for (Entry<String, String> property : properties.entrySet()) {
			sb.append(" " + property.getKey() + "=" + "\\" + property.getValue() + "\\");
		}
		sb.append(">");
		for (XMLNode node : children) {
			sb.append(node.toString());
		}
		sb.append("</" + type.toString() + ">");

		return sb.toString();
	}
}

public class XMLModeler {
	String serialize(XMLNode root) {
		return root.toString();
	}
}
