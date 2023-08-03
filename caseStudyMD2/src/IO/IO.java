package io;

import java.util.List;

public interface IO<E> {
    void write(List<E> es, String path);

    List<E> read(String path);
}
