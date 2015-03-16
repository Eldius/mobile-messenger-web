package net.eldiosantos.messenger.service;

import net.eldiosantos.messenger.converter.MessageConverter;
import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.repository.MessageRepository;
import net.eldiosantos.messenger.vo.MessageVO;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 16/03/2015.
 */
public class SaveMessage {

    @Inject
    private MessageRepository messageRepository;

    @Inject
    private MessageConverter messageConverter;

    public MessageVO save(final MessageVO vo) {
        final Message msg = messageConverter.fromVo(vo);
        messageRepository.persist(msg);
        return messageConverter.toVo(msg);
    }
}
