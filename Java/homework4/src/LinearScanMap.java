import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Noah on 11/30/2015.
 */
public class LinearScanMap<K,V> extends AbstractMap<K,V> {
    private Set<Entry<K,V>> storeentries;
    public LinearScanMap(){
        this.storeentries = new HashSet<>();

    }

    @Override
    public boolean containsKey(Object key) {
        if (storeentries.isEmpty()){
            return false;
        }
        for (Entry cur : storeentries) {
            if (cur.getKey() == (K)key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {

        V myvalue = null;

        for (Entry cur : storeentries) {
            if (cur.getKey() == key) {
                myvalue = (V) cur.getValue();
            }
        }
        return myvalue;
    }



    @Override
    public V put(K key, V value) {


        Object myvalue = null;

        for (Entry cur : storeentries) {
            if (cur.getKey() == key) {
                myvalue = cur.getValue();
                cur.setValue(value);
            }
        }


        if (myvalue==null){
                Entry<K,V> newentry = new AbstractMap.SimpleEntry<>(key, value);
                storeentries.add(newentry);
            }

        return (V)myvalue;
    }



    @Override
    public Set<Entry<K, V>> entrySet() {
        return storeentries;

    }

}
