package net.eldiosantos.messenger.service;

import net.eldiosantos.messenger.auth.RESTUserKeyExtractor;
import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.MessageRepository;
import net.eldiosantos.messenger.repository.UserInfoRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by eldio.junior on 16/03/2015.
 */
public class GetUserMessages {

    @Inject
    private RESTUserKeyExtractor userKeyExtractor;

    @Inject
    private MessageRepository messageRepository;

    @Inject
    private UserInfoRepository userInfoRepository;

    public List<Message>list() {
        return list(0L);
    }

    public List<Message> list(final Long fromMsgId) {
        final UserInfo user = userInfoRepository.validateToken(userKeyExtractor.extract());
        return messageRepository.getFrom(user, fromMsgId);
    }
}
