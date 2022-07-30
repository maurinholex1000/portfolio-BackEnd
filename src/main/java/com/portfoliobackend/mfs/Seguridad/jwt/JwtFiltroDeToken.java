package com.portfoliobackend.mfs.Seguridad.jwt;

import com.portfoliobackend.mfs.Seguridad.Servicio.UsuarioDetalleImp;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;


public class JwtFiltroDeToken extends OncePerRequestFilter{
    private final static Logger logger = LoggerFactory.getLogger(JwtProveedor.class);
    
    @Autowired
    JwtProveedor jwtProveedor;
    @Autowired
    UsuarioDetalleImp userDetalleServicioImp;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(request);
            if(token != null && jwtProveedor.validarToken(token)){
                String nombreUsuario = jwtProveedor.getNombreUsuarioDeToken(token);
                UserDetails usuarioDetalle = userDetalleServicioImp.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuarioDetalle,
                null, usuarioDetalle.getAuthorities()); 
                SecurityContextHolder.getContext().setAuthentication(auth);            
            } 
        }catch (Exception e){
           logger.error("Fallo el metodo doFilterInternal");
        }
        filterChain.doFilter(request, response);
        }
     
        private String getToken(HttpServletRequest request){
            String header = request.getHeader("Authorization");
            if(header != null && header.startsWith("Bearer"))
                return header.replace("Bearer", "");
            return null;
        }
    
    }

