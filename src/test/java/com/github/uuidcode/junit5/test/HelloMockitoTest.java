package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HelloMockitoTest {
    @InjectMocks
    MemberService memberService = new MemberService();

    @Mock
    MemberDao memberDao;

    @Mock
    AuthorDao authorDao;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        when(authorDao.getAuthorByMemberId(any())).thenReturn(new Author());
        when(memberDao.get(any())).thenReturn(new Member());
    }

    @Test
    public void test() {
        assertNotNull(this.memberService.getMember(1L));
    }
}
