package net.eldiosantos.messenger.converter;

import net.eldiosantos.messenger.auth.RESTUserKeyExtractor;
import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import net.eldiosantos.messenger.vo.MessageVO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by eldio.junior on 10/03/2015.
 */
public class MessageConverter {

    @Inject
    private UserInfoRepository userInfoRepository;

    @Inject
    private RESTUserKeyExtractor userKeyExtractor;

    @Deprecated
    public MessageConverter() {
    }

    public MessageConverter(UserInfoRepository userInfoRepository, RESTUserKeyExtractor userKeyExtractor) {
        this.userInfoRepository = userInfoRepository;
        this.userKeyExtractor = userKeyExtractor;
    }

    public Message fromVo(final MessageVO vo) {
        final Message msg = new Message()
                .setFrom(userInfoRepository.validateToken(userKeyExtractor.extract()))
                .setTo(userInfoRepository.getByPk(vo.getTo()))
                .setMessage(vo.getMessage())
                .setSentDate(new Date());
        return msg;
    }

    public List<MessageVO>toVo(final List<Message>msgs) {
        final List<MessageVO> vos = new ArrayList<MessageVO>();

        for(Message msg: msgs) {
            vos.add(toVo(msg));
        }

        return vos;
    }

    public MessageVO toVo(final Message msg) {
        return new MessageVO()
                .setFrom(msg.getFrom().getId())
                .setTo(msg.getTo().getId())
                .setMessage(msg.getMessage())
                .setFromName(msg.getFrom().getLogin())
                .setMsgId(msg.getId());
    }
}
