package com.hugo.api_hoteles.dao;

import com.hugo.api_hoteles.entities.Usuario;
import com.hugo.api_hoteles.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

    public static Usuario obtener(String nombre) {
        Transaction transaction = null;
        Usuario usuario = null;

        try(Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            usuario = (Usuario) session.createQuery("FROM Usuario WHERE nombre = '" + nombre + "'").list().get(0);
            transaction.commit();


        } catch (Exception e) {

            if(transaction != null)
                transaction.rollback();
        }
        return usuario;
    };
}
