package stormtech.com.sortservice.model;

import java.util.List;

public class SSInputModel {

	private List<Book> books;
	private List<SortConfig> configs;
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<SortConfig> getConfigs() {
		return configs;
	}
	public void setConfigs(List<SortConfig> configs) {
		this.configs = configs;
	}
	
}
