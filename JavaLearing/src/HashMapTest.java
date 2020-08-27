import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
	public static void main(String[] args) {
		Map<HashKey,Integer> map= new HashMap<>();
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 2);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		map.put(new HashKey("a"), 1);
		
		//map.put(null, 3);
		System.out.println(map);
		
		System.out.println(map.get(null));
		
		ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put(101, "a");
		concurrentHashMap.put(102, "b");
		concurrentHashMap.put(103, "c");
		concurrentHashMap.put(104, "c");
		concurrentHashMap.put(105, "c");
		concurrentHashMap.put(106, "c");
		concurrentHashMap.put(107, "c");
		concurrentHashMap.put(108, "c");
		//concurrentHashMap.put(103, null);
		//System.out.println(concurrentHashMap);
	}
	
}

class HashKey{
	private String name;
	
	public HashKey(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
	
}
