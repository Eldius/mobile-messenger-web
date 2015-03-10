package net.eldiosantos.messenger.repository.interfaces;

import java.io.Serializable;

public interface Delete<T, K extends Serializable>
{
    void delete(T element);
}
