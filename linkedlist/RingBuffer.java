package de.hska.iwii.i2.datastructure;

import de.hska.iwii.i2.datastructure.List;

public class RingBuffer<E> {

	/**
	 * @param args
	
	 */
	private List<E> list = new List<E>();
	private int ri;
	private int wi;
	private int size ;
	
	public RingBuffer(int size){
		this.size = size;
	
	}
	public void write(E value){
		assert(list.getSize() < size);
		list.addLast(value);
		
		wi++ ;
		if(wi == size){
			wi = 0;
		}
		
	}
	public E read(){
		E value = list.get(ri);
		assert( list.getSize() > size);
		
		if(ri == size){
			ri = 0;
			
		}else{
			ri++;
		}
		
		return value;
		
	}
	
	public static void main(String[] args) {
		 
		 RingBuffer rb = new RingBuffer<Integer> (5);
		 RingBuffer rb1 = new RingBuffer<Integer> (5);

		 for(int i = 0;i < 5; i++){

			 System.out.println(rb.read());
		 }
		
	}

}
