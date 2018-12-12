import java.util.ArrayList;
import java.util.Random;

public class MyHashTable<K,V> implements Dictionary<K,V> {
	private ArrayList<Node> table;
	private int tableSize;
	private int numComparisons = 0;
	
	/**
	 * Private inner class to represent a key-value pair
	 * 
	 *
	 */
	private class Entry {
		private K key;
		private V value;

		private Entry (K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public void display() {
			System.out.format("%s --> %s ", key, value);
		}
	}

	/**
	 * Private inner class to represent the chain stored at  
	 * each bucket in the table
	 * 
	 *
	 */
	private class Node {
		Entry data;
		Node next;

		private Node(Entry data) {
			this.data = data;
			next = null;
		}
	}

	public MyHashTable(int initialSize) {
		tableSize = getNextPrime(initialSize);
		table = new ArrayList<Node> ( tableSize );
		for (int i = 0; i < tableSize; i++) 
			table.add(null);
	}
	
	/**
	 * Map the hashcode of the key onto the indices of the table
	 * @param key the key
	 * @return an index of the table
	 */
	private int hashFunction(K key) {
		return ( key.hashCode() % tableSize );
	}

	public boolean insert(K key, V value) {

		needRehash();

		int index = hashFunction(key);
		
		Node cur = table.get(index);
		Node prev = null;

		numComparisons++;
		while (cur != null) {
			numComparisons++;
			// if the key is found in the chain, replace the value
			if ( cur.data.key.equals(key) ) {
				cur.data.value = value;
				return false;
			}
			// otherwise keep iterating
			else {
				prev = cur;
				cur = cur.next;
			}
		}
		// if we got this far, add the entry to the end of the chain
		Node newNode = new Node( new Entry(key, value) );
		
		// if the chain was empty initially, then prev is null, so
		// the new key-value pair becomes the start of a new chain
		if ( prev == null) {
			newNode.next = null;
			table.set(index, newNode);
		}
		// otherwise (if the chain was not empty), add the
		// new key-value pair to the end of the chain
		else 
			prev.next = newNode;
					
		return true;
	}

	/**
	 * Given a key, return its value in this map.
	 * @param key the key
	 * @return key's associated value
	 */
	public V lookup(K key) {
		int index = hashFunction(key);
		Node cur = table.get(index);
		Node prev = null;
		while(cur!=null){
			if (cur.data.key.equals(key)){
				return cur.data.value;

			}
			cur=cur.next;
		}
		return null;
	}

    public V remove(K key) {


		int index = hashFunction(key);
		Node next = null;
		Node cur = table.get(index);
		Node prev = null;
		while(cur!=null){

			next = cur.next;
			if (cur.data.key.equals(key)){

				if (prev ==null){
					return cur.data.value;
				}

				prev.next=next;

				return cur.data.value;
			}
			prev = cur;
			cur=cur.next;
		}
		return null;
	}


	private static int getNextPrime(int n) {
		if ( (n % 2) == 0 ) 
			n++;
		if ( isPrime(n) )
			return n;
		else
			return getNextPrime(n+2);
	}
	
	public static boolean isPrime(int n) {
		for (int i = 3; i < n/2; i++) {
			if ( (n % i) == 0 )
				return false;
		}
		return true;
	}

	
	
	private void display () {
		int i = 0;
		for (Node cur: table) {
			System.out.format("%d | ", i++);
			
			while ( cur != null ) {
				cur.data.display();
				cur = cur.next;
			}
			System.out.format("|\n");
		}
	}

	public boolean needRehash(){
		if (table.size()>tableSize){
			return true;
		}
		return false;
	}


	public void rehash(){

		int m = getNextPrime(tableSize);
		ArrayList<Node> temp = table;
		table = new ArrayList<Node>(m);

		for (Node curre:temp){
			Node cur = curre;

			while (cur != null) {
				insert(cur.data.key,curre.data.value);
				cur=cur.next;

			}



		}


	}

}
