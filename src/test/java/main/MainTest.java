package main;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MainTest {

    Starter mockStarter;

    @Before
    public void setUp() {
        mockStarter = mock(Starter.class);
    }

    @Test
    public void mainTest() throws Exception {
        Main.setStarter(mockStarter);
        Main.main(new String[]{"test1", "test2"});
        Mockito.verify(mockStarter, times(1)).start(new String[]{"test1", "test2"});
    }
}
