package com.github.uuidcode.junit5;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.uuidcode.junit5.test.AuthorDao;
import com.github.uuidcode.junit5.test.MemberDao;
import com.github.uuidcode.junit5.test.MemberService;

@RunWith(MockitoJUnitRunner.class)
public class HelloMockitoTest {
    @InjectMocks
    private MemberService memberService = new MemberService();

    @Mock
    private MemberDao memberDao;

    @Mock
    private AuthorDao authorDao;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        assertNotNull(this.memberService.getMember(1L));
    }
}
