package com.forever.tesistas.web.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.forever.tesistas.web.pojo.Login;

public class UsuarioDAO extends BaseHibernateDAO {
    public Usuario login(Login login) {
        Criteria criteria = getSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("email", login.getMail()))
                .add(Restrictions.eq("password", login.getPassword()));
        return (Usuario) criteria.uniqueResult();
    }

    public void saveUsuario(Usuario usuario) {
        super.save(usuario);
    }

    public void updateUsuario(Usuario usuario) {
        super.saveOrUpdate(usuario);
    }
}
