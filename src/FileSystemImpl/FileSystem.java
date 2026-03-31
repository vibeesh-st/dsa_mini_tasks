package FileSystemImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSystem {
    Node root;

    public FileSystem(){
        root = new Node("/");
    }

    private Node traverse(String path){
        String[] parts = path.split("/");
        Node current = root;

        for(String part: parts){
            if(part.equals("")) continue;

            if(!current.children.containsKey(part)){
                return null;
            }
            current= current.children.get(part);
        }
        return current;
    }

    private Node traverseAndCreate(String path){
        String[] parts = path.split("/");
        Node current = root;

        for(String part: parts){
            if(part.equals("")) continue;

            if(!current.children.containsKey(part)){
                Node newNode = new Node(part);
                newNode.parent = current;
                current.children.put(part,newNode);
            }
            current = current.children.get(part);
        }
        return current;
    }

    public void mkdir(String path){
        traverseAndCreate(path);
    }

    public void addFile(String path, String content) {
        Node node = traverseAndCreate(path);
        node.isFile = true;
        node.content += content;
    }
    public String readFile(String path) {

        Node node = traverse(path);
        if (node == null) {
            throw new RuntimeException("Path not found");
        }
        return node.content;
    }


    public List<String> ls(String path){
        Node node = traverse(path);
        if (node == null) {
            throw new RuntimeException("Path not found");
        }
        List<String> result =new ArrayList<>();

        if(node.isFile){
            result.add(node.name);
        }
        else{
            result.addAll(node.children.keySet());
        }
        Collections.sort(result);
        return result;
    }



}
