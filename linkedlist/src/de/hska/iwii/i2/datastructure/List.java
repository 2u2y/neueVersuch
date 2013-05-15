package de.hska.iwii.i2.datastructure;

/**
 * Eine implementierung für eine doppelt verketette Liste. 
 * @author susana.biro
 */

/**
 * Klasse Liste
 * @author susana.biro
 * @param <E>
 */
public class List<E> {

	/**
	 * Das ListenElement klasse ist als innere Klasse implementiert worden.
	 * 
	 * @param T
	 */
	class ListElements<E> {
        /*
         * Innere Klasse wo die nächste und vorherige Element imlplementiert wird
         */
		E value;
		ListElements<E> prev;
		ListElements<E> next;
        
		ListElements(E value) {
			this.value = value;
		}
	}
     /**   
      * Referenz auf das erste Element der Liste.
      */   
	
	private ListElements<E> first;
   /**
    * Referenz auf das letzte Element der Liste.
    */
	private ListElements<E> last;

	/**
	 * Anzahl elemente der Liste.
	 */
	private int size;

	/**
	 * Ein neues Element zu die Liste hinfügen.
	 * @param args
	 */
	public void add(int index, E value) {

		// überprüfen ob die den Index innerhalb die Liste ist.
		assert (index >= 0 && index < size);
		// wenn die erste platz leer ist,wird die addFirst methode aufgerufen
		// und ausgeführt.
		if (index == 0) {
			addFirst(value);
			// sonst wird addLast Liste aufgerufen und ausgeführt
		} else if (index == getSize()) {
			addLast(value);
			/*
			 * wenn man in ein andere Index innerhalb die Liste ein Element
			 * zufügen will, fürht man diese methode aus das Listenelement wird
			 * referenziert als der nächste-nach den angegebenen Index dann ein
			 * neue referenz auf das vorherige index,dann die"pfeile " zeigen
			 * jeweils auf das neue hinzugefügte Element
			 */

		} else {
			ListElements<E> le = new ListElements<>(value);
			le.next = getElement(index);
			le.prev = getElement(index - 1);
			le.next.prev = le;
			le.prev.next = le;
			size++;
		}
	}

	/**
	 * Den Wert aus dem Index auslesen.
	 * @param index
	 * @return getElement( index).
	 */

	public E get(int index) {

		return getElement(index).value;
	}

	/**
	 * Eine Methode die das Index aus die Liste ausliest.
	 * 
	 * @param index
	 * @return current
	 */
	private ListElements<E> getElement(int index) {
		// prüft ob das übergebene Index innerhalb der Liste existiert.
		assert (index >= 0 && index <= size);

		/*
		 * Alle Listenelemnet von Anfang bis "Index" durchlaufen, das gesuchte
		 * Index zurückgeben.
		 */

		ListElements<E> current = this.first;
		while (index > 0) {
			current = current.next;
			index--;
		}
		return current;
	}

	/**
	 * Anzahl Elemente in der Liste überprüfen
	 * @param value
	 * @return Anzahl Elemente der Liste
	 */

	// Erste Element zufügen
	public void addFirst(E value) {
    // neue Liste erzeugt mit dem übergebenen Wert
		ListElements<E> ele = new ListElements<>(value);
    // wenn die erste Element noch nicht benutzt wird
		if (first == null) {
	// ist die erste Element auch das letzte
			first = last = ele;

	// sonst wird der erste element verschoben und neue kommt dazu.
		} else {

			first.prev = ele;

			ele.next = first;
			first = ele;
		}

		size++;
	}

	/**
	 * Ein Element auf das letzte platz der Liste hinfügen.
	 * @param value
	 */
	public void addLast(E value) {

    // wenn noch kein element in die Liste ist,dann soll die addFirst
	// methode aufgeruffen werden
	// sonst wird in die Liste der letzte der vorletzte und das neue Element
	// der letzte
		if (first == null) {
			addFirst(value);
		} else {
			ListElements<E> le = new ListElements<E>(value);

			last.next = le;
			le.prev = last;
			last = le;

			size++;
		}
	}

	/**
	 * Das erste Element entfernen
	 * 
	 * @return result
	 */
	public E removeFirst() {
		// eine variable wird angelegt,das wert von ersteElement gespeichert
		
		E result = null;
        // wert vom Erste Element speichert sich in die variable
		result = first.value;
		//Erste Element wird der "nächste"
		first = first.next;
		//" frühere " Erste wird gelöscht
		first.prev = null;
		// liste länge wird dekrementiert
		size--;
		return result;
	}

	/**
	 * Das letzte Element wird entfernt.
	 * Man prüft ob die liste leer ist,legt eine Variable fest,die am ende ausgegeben wird,
	 * die Zeiger werde dem entsprechend von das letzte Element auf das vorherige gebracht,und das neue le
	 * @return result
	 */
	//
	public E removeLast () {

		E result = null;
		// ist die Liste leer?
		assert( size > 0 ) ;
		//wenn es nicht leer ist die variable speichert das wert der letzten Element 
		if ( last != null) {
			result = last.value;
			//lätzte  Element wird der Vorige
			last = last.prev;
			//wenn das stimmt wird der letzte gelöscht ,länge des Liste wird -1
			if ( last != null) {
				last.next = null;
			} else {
				first = null;
			}
			size--;
		}

		return result;

	}
    /**
     * Methode die Elemente verschiedener Index löscht.
     * @param index
     * @return
     */
	public E remove(int index) {

		E result = null;
		assert (index >= 0 && index < size);
        //wenn der index auf das Erste Element zeigt,wird removeFirst aufgerufen
		if (index == 0) {
			removeFirst();
		//sonst wird die methode removeLast aufgerufen	
		} else if (index == getSize() - 1) {
			removeLast();
		//wenn dies nicht zutrifft,wird die liste nach den  gewollten index gesucht,und 
	    // löscht ihm
		} else {
			ListElements<E> current = getElement(index);
			current.next.prev = current.prev;
			current.prev.next = current.next;
			
			current = null;
			size--;
		}

		return result;

	}

	/**
	 * Methode die die Länge der Liste speichert. 
	 * @return
	 */
	public int getSize() {
		return size;
	}

}
