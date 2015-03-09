package net.eldiosantos.messenger.repository.hibernate;

import net.eldiosantos.messenger.model.config.ServerConfig;
import net.eldiosantos.messenger.repository.ServerConfigRepository;
import net.eldiosantos.messenger.repository.hibernate.base.BaseRepository;

import javax.persistence.EntityManager;

public class ServerConfigRepositoryHibernateImpl extends BaseRepository<ServerConfig, String> implements ServerConfigRepository {

	@Deprecated
	public ServerConfigRepositoryHibernateImpl(){
	}

	public ServerConfigRepositoryHibernateImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
