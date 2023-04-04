package Coding;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;





public class Song_play 
{
	private static final int MAX = 3;
	Map<String, Map<String, Integer>> song_count = new HashMap <String, Map<String, Integer>>();

    public void play(String username, String songname){
        System.out.println("UserName :" + username + " --->Song :" + songname);
        //Increment the count for song played in the song_count hashmap

        //first check if contains username key
        Map tempMap = song_count.get(username);
        if(song_count.containsKey(username))
        {
            if(tempMap.containsKey(songname)) 
            {
                int new_count = (int) tempMap.get(songname) + 1;
                tempMap.put(songname, new_count);
            }
            else
            { 
                if(tempMap.size() >= MAX) 
                {
                    
					Object key = Collections.min(tempMap.entrySet(), Map.Entry.comparingByValue()).getKey();
					tempMap.remove(key);
					tempMap.put(songname, 1);
                }
                else {
                	tempMap.put(songname,1);
                	}
                
            }
        }
        else
        {
            song_count.put(username, tempMap = new HashMap<>());
            song_count.get(username).put(songname, 1);
        }
    }
    
    

    public void print(){
        for(Map.Entry <String, Map <String, Integer>> t :this.song_count.entrySet()){
            String user = t.getKey();
            for (Map.Entry<String,Integer> e : t.getValue().entrySet())
                System.out.println("OuterKey:" + user + " InnerKey: " + e.getKey()+ " VALUE:" +e.getValue());
        }
    }
    
    public static void main(String[] args) 
    {
    	Song_play obj = new Song_play();
    	obj.play("Shre", "s1");
    	obj.play("Shre", "s2");
    	obj.play("Shre", "s1");
    	obj.play("Shre", "s3");
    	obj.play("Shre", "s4");
    	obj.print();
	}
    
}


