import java.util.ArrayList;
import java.util.List;


public class LocationDistance {
	public static void main(String[] args) {
		List<Locality> localityList = new ArrayList<Locality>();
		//localityList.add(new Locality(28.415981,76.922525));
		//localityList.add(new Locality(19.085,72.91012));
		localityList.add(new Locality(28.418809,77.038473));
		localityList.add(new Locality(26.802978,75.809714));
		localityList.add(new Locality(19.58978,73.393201));
		localityList.add(new Locality(26.826941,81.006267));
		localityList.add(new Locality(28.597588,77.39189));
		double latitude = 26.849259, longitude = 75.671277;
		double minDisance = Double.MAX_VALUE,secMinDistance = Double.MAX_VALUE;
		Locality locality1=null, locality2=null;
		for(int i=0; i<localityList.size(); i++){
			Locality locality = localityList.get(i);
			double distance = distance(locality.getLatitude(), locality.getLongitude(), latitude, longitude);
			System.out.println("Distance " + distance);
			if(distance < minDisance) {
				minDisance = distance;
				locality1 = locality;
			}else if(distance < secMinDistance) {
				secMinDistance = distance;
				locality2 = locality;
			}
		}
		System.out.println("MinDistance " + minDisance + ", Sec MIn Distance " + secMinDistance);
		System.out.println("Min Locality " + locality1.getLatitude() + " Sec Min Loc " +locality2.getLatitude());
	}
	
	private static double distance(double lat1, double lat2, double lon1, double lon2) { 
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
  
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));
 
		double r = 6371; 
		return (c * r);
	}
	
}

class Locality{
	private double latitude;
	private double longitude;
	
	public Locality(double latitude,double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}

