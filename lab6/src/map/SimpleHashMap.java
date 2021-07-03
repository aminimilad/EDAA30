package map;

import java.util.Arrays;

public class SimpleHashMap<K, V> implements Map<K, V> {

	Entry<K,V>[] bord;
	int capacity;
	double loadFactor;
	int size;
	
	/** Constructs an empty hashmap with the default initial capacity (16)
	and the default load factor (0.75). */
	public SimpleHashMap(){
		this(16); // anropar konstruktorn med 16 som parameter;
	}
	/**Constructs an empty hashmap with the specified initial capacity
	and the default load factor (0.75). */
	public SimpleHashMap(int capacity){
		bord = (Entry<K,V>[]) new Entry[capacity];
		loadFactor = 0.75;
	}
	
	public String show() {
		StringBuilder sb = new StringBuilder();
		Entry<K,V> e; 
		int k = 1;
		for(int i = 0; i<bord.length;i++) {
			
		
			
			e = bord[i];
			
			while(e != null) {
				sb.append(k + " " + e.toString() + " \n");
				e = e.next;
				k++;
			}
			
			
		}
		System.out.println(bord.length);
		return sb.toString();
	}
	
	@Override
	public V get(Object arg0) {

		K key = (K) arg0;
		int index = index(key);
		
		/*if(find(index, key) == null){
		 * return null;
		 * }
		 * else{
		 * return find(index,key).value;
		 * }
		 * */
		return find(index, key) == null ? null : find(index, key).value;
		
	}

	@Override
	public boolean isEmpty() {
		
		return size==0;
	}

	@Override
	public V put(K arg0, V arg1) {
		int index = index(arg0);
		Entry<K,V> isInTable = find(index, arg0);
		Entry<K,V> ElementAdd = new Entry<K, V>(arg0, arg1);
		
		//Dvs om key redan finns..byt dess värde
		if(isInTable!=null) {
			V temp = isInTable.value;
			isInTable.value = arg1;
			return temp;
		}
		else {
			ElementAdd.next = bord[index];
			bord[index] = ElementAdd;
			size++;
			if((size * 1.0) / (bord.length * 1.0) > loadFactor) {
				rehash();
			}
		
		return null;
		}
	}
	
	public void rehash() {
		Entry<K, V>[] copy = Arrays.copyOf(bord, bord.length);
		bord = (Entry<K,V>[]) new Entry[copy.length * 2];
		
		size = 0;
		
		for(Entry<K, V> entry : copy) {
			while(entry!=null) {
				put(entry.key, entry.value);
				entry = entry.next;//ABS
			}
		}
	}

	@Override
	public V remove(Object arg0) {
		
		
		
		K key = (K) arg0;
		
		int index = index(key);
		Entry<K, V> current = bord[index];
		
		// Listan är null.
		if(current == null) {
			return null;
		}
		
		//2. key finns i det första elementet i listan.
		
		else if(current.key.equals(key)) {
			bord[index] = bord[index].next;
			size--;
			return current.value;
		}
		//3. key finns senare i listan.
		
			while (current.next != null) {
				 
				
					if(current.next.key.equals(key)) {
						size--;
						V temp = current.next.value;
						
						if(current.next.next != null) {
							
							current.next = current.next.next;
							
						}
						else {
							current.next = null;
						}
						return temp;
					}
					else {
						current = current.next;
					}
				
			}
			//4. key finns inte i listan.
		return null;
	
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	//Returnera det index som ska användas för key
	private int index(K key) {
		int index = key.hashCode() % bord.length;
		if (index < 0) {
			index += bord.length;
		}
		return index;
	}
	
	private Entry<K,V> find(int index, K key){
		if(bord[index] == null) {
			return null;
		}
		return eta(bord[index], key);

		
	}
	
	public Entry <K, V> eta(Entry<K,V> e, K key){
		
		//while(e!= null){
		//e = e.next;
	//}
		
		 if(e.key.equals(key)) {
			return e;
		}
		else if(e.next == null) {
			return null;
		}
		else{
			
			return eta(e.next, key);
		}
	}
	
	
	
	public static class Entry<K, V> implements Map.Entry<K, V>{
		K key;
		V value;
		Entry<K, V> next;
		
		
		//??
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			// TODO Auto-generated method stub
			return null;
		}
		
		public String toString() {
			return key.toString() + " = " + value.toString();
		}

	}
	
	public static void main(String[]args) {
		SimpleHashMap<Integer, Integer> map = new SimpleHashMap<Integer, Integer>();
		
		map.put(1, 1);
		map.put(17, 17);
		map.put(33, 33);
		map.put(49, 49);
		map.put(65,  65);
		map.put(4, 1);
		map.put(7, 17);
		map.put(3, 33);
		map.put(9, 49);
		map.put(2, 17);
		map.put(5, 33);
		map.put(6, 49);
		
		map.put(11, 49);
		
		map.remove(11);
		
		System.out.println(map.get(65));
		System.out.print(map.show());
		
		
		
		
		
	}

}
