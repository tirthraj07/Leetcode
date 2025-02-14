import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().carFleet(10, new int[] { 0, 4, 2 }, new int[] { 2, 1, 3 }));
    }
}

class Solution {
    class Car {
        public int speed;
        public int position;

        public Car(int speed, int position) {
            this.speed = speed;
            this.position = position;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] carArray = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            carArray[i] = new Car(speed[i], position[i]);
        }

        Arrays.sort(carArray, new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                return o1.position > o2.position ? 1 : -1;
            }
        });

        Stack<Car> st = new Stack<>();

        int n = position.length - 1;

        st.push(carArray[n]);

        for (int i = n - 1; i >= 0; i--) {

            Car newCar = carArray[i];
            double newCarArrivalTime = (target - newCar.position) / (double) newCar.speed;

            Car oldCar = st.pop();
            double oldCarArrivalTime = (target - oldCar.position) / (double) oldCar.speed;

            if (newCarArrivalTime <= oldCarArrivalTime) {
                st.push(oldCar);
            } else {
                st.push(oldCar);
                st.push(newCar);
            }
        }

        return st.size();
    }
}
