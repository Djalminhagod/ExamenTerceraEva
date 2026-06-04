package club;

public interface Bonificable {
    public default double plusSalarial(double salario, double plus){
        return salario+plus;
    };
}
