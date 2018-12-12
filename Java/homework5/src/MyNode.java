import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noah on 12/10/2015.
 */
public class MyNode implements Node {

    private List<Node> children;
    private List<Node> parents;
    private String name;

    public MyNode(String name){
        this.name=name;
        this.children=new ArrayList<>();
        this.parents=new ArrayList<>();
    }

    @Override
    public void addChild(Node n) {
        this.children.add(n);
        ((MyNode)n).addParent(this);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Node> getChildren() {
        return this.children;
    }

    public List<Node> getParents(){
        return this.parents;
    }

    public void addParent(Node parent){
        this.parents.add(parent);
    }
}
