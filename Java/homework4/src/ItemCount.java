/**
 * Created by Noah on 11/30/2015.
 */
public class ItemCount implements Comparable<ItemCount>{
    private Object o;
    private int i;
    public ItemCount(Object o,int i){
        this.o=o;
        this.i=i;
    }
    public Object getObject(){
        return this.o;
    }
    public int getCount(){
        return this.i;
    }

    @Override
    public int compareTo(ItemCount o) {
        return new Integer(this.getCount()).compareTo(new Integer(o.getCount()))*-1;
    }
    @Override
    public String toString(){
        return this.getObject().toString()+"\t"+this.getCount();
    }

}
