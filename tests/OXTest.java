import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OXTest {
    @Test
    public void shouldCreateOXObjectCorrectly() {
        OX testtable = new OX();
        // "012\n0---\n1---\n2---\n"
        assertEquals("  0 1 2 \n0 - - - \n1 - - - \n2 - - - \n",testtable.getTableString());
        assertEquals("X",testtable.getCurrentPlayer());
        assertEquals(0,testtable.getCountO());
        assertEquals(0,testtable.getCountX());
        assertEquals(0,testtable.getCountDraw());
    }

    @Test
    public void put() {
        OX testtable = new OX();
        testtable.put(1, 1);
        assertEquals("  0 1 2 \n0 - - - \n1 - X - \n2 - - - \n", testtable.getTableString());

        testtable.put(0, 0);
        assertEquals("  0 1 2 \n0 X - - \n1 - X - \n2 - - - \n", testtable.getTableString());

        testtable.put(2, 1);
        assertEquals("  0 1 2 \n0 X - - \n1 - X X \n2 - - - \n", testtable.getTableString());

        testtable.switchPlayer(); //O
        testtable.put(0, 2);
        assertEquals("  0 1 2 \n0 X - - \n1 - X X \n2 O - - \n", testtable.getTableString());

        assertEquals(false, testtable.put(0, 2));

        assertEquals(false, testtable.put(0, 3));
    }

    @Test
    public void get() {
        OX testtable = new OX();
        testtable.put(0, 2);
        assertEquals("-", testtable.get(0,0));
        assertEquals("X", testtable.get(0,2));
    }

    @Test
    public void switchPlayer() {
        OX testtable = new OX();
        testtable.switchPlayer();
        assertEquals("O", testtable.getCurrentPlayer());
    }

    @Test
    public void checkWin() {
        OX testtable = new OX();
        testtable.put(0, 0);
        testtable.put(0, 1);
        testtable.put(0, 2);
        assertEquals(true, testtable.checkWin());
    }

    @Test
    public void checkWin2() {
        OX testtable = new OX();
        testtable.put(1, 0);
        testtable.put(1, 1);
        testtable.put(1, 2);
        assertEquals(true, testtable.checkWin());
    }

    @Test
    public void checkWin3() {
        OX testtable = new OX();
        testtable.put(2, 0);
        testtable.put(2, 1);
        testtable.put(2, 2);
        assertEquals(true, testtable.checkWin());
    }

    @Test
    public void checkWin4() {
        OX testtable = new OX();
        testtable.put(0, 0);
        testtable.put(1, 0);
        testtable.put(2, 0);
        assertEquals(true, testtable.checkWin());
    }

    @Test
    public void checkWin5() {
        OX testtable = new OX();
        testtable.put(0, 1);
        testtable.put(1, 1);
        testtable.put(2, 1);
        assertEquals(true, testtable.checkWin());
    }

    @Test
    public void checkWin6() {
        OX testtable = new OX();
        testtable.put(0, 2);
        testtable.put(1, 2);
        testtable.put(2, 2);
        assertEquals(true, testtable.checkWin());
    }

    @Test
    public void checkWin7() {
        OX testtable = new OX();
        testtable.put(0, 0);
        testtable.put(1, 1);
        testtable.put(2, 2);
        assertEquals(true, testtable.checkWin());
    }

    @Test
    public void checkWin8() {
        OX testtable = new OX();
        testtable.put(2, 0);
        testtable.put(1, 1);
        testtable.put(0, 2);
        assertEquals(true, testtable.checkWin());
    }
}