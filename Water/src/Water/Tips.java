package Water;

import java.util.ArrayList;

//this class will contain a selection of tips
public class Tips {

	ArrayList <String> listOfTips;
	int maxNumberOfTips = 21;
	
	public Tips(){
		
		listOfTips = new ArrayList<String>();
		for(int i = 0; i < maxNumberOfTips; i++){
			
			//this should not display i as the level of water, I will fix it once we have the
			//calculations for converting water to bottle index.
			listOfTips.add("You have used " + i + " level of water.");
			
		}
		
	}
	
	//return the tip according to the bottle level. I think this should somehow be changed to water level.
	public String getTip(int index){
		
		return listOfTips.get(index);
		
	}
	
}
