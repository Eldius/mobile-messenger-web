package net.eldiosantos.messenger.repository.interfaces;

import java.io.Serializable;

public interface Write<T, K extends Serializable>
{
    public void persist(T element);

	void update(T element);
}