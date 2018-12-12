import java.util.List;

/**
 * Created by Noah on 12/10/2015.
 */
public interface Node {

    public void addChild(Node n);

    public String getName();

    public List<Node> getChildren();
}
