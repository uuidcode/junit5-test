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
}
