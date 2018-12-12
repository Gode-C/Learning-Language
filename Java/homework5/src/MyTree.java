import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Noah on 12/10/2015.
 */
public class MyTree implements Tree {

    private Node root;

    public MyTree(Node root){
        this.root=root;
    }

    @Override
    public void transferBfs() {
        Queue<Node> queue=new LinkedList<>();
        queue.add(this.root);
        while(queue.size()!=0){
            for(Node curNode:queue.peek().getChildren()){
                queue.add(curNode);
            }
            System.out.println(queue.peek().getName());
            queue.remove();
        }
    }

    @Override
    public Double getBranchingFactor() {
        Queue<Node> queue=new LinkedList<>();
        queue.add(this.root);
        Double numChildren=0.0;
        int numNodes=0;
        while(queue.size()!=0){
            for(Node curNode:queue.peek().getChildren()){
                queue.add(curNode);
            }
            if(queue.peek().getChildren().size()!=0){
            numNodes++;
            numChildren+=queue.peek().getChildren().size();}
            queue.remove();
        }

        return numChildren/numNodes;
    }

    @Override
    public boolean isBinaryTree() {
        Queue<Node> queue=new LinkedList<>();
        queue.add(this.root);
        boolean isBinary=true;
        while(queue.size()!=0 & isBinary){
            for(Node curNode:queue.peek().getChildren()){
                queue.add(curNode);
            }
            if(queue.peek().getChildren().size()>2){
                isBinary=false;
            }
            queue.remove();
        }
        return isBinary;
    }

    public class PrintTraverseOperation implements TraverseOperation{

        public PrintTraverseOperation(){};
        @Override
        public void traverseOp(int depth,Node n) {
            String indentation="";
            for(int i=0;i<depth;i++){
                indentation+="\t";
            }
            System.out.println(indentation+n.getName());
            if(n.getChildren().size()!=0){
                for(Node curChild:n.getChildren()){
                    traverseOp(depth+1,curChild);
                }
            }
        }
    }
    @Override
    public void preorderDfsTraverseRecursive() {
        PrintTraverseOperation print=new PrintTraverseOperation();
        print.traverseOp(0,this.root);
    }

}
