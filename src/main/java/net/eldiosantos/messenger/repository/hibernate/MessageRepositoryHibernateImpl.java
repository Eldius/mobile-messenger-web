package net.eldiosantos.messenger.repository.hibernate;

import javax.persistence.EntityManager;

import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.repository.MessageRepository;
import net.eldiosantos.messenger.repository.hibernate.base.BaseRepository;

import java.util.List;

public class MessageRepositoryHibernateImpl extends BaseRepository<Message, Long> implements MessageRepository {

	@Deprecated
	public MessageRepositoryHibernateImpl(){
	}

	public MessageRepositoryHibernateImpl(EntityManager entityManager) {
		super(entityManager);
	}

    @Override
    public List<Message> getFrom(Long begin) {
        return entityManager.createQuery("select m from Message m where u.id > :begin")
                .setParameter("begin", begin)
                .getResultList();

    }
}
