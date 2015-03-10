package net.eldiosantos.messenger.converter;

import net.eldiosantos.messenger.auth.RESTUserKeyExtractor;
import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import net.eldiosantos.messenger.vo.MessageVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageConverterTest {

    @Mock
    private UserInfoRepository userInfoRepository;

    @Mock
    private RESTUserKeyExtractor userKeyExtractor;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFromVo() throws Exception {
        final MessageVO vo = new MessageVO()
                .setFrom(1L)
                .setTo(2L)
                .setMessage("It's a great message!");

        final String token = "it's a token, ok?";

        Mockito.when(userKeyExtractor.extract()).thenReturn(token);

        final UserInfo from = new UserInfo()
                .setId(1L)
                .setLogin("greatUserSQN");
        Mockito.when(userInfoRepository.validateToken(token)).thenReturn(from);

        final UserInfo to = new UserInfo()
                .setId(2L)
                .setLogin("anotherGreatUserSQN");
        Mockito.when(userInfoRepository.getByPk(2L)).thenReturn(to);

        final MessageConverter messageConverter = new MessageConverter(userInfoRepository, userKeyExtractor);

        final Message msg = messageConverter.fromVo(vo);

        assertEquals("Validating message itself", vo.getMessage(), msg.getMessage());
        assertEquals("Validating sender", vo.getFrom(), msg.getFrom().getId());
        assertEquals("Validating receiver", vo.getTo(), msg.getTo().getId());
    }

    @Test
    public void testToVo() throws Exception {
        final UserInfo from = new UserInfo()
                .setId(1L)
                .setLogin("greatUserSQN");

        final UserInfo to = new UserInfo()
                .setId(2L)
                .setLogin("anotherGreatUserSQN");

        final Message msg = new Message()
                .setFrom(from)
                .setTo(to)
                .setMessage("The answer is 43, but what's the question?");

        final MessageConverter messageConverter = new MessageConverter(userInfoRepository, userKeyExtractor);
        final MessageVO vo = messageConverter.toVo(msg);

        assertEquals("Validating the message", msg.getMessage(), vo.getMessage());
        assertEquals("Validating the sender name", from.getLogin(), vo.getFromName());
    }

    @Test
    public void testToVoList() throws Exception {
        final UserInfo from = new UserInfo()
                .setId(1L)
                .setLogin("greatUserSQN");

        final UserInfo to = new UserInfo()
                .setId(2L)
                .setLogin("anotherGreatUserSQN");

        List<Message>msgList = new ArrayList<Message>();

        final Message msg1 = new Message()
                .setFrom(from)
                .setTo(to)
                .setMessage("The answer is 43, but what's the question?");
        final Message msg2 = new Message()
                .setFrom(to)
                .setTo(from)
                .setMessage("I have no idea...");

        msgList.add(msg1);
        msgList.add(msg2);

        final MessageConverter messageConverter = new MessageConverter(userInfoRepository, userKeyExtractor);
        final List<MessageVO> vos = messageConverter.toVo(msgList);

        assertEquals("List size", 2, vos.size());
    }
}