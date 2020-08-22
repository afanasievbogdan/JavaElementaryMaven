package HomeWork8;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.BDDMockito.given;


public class StringCollectionTest {

    private final StringCollection stringCollection = new StringCollection() ;

    @Test
    public void add() {
        Assert.assertTrue(stringCollection.add("1"));
        Assert.assertFalse(stringCollection.add(1));
        Assert.assertEquals(1, stringCollection.size());
        Assert.assertEquals("1", stringCollection.get(0));
        Assert.assertTrue(stringCollection.contain("1"));

    }

    @Test
    public void testAdd() {
        Assert.assertTrue(stringCollection.add(0,"1"));
        Assert.assertFalse(stringCollection.add(0,1));
        Assert.assertTrue(stringCollection.contain("1"));
        stringCollection.add(0, "new 1");
        Assert.assertFalse(stringCollection.contain("1"));
    }

    @Test
    public void delete() {
        Assert.assertFalse(stringCollection.delete("1"));
        Assert.assertFalse(stringCollection.delete(1));
        Assert.assertTrue(stringCollection.add("1"));
        Assert.assertTrue(stringCollection.add("1"));
        Assert.assertTrue(stringCollection.delete("1"));
        Assert.assertEquals(1, stringCollection.size());

    }

    @Test
    public void get() {
        Assert.assertTrue(stringCollection.add("1"));
        Assert.assertTrue(stringCollection.add(null));
        Assert.assertEquals("1", stringCollection.get(0));
        Assert.assertEquals(-1, stringCollection.get(1));
        Assert.assertEquals(-1, stringCollection.get(10));

    }

    @Test
    public void contain() {
        Assert.assertTrue(stringCollection.add("1"));
        Assert.assertFalse(stringCollection.contain(1));
        Assert.assertTrue(stringCollection.contain("1"));
        Assert.assertFalse(stringCollection.contain("2"));

    }

    @Test
    public void testEquals() {
        StringCollection stringCollection1 = new StringCollection();
        Assert.assertTrue(stringCollection1.add("1"));

        StringCollection stringCollection2 = new StringCollection();
        Assert.assertTrue(stringCollection2.add("2"));

        StringCollection stringCollection3 = new StringCollection();
        Assert.assertTrue(stringCollection3.add("1"));

        StringCollection stringCollection4 = new StringCollection();
        Assert.assertTrue(stringCollection4.add("1"));
        Assert.assertTrue(stringCollection4.add("1"));

        StringCollection stringCollection5 = new StringCollection();

        Assert.assertTrue(stringCollection1.equals(stringCollection1));
        Assert.assertFalse(stringCollection1.equals(stringCollection2));
        Assert.assertTrue(stringCollection1.equals(stringCollection3));
        Assert.assertFalse(stringCollection1.equals(stringCollection4));
        Assert.assertFalse(stringCollection1.equals(stringCollection5));
    }

    @Test
    public void clear() { ;
        Assert.assertTrue(stringCollection.add("1"));
        Assert.assertEquals(1,stringCollection.size());
        Assert.assertTrue(stringCollection.clear());
        Assert.assertEquals(0,stringCollection.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(0,stringCollection.size());
        Assert.assertTrue(stringCollection.add("1"));
        Assert.assertEquals(1,stringCollection.size());
        Assert.assertTrue(stringCollection.delete("1"));
        Assert.assertEquals(0,stringCollection.size());

    }
}