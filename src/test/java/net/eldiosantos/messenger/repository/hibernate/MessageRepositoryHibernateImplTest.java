package net.eldiosantos.messenger.repository.hibernate;

import net.eldiosantos.messenger.builder.CredentialsBuilder;
import net.eldiosantos.messenger.hashtools.SHAHashProvider;
import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.util.DatabaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityTransaction;
import java.util.List;

import static org.junit.Assert.*;

public class MessageRepositoryHibernateImplTest extends DatabaseTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        getEntityManager().close();
    }

    @Test
    public void testGetFrom() throws Exception {

    }

    @Test
    public void testGetByPk() throws Exception {
        final Message msg = new MessageRepositoryHibernateImpl(getEntityManager()).getByPk(7L);

        assertEquals("Who sent this message?", Long.valueOf(2L), msg.getFrom().getId());
        assertEquals("Who will receive this message?", Long.valueOf(1L), msg.getTo().getId());
    }

    @Test
    public void testListAll() throws Exception {
        final List<Message> msgList = new MessageRepositoryHibernateImpl(getEntityManager()).listAll();

        assertEquals("How many messages we have?", 5, msgList.size());
    }

    @Test
    public void testPersist() throws Exception {
        final CredentialsBuilder builder = new CredentialsBuilder(new SHAHashProvider());
        final Message msg = new Message()
                .setMessage("That's a bingo!")
                .setFrom(
                        builder.start()
                                .login("admin")
                                .password("123")
                                .build()
                                .setId(1L)
                ).setTo(
                        builder.start()
                        .login("eldius")
                        .password("123")
                        .build()
                        .setId(2L)
                );

        final EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        new MessageRepositoryHibernateImpl(getEntityManager()).persist(msg);
        msg.getId();
        tx.commit();

        final Message msg1 = new MessageRepositoryHibernateImpl(getEntityManager()).getByPk(msg.getId());
        assertNotNull("The message have an id?", msg1);

        Thread.sleep(1000);

    }

    @Test
    public void testUpdate() throws Exception {
        final Message msg = new MessageRepositoryHibernateImpl(getEntityManager()).getByPk(7L);
        msg.setMessage(msg.getMessage() + "appended!");
        final EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        new MessageRepositoryHibernateImpl(getEntityManager()).update(msg);
        tx.commit();

        final Message msg1 = new MessageRepositoryHibernateImpl(getEntityManager()).getByPk(msg.getId());
        assertTrue("The message was updated?", msg1.getMessage().endsWith("appended!"));

    }

    @Test
    public void testDelete() throws Exception {
        final Message msg = new MessageRepositoryHibernateImpl(getEntityManager()).getByPk(7L);

        final EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        new MessageRepositoryHibernateImpl(getEntityManager()).delete(msg);
        tx.commit();

        final Message msg1 = new MessageRepositoryHibernateImpl(getEntityManager()).getByPk(7L);
        assertNull("The message was updated?", msg1);
    }

    @Test
    public void testSaveOrUpdateNew() throws Exception {

        final CredentialsBuilder builder = new CredentialsBuilder(new SHAHashProvider());

        final Message msg = new Message()
                .setMessage("A new message!")
                .setFrom(
                        builder.start()
                                .login("admin")
                                .password("123")
                                .build()
                                .setId(1L)
                ).setTo(
                        builder.start()
                                .login("eldius")
                                .password("123")
                                .build()
                                .setId(2L)
                );


        final EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        new MessageRepositoryHibernateImpl(getEntityManager()).saveOrUpdate(msg);
        msg.getId();
        tx.commit();
        msg.getId();

        assertNotNull("The message have an id?", msg.getId());
    }

    @Test
    public void testSaveOrUpdateOld() throws Exception {
        final Message msg = new MessageRepositoryHibernateImpl(getEntityManager()).getByPk(7L);
        msg.setMessage(msg.getMessage() + "\nappended!");

        final EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        new MessageRepositoryHibernateImpl(getEntityManager()).saveOrUpdate(msg);
        tx.commit();

        assertTrue("Update the message!", msg.getMessage().endsWith("appended!"));
    }
}
