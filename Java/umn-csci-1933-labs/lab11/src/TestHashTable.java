import junit.framework.TestCase;

public class TestHashTable extends TestCase {

	private MyHashTable<MyKey, String> ht;

	protected void setUp() {
		ht = new MyHashTable<MyKey, String>(100);
	}

	public void testHashTable() {
		MyKey k1 = new MyKey(1);
		MyKey k2 = new MyKey(2);
		MyKey k3 = new MyKey(3);
        MyKey k104 = new MyKey(104);
		
		ht.insert(k1, "cs1901");
		ht.insert(k2, "cs1902");
		
		assertEquals( ht.lookup(k1), "cs1901" );
		assertEquals( ht.lookup(k2), "cs1902" );
		assertEquals( ht.lookup(k3), null );
		
		ht.insert(k3, "cs2011");
		assertEquals( ht.lookup(k3), "cs2011" );
		
		ht.insert(k3,  "cs2021");
		assertEquals( ht.lookup(k3), "cs2021" );

        ht.insert(k104, "cs1933");
        assertEquals( ht.lookup(k104), "cs1933" );

		String value = ht.remove(new MyKey(5));
        assertEquals(value, null);

        value = ht.remove(new MyKey(104));
        assertEquals(value, "cs1933");

        ht.insert(k104, "cs1933");
        value = ht.remove(new MyKey(3));
        assertEquals(value, "cs2021");

        assertEquals(ht.lookup(k104), "cs1933");
	}

}
