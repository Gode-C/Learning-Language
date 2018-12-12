import java.util.ArrayList;

/**
 * Created by Noah on 12/10/2015.
 */
public class Main {
    public static void main(String[] args){
        MyNode math=new MyNode("Mathematics");
        MyNode applied=new MyNode("Applied Mathematics");
        math.addChild(applied);
        MyNode crypto=new MyNode("Cryptography");
        applied.addChild(crypto);
        MyNode finance=new MyNode("Mathematical Finance");
        applied.addChild(finance);

        MyNode fields=new MyNode("Fields of Mathematics");
        math.addChild(fields);
        MyNode alg=new MyNode("Algebra");
        fields.addChild(alg);
        MyNode calc=new MyNode("Calculus");
        fields.addChild(calc);
        MyNode diff=new MyNode("Differential Calculus");
        calc.addChild(diff);

        MyNode concepts=new MyNode("Mathematical Concepts");
        math.addChild(concepts);
        MyNode algor=new MyNode("Algorithms");
        concepts.addChild(algor);
        MyNode relate=new MyNode("Mathematical Relations");
        concepts.addChild(relate);

        MyTree mathematics=new MyTree(math);
        mathematics.preorderDfsTraverseRecursive();
        System.out.println("---------------------------------------------------");
        mathematics.transferBfs();
        System.out.println("---------------------------------------------------");
        System.out.println(mathematics.getBranchingFactor());
        System.out.println("---------------------------------------------------");
        System.out.println(mathematics.isBinaryTree());

        System.out.println("---------------------------------------------------");


        MyNode grandp1 = new MyNode("Zonglian Chen");
        MyNode grandp2 = new MyNode("Cyrus GrandMa");
        MyNode grandp3 = new MyNode("Jianmin Wang");
        MyNode grandp4 = new MyNode("Shumin Bi");
        MyNode gu1 = new MyNode("Yan Chen");
        MyNode fu1 = new MyNode("Ming Huang");
        MyNode dad = new MyNode("Mei Chen");
        MyNode ma = new MyNode("Huaizhong Wang");
        MyNode eryi = new MyNode("Huaiqing Wang");
        MyNode sanyi = new MyNode("Huaixiang Wang");
        MyNode xiaojiu = new MyNode("Huainng Wang");
        MyNode eryifu = new MyNode("Yujin Liu");
        MyNode sanyifu = new MyNode("Zijie Shi");
        MyNode jiuma = new MyNode("Lily Cui");
        MyNode eryibaby = new MyNode("Zheng Liu");
        MyNode sanyibaby = new MyNode("Wen Shi");
        MyNode xiaojiubaby = new MyNode("Zilu Wang");
        MyNode gubaby = new MyNode("RuiqiHuang");
        MyNode myself = new MyNode("Cyrus Chen");
        grandp1.addChild(gu1);
        grandp2.addChild(gu1);
        grandp1.addChild(dad);
        grandp2.addChild(dad);
        grandp3.addChild(ma);
        grandp3.addChild(eryi);
        grandp3.addChild(sanyi);
        grandp3.addChild(xiaojiu);
        grandp4.addChild(ma);
        grandp4.addChild(eryi);
        grandp4.addChild(sanyi);
        grandp4.addChild(xiaojiu);
        gu1.addChild(gubaby);
        fu1.addChild(gubaby);
        eryi.addChild(eryibaby);
        eryifu.addChild(eryibaby);
        sanyi.addChild(sanyibaby);
        sanyifu.addChild(sanyibaby);
        xiaojiu.addChild(xiaojiubaby);
        jiuma.addChild(xiaojiubaby);
        dad.addChild(myself);
        ma.addChild(myself);
        ArrayList<Node> cyrusgrandp = new ArrayList<>();
        cyrusgrandp.add(grandp1);
        cyrusgrandp.add(grandp2);
        cyrusgrandp.add(grandp3);
        cyrusgrandp.add(grandp4);
        Graph cyrusFamilyTree = new Graph(cyrusgrandp);
        cyrusFamilyTree.transferBfs();

        System.out.println("");

        MyNode obed=new MyNode("Obed");
        MyNode violet=new MyNode("Violet");
        MyNode robert=new MyNode("Robert");
        MyNode joe=new MyNode("Joe");
        MyNode bill=new MyNode("Bill");
        MyNode marsha=new MyNode("Marsha");
        MyNode dave=new MyNode("Dave");
        MyNode kathy=new MyNode("Kathy");
        MyNode steve=new MyNode("Steve");
        MyNode jodi=new MyNode("Jodi");
        MyNode bob=new MyNode("Bob");
        MyNode molly=new MyNode("Molly");
        MyNode marty=new MyNode("Marty");
        MyNode casey=new MyNode("Casey");
        MyNode jayna=new MyNode("Jayna");
        MyNode eva=new MyNode("Eva");
        MyNode noah=new MyNode("Noah");
        MyNode michael=new MyNode("Michael");
        MyNode christina=new MyNode("Christina");
        MyNode julia=new MyNode("Julia");
        MyNode maretta=new MyNode("Maretta");
        MyNode jason=new MyNode("Jason");
        MyNode jen=new MyNode("Jen");
        MyNode sarah=new MyNode("Sarah");
        MyNode jesse=new MyNode("Jesse");
        MyNode sophie=new MyNode("Sophie");
        MyNode maisie=new MyNode("Maisie");
        MyNode aidan=new MyNode("Aidan");
        MyNode taylor=new MyNode("Taylor");
        MyNode kohl=new MyNode("Kohl");
        MyNode kaylee=new MyNode("Kaylee");
        MyNode rob=new MyNode("Rob");
        ArrayList<Node> noahgrandparents=new ArrayList<>();
        noahgrandparents.add(obed);
        noahgrandparents.add(violet);
        noahgrandparents.add(robert);
        noahgrandparents.add(joe);
        obed.addChild(marsha);
        obed.addChild(dave);
        obed.addChild(steve);
        violet.addChild(marsha);
        violet.addChild(dave);
        violet.addChild(steve);
        marsha.addChild(jason);
        marsha.addChild(sarah);
        jason.addChild(aidan);
        sarah.addChild(taylor);
        sarah.addChild(kohl);
        sarah.addChild(kaylee);
        jen.addChild(aidan);
        jesse.addChild(taylor);
        jesse.addChild(kohl);
        jesse.addChild(kaylee);
        bill.addChild(jason);
        bill.addChild(sarah);
        dave.addChild(maretta);
        dave.addChild(julia);
        dave.addChild(christina);
        dave.addChild(michael);
        kathy.addChild(maretta);
        kathy.addChild(julia);
        kathy.addChild(christina);
        kathy.addChild(michael);
        steve.addChild(noah);
        steve.addChild(eva);
        jodi.addChild(noah);
        jodi.addChild(eva);
        jodi.addChild(jayna);
        jayna.addChild(sophie);
        jayna.addChild(maisie);
        rob.addChild(sophie);
        rob.addChild(maisie);
        robert.addChild(jodi);
        robert.addChild(bob);
        robert.addChild(molly);
        robert.addChild(marty);
        joe.addChild(jodi);
        joe.addChild(bob);
        joe.addChild(molly);
        joe.addChild(marty);
        marty.addChild(casey);
        Graph noahFamilyTree=new Graph(noahgrandparents);
        noahFamilyTree.transferBfs();








    }
}
