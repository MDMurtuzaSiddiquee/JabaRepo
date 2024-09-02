package jabaTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import resources.Base;

public class Test1 extends Base{
	

	public static void main(String[] args) throws IOException {
		
		Properties prop= new Properties();
		
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		
		FileInputStream File =new FileInputStream(propPath);
		
		prop.load(File);
		
		// Get the set of property names (keys)
        Set<String> keys = prop.stringPropertyNames();
        
        // Convert Set to an array for indexed access
        String[] keyArray = keys.toArray(new String[0]);
        
//        System.out.println(keyArray);
        
        List<String> filterAddTask = new ArrayList<>();
        List<String> filterDate = new ArrayList<>();
        List<String> filterPlatform = new ArrayList<>();
        List<String> filterSocialMedia = new ArrayList<>();

        
//        System.out.println(filteredWords);
        
//        String noofTask = prop.getProperty("taskNum");
        

        // Loop through the array and filter strings containing "a"
        for (String word : keyArray) {
            if (word.contains("addNewTask")) {
                filterAddTask.add(word);
            }
            if (word.contains("taskDate")) {
            	filterDate.add(word);
            }
            
            if (word.contains("platform")) {
            	filterPlatform.add(word);
            }
            if (word.contains("socialMedia")) {
            	filterSocialMedia.add(word);
            }
               
        }
        
        
        // Convert List back to Array if needed
        String[] taskArray = filterAddTask.toArray(new String[0]);
        Arrays.sort(taskArray);
        
        String[] dateArray = filterDate.toArray(new String[0]);
        Arrays.sort(dateArray);
        
        String[] platformArray = filterPlatform.toArray(new String[0]);
        Arrays.sort(platformArray);
        
        String[] socialMediaArray = filterSocialMedia.toArray(new String[0]);
        Arrays.sort(socialMediaArray);

        
//        System.out.println(fArray);
        
        int taskN = taskArray.length;


        for (int i = 0; i < taskN; i++) {
            String key = taskArray[i];
            String value = prop.getProperty(key);

            System.out.println(key + " = " + value);
            System.out.println("hii");
            
        }
	}

}
