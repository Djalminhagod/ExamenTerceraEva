package club;

public class Tecnico extends Profesional{

    private String puesto;

    public Tecnico(String nombre, double salarioBase, String puesto) {
        super(nombre, salarioBase);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "puesto='" + puesto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", salarioBase=" + salarioBase +
                '}';
    }
}
