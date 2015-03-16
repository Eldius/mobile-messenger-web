package net.eldiosantos.messenger.service;

import net.eldiosantos.messenger.auth.RESTUserKeyExtractor;
import net.eldiosantos.messenger.converter.MessageConverter;
import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.MessageRepository;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import net.eldiosantos.messenger.vo.MessageVO;

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

    @Inject
    private MessageConverter messageConverter;

    public List<MessageVO>list() {
        return list(0L);
    }

    public List<MessageVO> list(final Long fromMsgId) {
        final UserInfo user = userInfoRepository.validateToken(userKeyExtractor.extract());
        return messageConverter.toVo(messageRepository.getFrom(user, fromMsgId));
    }
}
