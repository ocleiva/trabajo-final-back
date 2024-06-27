package com.example.CrudOrders.security;

import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /********** CARGA DE USUARIO POR NOMBRE DE USUARIO **********/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var usuario = getById(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        return User
                .withUsername(username)
                .password(usuario.password())
                .roles(usuario.roles().toArray(new String[0]))
                .build();
    }

    public record Usuario(String username, String password, Set<String> roles) {};

    /********** BÚSQUEDA DE USUARIO POR ID **********/
    public static Usuario getById(String username) {

        var password = "$2a$10$H1v/ZGAGnBp.Znd1FuQvEumR32RHFuLqTe9vSzcERCwz454XNVMKC";

        Usuario OctaMati = new Usuario(
                "OctaMati",
                password,
                Set.of("USER") //
        );

        var usuarios = List.of(ezeUser); //

        return usuarios  // Busca y retorna el usuario que coincide con el nombre de usuario.
                .stream()
                .filter(e -> e.username().equals(username))
                .findFirst()
                .orElse(null);
    }

}

