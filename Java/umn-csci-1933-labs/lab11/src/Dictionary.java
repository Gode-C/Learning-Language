
public interface Dictionary<K,V> {
	public boolean insert(K key, V value);
	public V lookup (K key);
	public V remove(K key);
}
