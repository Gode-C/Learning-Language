

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Noah on 12/10/2015.
 */
public class Graph {

    public ArrayList<Node> grandparents;

    public Graph(ArrayList<Node> grandparents) {
        this.grandparents = grandparents;
    }

    public void transferBfs() {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> printed = new ArrayList<>();
        for (Node grandparent : this.grandparents) {
            queue.add(grandparent);
            printed.add(grandparent);
        }
        while (queue.size() != 0) {
            for(Node currrrNode:((MyNode)queue.peek()).getParents()){
                if(!printed.contains(currrrNode)){
                    queue.add(currrrNode);
                    printed.add(currrrNode);
                }
            }
            for (int i = 0; i < queue.peek().getChildren().size(); i++) {
                Node curNode = queue.peek().getChildren().get(i);
                if (!printed.contains(curNode)) {
                    queue.add(curNode);
                    printed.add(curNode);
                }
            }

            String children = "";
            for (int i=0;i<queue.peek().getChildren().size();i++) {
                Node currNode=queue.peek().getChildren().get(i);
                children += currNode.getName();
                if (queue.peek().getChildren().indexOf(currNode) != queue.peek().getChildren().size() - 1) {
                    children += ",";
                } else {
                    children += ".\n";
                }
            }
            if(children==""){
                children+="none\n";
            }
            if (((MyNode) queue.peek()).getParents().size() == 2) {


                System.out.format("%s is the child of %s and %s and has the following children: %s",
                        queue.peek().getName(), ((MyNode) queue.peek()).getParents().get(0).getName(), ((MyNode) queue.peek()).getParents().get(1).getName(), children);
            }
            else if(((MyNode) queue.peek()).getParents().size() == 1){
                System.out.format("%s is the child of %s and has the following children: %s",
                        queue.peek().getName(), ((MyNode) queue.peek()).getParents().get(0).getName(),children);
            }
            else {
                if(this.grandparents.contains(queue.peek())) {
                    System.out.format("%s is a grandparent, has the following children: %s",
                            queue.peek().getName(), children);
                }
                else{
                    System.out.format("%s has the following children: %s",
                            queue.peek().getName(), children);
                }
            }
            queue.remove();


        }
    }
}
