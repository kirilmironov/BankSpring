package com.nevexis.bankspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

//стековите променливи умират извън стековия фрейм(като излезнем от функцията)
@SpringBootTest
public class SumTest {
    
    SumImpl sum = new SumImpl();

    @Test
    public void sumTest() {
        int actual = sum.add(4, 6);
        Assertions.assertEquals(10,actual);
    }

    @Test
    public void sumTestWithMockito() {
        SumImpl sumMockito = Mockito.mock(SumImpl.class);
        Mockito.when(sumMockito.add(4,6)).thenReturn(10);
        Assertions.assertEquals(10,sumMockito.add(4,6));
    }

    @Test
    public void sumTestWithSpy() {
        SumImpl spy = Mockito.spy(sum);
        Mockito.when(spy.add(4,6)).thenReturn(10);
        Assertions.assertEquals(10, spy.add(4,6));
    }
}
