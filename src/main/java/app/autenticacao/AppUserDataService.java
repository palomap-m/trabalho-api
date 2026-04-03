package app.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDataService implements UserDetailsService {
    @Autowired
    private UsuarioRepository UsuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
        
        Usuario usuario = UsuarioRepo.findByNomeDeUsuario(username);

        if(usuario == null) {
            throw new UsernameNotFoundException("Usuário não Encontrado");
        }

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
            .username(usuario.getNomeDeUsuario())
            .password(usuario.getSenha())
            .roles("USER")
            .build();
        
        return userDetails;
    }

}