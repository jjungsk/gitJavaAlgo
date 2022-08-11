package routine.compare;

public class Car implements Comparable<Car> {
	
	private int carNum;
	private String carName;
	private String maker;
	
	public Car(int carNum, String carName, String maker) {
		super();
		this.carNum = carNum;
		this.carName = carName;
		this.maker = maker;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	@Override
	public String toString() {
		return carNum + "\t" + carName + "\t" + maker;
	}

//	@Override
//	public int compareTo(Car car) {
//		return this.carNum - car.carNum; // carNum으로 오름차순 정렬
//	}
	
	@Override
	public int compareTo(Car car) {
		return this.carName.compareTo(car.carName); // carName으로 오름차순 정렬
	}

}
