package fr.iscod.coworkia.services;

import fr.iscod.coworkia.entities.InternalUser;
import fr.iscod.coworkia.interfaces.repositories.InternalUserRepository;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InternalUserService implements UserDetailsService {

    private final InternalUserRepository internalUserRepository;

    public InternalUserService(InternalUserRepository internalUserRepository) {
        this.internalUserRepository = internalUserRepository;
    }

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<InternalUser> optUser = internalUserRepository.findByUsername(username);

        if(optUser.isEmpty()) {
            throw new UsernameNotFoundException(username + "not found");
        }

        InternalUser user = optUser.get();
        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), buildGrantedAuthorities());

        return userDetails;
    }

    private List<GrantedAuthority> buildGrantedAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }
}
