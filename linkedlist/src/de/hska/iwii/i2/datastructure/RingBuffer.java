package de.hska.iwii.i2.datastructure;

public class RingBuffer<E> {

	/**
	 *Generische  Liste wird erzeugt
	 * @param args
	 */
	private List<E> list = new List<E>();
	private int ri;
	private int wi;
	private int size ;
	
	/**
	 * Konstruktor der Klasse.
	 * @param size
	 */
	public RingBuffer(int size){
		this.size = size;

	}
	/**
	 * Methode zu schreiben in das Ringpuffer
	 * @param value
	 */
	public void write(E value){
		//liste leer ?
		assert(list.getSize() < size);
		//an die letzte stelle wert einschreiben
		list.addLast(value);
		
		wi++ ;
		if(wi == size){
			wi = 0;
		}
		
	}
	/**
	 * Methode zu lesen aus dem ringpuffer
	 * @return
	 */
	public E read(){
		//liste leer?
		assert(size > 0);
		//read index aufgerufen
		return list.get(ri);
	}
	
	/**
	 * main Methode.
	 * @param args
	 */
	public static void main(String[] args) {
	
		RingBuffer<Integer> rb = new RingBuffer<Integer>(5);
		
		rb.write(1);
		
		System.out.println(rb.read());
	}

}
