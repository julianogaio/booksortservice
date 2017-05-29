package stormtech.com.sortservice;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import stormtech.com.sortservice.model.Book;
import stormtech.com.sortservice.model.SSInputModel;
import stormtech.com.sortservice.model.SSOutputModel;
import stormtech.com.sortservice.model.SortConfig;

@RestController
@RequestMapping("/sort")
public class SortServiceController {


	public SortServiceController(){}
	
	@RequestMapping(method = RequestMethod.POST)
	public SSOutputModel sort(@RequestBody SSInputModel input) throws SortingServiceException{
		List<SortConfig> list = input.getConfigs();
		if(list == null){
			throw new SortingServiceException();
		}
		//reverse config list. "last in first out"
		Collections.reverse(list);
		boolean firstLoop = true;
		SSOutputModel output = null;
		for(SortConfig config : list){
			if(firstLoop){
				//use input list in the first loop 
				firstLoop = false;
				output = sortList(input.getBooks(), config.getColumn(),config.getSort());
			}else{
				//after that should use sorted list (output) 
				output = sortList(output.getSortedList(), config.getColumn(),config.getSort());
			}
		}
		return output;
	}

	private SSOutputModel sortList(List<Book> books, String column, String sort) {
		SSOutputModel output = new SSOutputModel();
		switch(column){
			case "author":
				if(sort.equalsIgnoreCase("asc")){
					books.sort((p1, p2) -> p1.getAuthor().compareTo(p2.getAuthor()));			
				}else{
					books.sort((p2, p1) -> p1.getAuthor().compareTo(p2.getAuthor()));
				}
				break;
			case "title":
				if(sort.equalsIgnoreCase("asc")){
					books.sort((p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));
				}else{
					books.sort((p2, p1) -> p1.getTitle().compareTo(p2.getTitle()));
				}
				break;
			case "edition":
				if(sort.equalsIgnoreCase("asc")){
					books.sort((p1, p2) -> p1.getEdition().compareTo(p2.getEdition()));
				}else{
					books.sort((p2, p1) -> p1.getEdition().compareTo(p2.getEdition()));
				}
				break;
		}
		
		output.setSortedList(books);
		return output;
	}
}
