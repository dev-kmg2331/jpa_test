package com.app.kidz.repository;

import com.app.kidz.domain.member.Member;
import com.app.kidz.domain.member.Organization;
import com.app.kidz.domain.member.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long saveUser(User user) {
        em.persist(user);
        return user.getId();
    }

    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    public Member findMemberById(Long id) {
        return em.find(Member.class, id);
    }

    public <T> List<T> findList(Member member) {

        if(member instanceof User) {
            return (List<T>)em.createQuery("select m from Member m", User.class);
        }
        else return (List<T>)em.createQuery("select m from Member m", Organization.class);
    }
}
