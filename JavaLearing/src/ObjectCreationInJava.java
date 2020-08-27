import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectCreationInJava{
	public static void main(String[] args) {
		//First way
		ObjectCreationInJava firstWay = new ObjectCreationInJava();
		System.out.println(firstWay.getClass().toString());
		
		
		//Second way
		try {
			Class cls = Class.forName("ObjectCreationInJava");
			ObjectCreationInJava secondWay = (ObjectCreationInJava) cls.newInstance();
			System.out.println(firstWay.getClass().toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		//Third way
		ObjectCreationUsingClone thirdWay = new ObjectCreationUsingClone();
		try {
			ObjectCreationUsingClone thirdWay2 = (ObjectCreationUsingClone) thirdWay.clone();
			System.out.println(thirdWay.getClass().toString());
			System.out.println(thirdWay2.getClass().toString());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		//Fourth way
		new DeserializationExample("GeeksForGeeks").serializeObj();
		try
        { 
            DeserializationExample fourhtWay; 
            FileInputStream f = new FileInputStream("file.txt"); 
            ObjectInputStream oos = new ObjectInputStream(f); 
            fourhtWay = (DeserializationExample)oos.readObject(); 
            System.out.println(fourhtWay.getClass().toString());
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); 
        } 
		
		//Fifth way
		try {
			Constructor<ObjectCreationInJava> constructor = ObjectCreationInJava
															.class.getDeclaredConstructor();
			ObjectCreationInJava fifthWay = constructor.newInstance();
			System.out.println(fifthWay.getClass().toString());
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
		
		
		//break the singleton
		SingletonClass object1 = SingletonClass.getInstance();
		SingletonClass object2 = SingletonClass.getInstance();
		System.out.println("object1 hascode=" + object1.hashCode());
		System.out.println("object2 hascode=" + object2.hashCode());
		try {
			Constructor<SingletonClass> singletonClassObj = SingletonClass.class.getDeclaredConstructor();
			singletonClassObj.setAccessible(true);
			SingletonClass singletonClass = singletonClassObj.newInstance();
			
			System.out.println("singletonClass hascode=" + singletonClass.hashCode());
			
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

class ObjectCreationUsingClone implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}


class DeserializationExample implements Serializable 
{ 
    private String name; 
    DeserializationExample(String name) 
    { 
        this.name = name; 
    }
    
    public void serializeObj() {
    	try
        { 
            DeserializationExample d = 
                    new DeserializationExample("GeeksForGeeks"); 
            FileOutputStream f = new FileOutputStream("file.txt"); 
            ObjectOutputStream oos = new ObjectOutputStream(f); 
            oos.writeObject(d); 
            oos.close(); 
            f.close(); 
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); 
        } 
    }
} 

class SingletonClass{
	private static SingletonClass instance;
	private SingletonClass() {
		
	}
	
	public static SingletonClass getInstance() {
		if(instance == null) {
			instance = new SingletonClass();
		}
		return instance;
	}
}


