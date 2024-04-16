
public class StackHeapTest {

    public int n = 5; //primitive data on the heap

    public static void changeInt(int nValue, int nRefN, StackHeapTest nRef) {
        System.out.println("--before--");
        System.out.println("n value: " + nValue);
        System.out.println("n ref n: " + nRefN);
        System.out.println("Stack Heap Test:" + nRef.n);

        nValue += 10;
        nRefN += 10;
        nRef.n += 10;

        System.out.println("\n--after--");
        System.out.println("n value: " + nValue);
        System.out.println("n ref n: " + nRefN);
        System.out.println("Stack Heap Test:" + nRef.n);
    }

    public static void main(String[] args) {

        int n = 5; //primitive data type on the stack

        StackHeapTest nRef = new StackHeapTest();

        //before
        System.out.println("\n--before--");
        System.out.println("n: " + n + " Hashcode: " + System.identityHashCode(n));  
        System.out.println("nRef.n: " + nRef.n + " Hashcode: " + System.identityHashCode(nRef.n));
        System.out.println("nRef: " + nRef + " Hashcode: " + System.identityHashCode(nRef) + "\n");

        changeInt(n, nRef.n, nRef); //stack by value, heap by value, heap by reference

        //after
        System.out.println("\n--after--");
        System.out.println("n: " + n + " Hashcode: " + System.identityHashCode(n));
        System.out.println("nRef.n: " + nRef.n + " Hashcode: " + System.identityHashCode(nRef.n));
        System.out.println("nRef: " + nRef + " Hashcode: " + System.identityHashCode(nRef));

    }
}
