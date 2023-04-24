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

        myList.addAll();
        System.out.println(myList);
    }

}
