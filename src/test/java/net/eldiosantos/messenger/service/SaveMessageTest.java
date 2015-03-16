package net.eldiosantos.messenger.service;

import net.eldiosantos.messenger.builder.CredentialsBuilder;
import net.eldiosantos.messenger.converter.MessageConverter;
import net.eldiosantos.messenger.hashtools.SHAHashProvider;
import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.MessageRepository;
import net.eldiosantos.messenger.vo.MessageVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SaveMessageTest {

    @Mock
    private MessageRepository messageRepository;

    @Mock
    private MessageConverter messageConverter;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSave() throws Exception {
        final MessageVO vo = new MessageVO(null, 1L, 2L, "How can I use this shit?", null);
        final MessageVO returnedVo = new MessageVO(69L, 1L, 2L, "How can I use this shit?", "aUser");
        final CredentialsBuilder credentialsBuilder = new CredentialsBuilder(new SHAHashProvider());
        final UserInfo fromUser = credentialsBuilder.start()
                .login("aUser")
                .password("123")
                .build()
                .setId(1L);
        final UserInfo toUser = credentialsBuilder.start()
                .login("anotherUser")
                .password("123")
                .build()
                .setId(2L);

        final Message msg = new Message()
                .setFrom(fromUser)
                .setTo(toUser)
                .setMessage("How can I use this shit?");

        Mockito.when(messageConverter.fromVo(vo)).thenReturn(msg);

        Mockito.when(messageConverter.toVo(msg)).thenReturn(returnedVo);

        final MessageVO saved = new SaveMessage(messageRepository, messageConverter).save(vo);

        assertNotNull("Saved a new message?", saved);
        assertNotNull("Saved message has a from name?", saved.getFromName());

    }
}
