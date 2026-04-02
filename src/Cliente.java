public class Cliente extends Persona{
    private String plan;

    public Cliente(String nombre, String apellido, String email, String dni, String plan) {
        super(nombre, apellido, email, dni);
        this.plan = plan;
    }


    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }


}
