import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class main_collection {
    public String strCurrentLine;
    public Integer key;
    public String value;
    public long startTime;
    public long endTime;
    public long timeElapsed;
    public Integer[] keys = {60855,1,29712,60857};

    public HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
    public TreeMap<Integer, String> tree_map = new TreeMap<Integer, String>();
    public LinkedHashMap<Integer,String> link_Hash=new LinkedHashMap<Integer,String>();


    BufferedReader objReader = null;

    public static void main(String[] args) throws IOException {
        // do something here...
        main_collection collection = new main_collection();
        collection.readFileFromPath("D:\\kmut\\datasci\\sale.txt");
        collection.collectput();
        for (int i = 0; i <= collection.keys.length - 1; i++) {
            collection.collectget(collection.keys[i]);
        }

    }

    public void readFileFromPath(String file_name) {
        try {
            this.objReader = new BufferedReader(new FileReader(file_name));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void collectput() throws IOException {
        while ((this.strCurrentLine = this.objReader.readLine()) != null) {
            this.value = "";
            this.strCurrentLine = this.strCurrentLine.replaceAll("[()]|;|'", "");
            String[] arrB = this.strCurrentLine.split(",");
            for (int i = 1; i <= arrB.length - 1; i++) {
                this.value = this.value + " " + arrB[i];
            }
            this.key = Integer.parseInt(arrB[0]);
            hash_map.put(this.key, this.value);
            tree_map.put(this.key, this.value);
            link_Hash.put(this.key, this.value);
        }
    }

    public void collectget(int Getkey){
        //link_Hash
        System.out.println("-------------------Getkey:"+Getkey+"-------------------");
        this.startTime = System.nanoTime();
        System.out.print("[link_Hash]  "+this.link_Hash.get(Getkey));
        this.endTime = System.nanoTime();
        this.timeElapsed = this.endTime - this.startTime;
        System.out.println(" {time usage: "+this.timeElapsed+" nano time}");

        //hashmap get
        this.startTime = System.nanoTime();
        System.out.print("[hashmap ] "+this.hash_map.get(Getkey));
        this.endTime = System.nanoTime();
        this.timeElapsed = this.endTime - this.startTime;
        System.out.println(" {time usage: "+this.timeElapsed+" nano time}");

        //tree get
        this.startTime = System.nanoTime();
        System.out.print("[tree map ] "+this.tree_map.get(Getkey));
        this.endTime = System.nanoTime();
        this.timeElapsed = this.endTime - this.startTime;
        System.out.println(" {time usage: "+this.timeElapsed+" nano time}");
        System.out.println("_______________________________________________");
    }

}
