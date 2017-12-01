package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloMockitoRunWithJUnit4Test {
    @InjectMocks
    MemberService memberService = new MemberService();

    @Mock
    MemberDao memberDao;

    @Mock
    AuthorDao authorDao;

    @Before
    public void beforeEach() {
        when(authorDao.getAuthorByMemberId(any())).thenReturn(new Author());
        when(memberDao.get(any())).thenReturn(new Member());
    }

    @Test
    public void test() {
        assertNotNull(this.memberService.getMember(1L));
    }
}
