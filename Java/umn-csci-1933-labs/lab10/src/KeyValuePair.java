import java.security.Key;

/**
 * Created by chen3736 on 11/17/15.
 */
public class KeyValuePair {


    public KeyValuePair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    String key = new String();
    String value = new String();

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }


    public String toString(){
        return this.getKey();
    }



    }





