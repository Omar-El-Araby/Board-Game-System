import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class characterSheet implements Sheet {
    private String playerName;
    private int AC = 13;
    private Hashtable<String, JSONObject> Stats;
    private Integer[] valueStoredForStat= new Integer[Main_Stats.length];
    private Integer[] statMod = new Integer[Main_Stats.length];
    private Integer playerLevel;
    String currentFileLocation;
    public characterSheet(){}
    public characterSheet (String playerName,Integer[] Stat_Value,Integer playerLevel, String currentFileLocation){
        this.playerName=playerName;
        this.playerLevel=playerLevel;
        valueStoredForStat=Stat_Value;
        this.currentFileLocation = currentFileLocation;
        store();
    }
    @Override
    public void store() {
        try {

            JSONObject States = new JSONObject();
            File file = new File(currentFileLocation);
            if (!file.exists())
                file.createNewFile();
            writeData.put("playerName", playerName);
            writeData.put("Level", playerLevel);
            for (int i = 0; i < Main_Stats.length ; i++) {
                System.out.println(Main_Stats[i] + "  " + valueStoredForStat[i]);
                States.put(Main_Stats[i], valueStoredForStat[i]);
                statMod[i] = setMod(valueStoredForStat[i]);
            }
            writeData.put("Stats", States);
            FileWriter x = new FileWriter(currentFileLocation);
            x.write(writeData.toString());
            x.flush();
        }
        catch (IOException e){
            System.out.println("File not Found.");
        }
    }
    @Override
    public void read() throws Exception {
        String File = new String(Files.readAllBytes(Paths.get("charactersheet.json")));
        JSONObject temp = new JSONObject(File);
        playerName=temp.getString("playerName");
        playerLevel=temp.getInt("Level");
        JSONObject t =temp.getJSONObject("Stats");
        for(int i=0;i<valueStoredForStat.length;i++)
            valueStoredForStat[i]=t.getInt(Main_Stats[i]);

    }

    public static void main(String[] args) throws Exception {
        characterSheet pl = new characterSheet("Dragonborn",new Integer[]{3,4,8,5,1,100},1,"src/stats/charactersheet.json");
        System.out.println(pl.getStatMod()[0]);
        characterSheet temp = new characterSheet();
    }
    public void update()
    {

    }
    public void print()
    {
        System.out.println("Name: "+getPlayerName());
        System.out.println("Level: "+getPlayerLevel());
        Integer[] sta=getStats();
        for(int i=0;i<sta.length;i++)
            System.out.println(Main_Stats[i]+" "+sta[i]);
    }
    private int setMod(int stat){
        return  (int)Math.floor(stat/2 -5);
    }

    public Integer[] getStatMod() {
        return statMod;
    }
    public int getHP(){
        return valueStoredForStat[5];
    }
    public void changeHP(int n){
        valueStoredForStat[5] += n;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public Integer[] getStats() {
        return valueStoredForStat;
    }

    public void setStats(String stats) {
    }

    public Integer getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(Integer playerLevel) {
        this.playerLevel = playerLevel;
    }
}
