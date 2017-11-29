package com.github.uuidcode.junit5.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class HelloExtendWithTest {
    private @InjectMocks MemberService memberService = new MemberService();

    @BeforeEach
    public void beforeEach(@Mock AuthorDao authorDao, @Mock MemberDao memberDao) {
        when(authorDao.getAuthorByMemberId(any())).thenReturn(new Author());
        when(memberDao.get(any())).thenReturn(new Member());
    }

    @Test
    public void test() {
        assertNotNull(this.memberService.getMember(1L));
    }
}
