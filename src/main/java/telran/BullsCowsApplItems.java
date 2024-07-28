package telran;

import java.util.ArrayList;
import java.util.List;

public class BullsCowsApplItems {
	 public static List<String> getItems(BullsCowsService bullsCows) {
	        List<String> items = new ArrayList<>();
	        items.add("Start New Game");
	        items.add("Show Results");
	        items.add("Exit");
	        return items;
	    }
	}
