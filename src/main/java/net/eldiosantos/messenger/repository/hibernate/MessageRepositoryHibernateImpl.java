package net.eldiosantos.messenger.repository.hibernate;

import javax.persistence.EntityManager;

import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.repository.MessageRepository;
import net.eldiosantos.messenger.repository.hibernate.base.BaseRepository;

public class MessageRepositoryHibernateImpl extends BaseRepository<Message, Long> implements MessageRepository {

	@Deprecated
	public MessageRepositoryHibernateImpl(){
	}

	public MessageRepositoryHibernateImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
