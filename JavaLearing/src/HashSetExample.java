import java.util.HashSet;

public class HashSetExample {
	public static void main(String[] args) {
		HashSet<Stock> set = new HashSet<>();
		set.add(new Stock("stock", 1, 100f));
		set.add(new Stock("stock", 1, 100f));
		set.add(new Stock("stock", 1, 100f));
		
		System.out.println(set.size());
	}
}

class Stock{
	private String name;
	private Integer id;
	private Float price;
	
	
	
	public Stock(String name, Integer id, Float price) {
		this.name = name;
		this.id = id;
		this.price = price;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}else if(obj == this) {
			return true;
		}
		Stock stock = (Stock) obj;
		if (id != null ? !id.equals(stock.id) : stock.id != null) return false; 
		if (name != null ? !name.equals(stock.name) : stock.name != null) return false; 
		return price != null ? price.equals(stock.price) : stock.price == null; 
	}
	
//	@Override
	public int hashCode() {
		int result = id != null ? (int) (id ^ (id >>> 32)) : 0;     
		result = result * 31 + (name != null ? name.hashCode() : 0);
		result = result * 31 + (price != null ? price.hashCode() : 0);		
		return result;
	}
	
}
