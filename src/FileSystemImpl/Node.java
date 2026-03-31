package FileSystemImpl;

import java.util.HashMap;
import java.util.Map;

public class Node {
    String name;
    boolean isFile;
    Map<String, Node> children;
    String content;
    Node parent;
    Node(String name){
        this.name = name;
        this.isFile= false;
        this.children = new HashMap<>();
        this.content = "";
        this.parent = null;
    }
}
