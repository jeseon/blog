package co.monos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.monos.blog.dao.MemberRepository;
import co.monos.blog.domain.Member;
import co.monos.blog.domain.UserInfo;

@Service
@Transactional
public class MemberService implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Member member = memberRepository.findByUsernameIgnoreCase(username);
    	
        return (UserDetails) new UserInfo(member.getId(), member.getUsername(), member.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
