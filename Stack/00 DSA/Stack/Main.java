public class Main {
    public static void main(String[] args) throws Exception {
        Stack st = new Stack(3);
        System.out.println(st);
        st.push(1);
        st.push(2);
        st.push(2);
        st.push(4);
        st.push(5);
        System.out.println(st);
        st.pop();
        st.pop();
        st.pop();
        System.out.println(st);
        st.pop();
        st.pop();
        System.out.println(st);

    }
}

class Stack {
    private int topIndex;
    private int[] arr;
    private int capacity;

    public Stack(int n) {
        if (n <= 0) {
            n = 5;
        }
        arr = new int[n];
        topIndex = -1;
        capacity = n;
    }

    public int top() throws Exception {
        if (topIndex == -1) {
            throw new Exception("Stack Emtpy");
        }

        return arr[topIndex];
    }

    public void pop() throws Exception {
        if (topIndex == -1) {
            throw new Exception("Stack Underflow");
        }

        topIndex -= 1;
    }

    public void expandStack() {
        int[] newArr = new int[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            newArr[i] = arr[i];
        }
        capacity = 2 * capacity;
        arr = newArr;
    }

    public void push(int num) {
        if (capacity == topIndex + 1) {
            expandStack();
        }

        topIndex++;
        arr[topIndex] = num;
    }

    @Override
    public String toString() {
        if (topIndex == -1) {
            return "Empty Stack";
        }
        StringBuilder out = new StringBuilder("");
        for (int i = 0; i <= topIndex; i++) {
            out = new StringBuilder(out + " " + arr[i]);
        }
        return out.toString();
    }

}
