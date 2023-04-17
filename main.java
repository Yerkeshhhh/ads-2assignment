public class main {
    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        System.out.println(myList);

        myList.remove(Integer.valueOf(2));
        System.out.println(myList); // Output: [1, 4, 3]

        myList.remove(0);
        System.out.println(myList); // Output: [4, 3]

        System.out.println(myList.get(1)); // Output: 3

        System.out.println(myList.size()); // Output: 2

        myList.clear();
        System.out.println(myList); // Output: []
    }

}
