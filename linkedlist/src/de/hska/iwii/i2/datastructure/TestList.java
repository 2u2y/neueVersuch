package de.hska.iwii.i2.datastructure;


/**
 * Klassen Ausgabetest.
 */
public class TestList {

	public static void main(String[] args) {
		List<Integer> list = new List<>();
		
		
		list.add(0,1);
		list.add(1,2);
		
		list.add(2,3);
		
		list.addFirst(5);
	    list.addFirst(4);
	 

		
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}
		
		list.remove(2);
        System.out.println();
        for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}
        list.removeFirst();
        System.out.println();
        for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}
        
        list.removeLast();
        System.out.println();
        for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
        }
		
		
		System.out.println();
		
		list.addLast(54);
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}
		
		List<String> list2 = new List<>();
		list2.add(0,"Hallo");
		
		
	
	}
}