package net.eldiosantos.messenger.repository.hibernate;

import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import net.eldiosantos.messenger.repository.hibernate.base.BaseRepository;

import javax.persistence.EntityManager;

public class UserInfoRepositoryHibernateImpl extends BaseRepository<UserInfo, Long> implements UserInfoRepository {

	@Deprecated
	public UserInfoRepositoryHibernateImpl(){
	}

	public UserInfoRepositoryHibernateImpl(EntityManager entityManager) {
		super(entityManager);
	}

    @Override
    public UserInfo validateLogin(String username, String password) {
        return (UserInfo) entityManager.createQuery("select u from UserInfo u where u.login like :login and u.password = :password")
            .setParameter("login", username)
            .setParameter("password", password)
            .getSingleResult();
    }
}
