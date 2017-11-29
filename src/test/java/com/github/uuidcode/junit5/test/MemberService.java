package com.github.uuidcode.junit5.test;

public class MemberService {
    private MemberDao memberDao;
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
