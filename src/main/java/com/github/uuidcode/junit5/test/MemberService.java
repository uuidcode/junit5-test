package com.github.uuidcode.junit5.test;

import javax.annotation.Resource;

public class MemberService {
    @Resource
    private MemberDao memberDao;

    @Resource
    private AuthorDao authorDao;

    public Member getMember(Long memberId) {
        Member member = this.memberDao.get(memberId);
        Author author = this.authorDao.getAuthorByMemberId(memberId);
        member.setAuthor(author);
        return member;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
}
