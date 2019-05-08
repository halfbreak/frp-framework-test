package pt.hlbk.frp;

import java.util.function.BiFunction;

public class CompositeVar<T> implements Var<T> {

    private BiFunction<T, T, T> fun;
    private Var<T> dep1;
    private Var<T> dep2;

    public CompositeVar(BiFunction<T, T, T> fun, Var<T> dep1, Var<T> dep2) {
        this.fun = fun;
        this.dep1 = dep1;
        this.dep2 = dep2;
    }

    @Override
    public T now() {
        return fun.apply(dep1.now(), dep2.now());
    }

    @Override
    public void mutate(T newValue) {
        //TODO what to do here? maybe it can't be mutated
    }

    @Override
    public Var<T> op(BiFunction<T, T, T> fun, Var<T> dep) {
        return new CompositeVar<>(fun, this, dep);
    }
}
