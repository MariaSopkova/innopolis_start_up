package ru.innopolis.stc12.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.innopolis.stc12.pojo.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebUserDetails implements UserDetails {

  private final List<String> actions;
  private final User user;

  public WebUserDetails(User user, List<String> actions) {
    this.user = user;
    this.actions = actions;
  }

  public int getUserId() {
    return 1; /*user.getEntityId();*/
  }

  @Override public String getUsername() {
    return "admin";//user.getUsername();
  }

  public String getParentUsername() {
    return "";/*user.getParentUsername()*/
  }

  @Override public String getPassword() {
    return "$2a$10$TCb2SAXxB4NeG5p9xTcsFuM.l3NtOJ.3FCZC7OQblzOU0.r7HfHWS";//user.getPassword();
  }

  public String getRole() {
    return Role.ROLE_SUPERUSER;/*user.getRole();*/
  }

  @Override public boolean isEnabled() {
    return true; /*user.isEnabled();*/
  }

  @Override public Collection<GrantedAuthority> getAuthorities() {
    Set<GrantedAuthority> auths = new HashSet<>();
    for (String action : actions) {
      auths.add(new SimpleGrantedAuthority(action));
    }
    return auths;
  }

  @Override public boolean isAccountNonExpired() {
    return true; // for the time being
  }

  @Override public boolean isAccountNonLocked() {
    return true; // for the time being
  }

  @Override public boolean isCredentialsNonExpired() {
    return true; // for the time being
  }
}
