import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumSingleton {
	INSTANCE;
	
	private EnumSingleton() {
		
	}
	
	public static EnumSingleton getSingleton() {
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		EnumSingleton instance = EnumSingleton.INSTANCE;
		System.out.println(instance.hashCode());
		
		EnumSingleton instance2 = EnumSingleton.INSTANCE;
		System.out.println(instance2.hashCode());
		
		try {
			Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor();
			constructor.canAccess(true);
			EnumSingleton newInstance = constructor.newInstance();
			System.out.println(newInstance);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}


