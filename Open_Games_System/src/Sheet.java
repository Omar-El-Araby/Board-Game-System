import org.json.JSONObject;

import java.util.Hashtable;

public interface Sheet {
    String[] Main_Stats={"Str","Dex","Con","Int","Wis","HP"};
    Hashtable<String,Integer> Stats= new Hashtable<>();
    Integer[] defaultValues={0,0,0,0,0,0};
    JSONObject writeData = new JSONObject();
    void read() throws Exception ;
    void store() throws Exception;
    void update();
}
