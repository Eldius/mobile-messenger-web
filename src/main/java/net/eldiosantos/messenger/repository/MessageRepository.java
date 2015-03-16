package net.eldiosantos.messenger.repository;

import net.eldiosantos.messenger.model.Message;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.interfaces.Repository;

import java.util.List;

public interface MessageRepository extends Repository<Message, Long> {

    List<Message>getFrom(UserInfo to, Long begin);
}
