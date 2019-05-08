package pt.hlbk.frp;

import java.util.function.BiFunction;

public class SimpleVar<T> implements Var<T> {

    private T value; //TODO makes this a atomic reference? or VarHandle

    public SimpleVar(final T value) {
        this.value = value;
    }

    @Override
    public T now() {
        return value;
    }

    @Override
    public void mutate(final T newValue) {
        value = newValue;
    }

    @Override
    public Var<T> op(BiFunction<T, T, T> fun, Var<T> dep) {
        return new CompositeVar<>(fun, this, dep);
    }
}
