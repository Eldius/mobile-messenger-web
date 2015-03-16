package net.eldiosantos.messenger.repository.hibernate;

import javax.persistence.EntityManager;

import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.model.auth.UserInfo;
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
    public List<Message> getFrom(final UserInfo to, final Long begin) {
        return (List<Message>)entityManager.createQuery("select m from Message m where m.id > :begin and m.to.id = :toId")
                .setParameter("begin", begin)
                .setParameter("toId", to.getId())
                .getResultList();
    }
}
