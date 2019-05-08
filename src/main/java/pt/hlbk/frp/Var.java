package pt.hlbk.frp;

import java.util.function.BiFunction;

public interface Var<T> {
    T now();
    void mutate(final T newValue);
    Var<T> op(BiFunction<T, T, T> fun, Var<T> dep);
}
