package pt.hlbk.frp;

public class Main {

    public static void main(String[] args) {
        var a = new SimpleVar<>(1);
        var b = new SimpleVar<>(2);
        var c = a.op(Integer::sum, b);

        System.out.println(c.now()); //equals to 3

        a.mutate(2);

        System.out.println(c.now()); //equals to 4

        var d = new SimpleVar<>(1);
        var e = c.op((x, y) -> x - y, d);

        System.out.println(e.now()); // equals to 4

        a.mutate(3);

        System.out.println(c.now()); //equals to 5
        System.out.println(e.now()); // equals to 4
    }
}
