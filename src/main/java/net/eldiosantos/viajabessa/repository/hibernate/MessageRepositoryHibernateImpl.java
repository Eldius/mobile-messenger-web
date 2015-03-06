package net.eldiosantos.viajabessa.repository.hibernate;

import javax.persistence.EntityManager;

import net.eldiosantos.viajabessa.model.Message;
import net.eldiosantos.viajabessa.repository.MessageRepository;
import net.eldiosantos.viajabessa.repository.hibernate.base.BaseRepository;

public class MessageRepositoryHibernateImpl extends BaseRepository<Message, Long> implements MessageRepository {

	@Deprecated
	public MessageRepositoryHibernateImpl(){
	}

	public MessageRepositoryHibernateImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
