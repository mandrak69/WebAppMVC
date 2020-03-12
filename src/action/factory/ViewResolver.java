package action.factory;

import java.util.HashMap;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public class ViewResolver {
	HashMap<String,String> views;
	
	
public ViewResolver() {
		super();
		
	}





public ViewResolver(HashMap<String, String> views) {
	super();
	this.views = views;
}





public String getPage(String view) {
	String newView=views.get(view);
	return newView;
}



}
