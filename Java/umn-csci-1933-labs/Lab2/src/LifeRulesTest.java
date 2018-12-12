import junit.framework.TestCase;

/**
 * Test code for the {@link LifeRules} class, to make sure it correctly plays
 * Life.
 */
public class LifeRulesTest extends TestCase {
    private LifeRules rules;
    
    /**
     * The setUp method is used to create objects, etc. to be used by tests.  It
     * is called before each test is run.
     */
    protected void setUp() {
        rules = new LifeRules();
    }
    
    /**
     * Check that a dead cell in a dead neighborhood stays dead.
     */
    public void testNoOp() {
        assertFalse(rules.getNextState(false, 0));
    }
    
    /**
     * Check that living stays alive appropriately.
     */
    public void testStayAlive() {
        assertTrue(rules.getNextState(true, 2));
        assertTrue(rules.getNextState(true, 3));
    }
    
    /**
     * Test that 3 neighbors bring a dead cell to life.
     */
    public void testComeToLife() {
        assertTrue(rules.getNextState(false, 3));
        assertTrue(rules.getNextState(false, 6));
    }
    
    /**
     * Test death by overcrowding.
     */
    public void testOvercrowd() {
        assertFalse(rules.getNextState(true, 4));
        assertFalse(rules.getNextState(true, 7));
    }
    
    /**
     * Test death by loneliness.
     */
    public void testLonely() {
        assertFalse(rules.getNextState(true, 0));
        assertFalse(rules.getNextState(true, 1));
    }
    
    /**
     * Test various stay-dead scenarios.
     */
    public void testStayDead() {
        assertFalse(rules.getNextState(false, 5));
        assertFalse(rules.getNextState(false, 8));
        assertFalse(rules.getNextState(false, 2));
    }
}
