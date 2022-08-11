package routine.compare;

import java.util.*;

public class CarCompareTest {
	
	public static void main(String[] args) {
		Car car1 = new Car(1234, "SonataA", "HD");
		Car car2 = new Car(1265, "SonataC", "HD");
		Car car3 = new Car(5648, "Avante", "HD");
		Car car4 = new Car(2597, "K7", "KIA");
		Car car5 = new Car(3674, "K9", "KIA");
		Car car6 = new Car(3673, "SonataA", "HD");
		Car car7 = new Car(8541, "K5", "KIA");
		Car car8 = new Car(8542, "GENESIS", "HD");
		Car car9 = new Car(9987, "SM6", "SS");
		
		List<Car> list = new ArrayList<Car>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
		list.add(car6);
		list.add(car7);
		list.add(car8);
		list.add(car9);
		viewList(list);
		
		// Car class의 Comparabel의 기준에 따라 정렬
		Collections.sort(list);
		viewList(list);
		
		
		// 변수명을 설정해 줘서 지속적으로 사용
		Comparator<Car> method1 = new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		Collections.sort(list, method1);
		//
		
		// 차 이름으로 정렬
		Collections.sort(list, new Comparator<Car>() {
			
			@Override
			public int compare(Car c1, Car c2) {
				return c1.getCarName().compareTo(c2.getCarName()); // 첫문자 비교
			}
		});
		
		// 제조사로 정렬
		Collections.sort(list, new Comparator<Car>() {
			
			@Override
			public int compare(Car c1, Car c2) {
				return c1.getMaker().compareTo(c2.getMaker()); // 첫 문자 비교
			}
		});
		
	}

	private static void viewList(List<Car> list) {
		// TODO Auto-generated method stub
		System.out.println("차번호\t차이름\t제조사");
		System.out.println("------------------------------------------");
		for (Car car: list)
			System.out.println(car);
	}

}
