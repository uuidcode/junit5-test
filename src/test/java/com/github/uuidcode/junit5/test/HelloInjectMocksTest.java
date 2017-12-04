package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class HelloInjectMocksTest {
    @InjectMocks
    private MemberDao memberDao = new MemberDao();

    @Mock
    private MemberDao memberDaoMock;


    @Test
    public void test() {
        assertNotNull(this.memberDao.getLast());
        assertNull(this.memberDaoMock.getLast());
    }
}
