public class Materia {
    private String nombreMateria;
    private double calificacion;

    public Materia(String nombreMateria, double calificacion) {
        this.nombreMateria = nombreMateria;
        this.calificacion = calificacion;
    }

    public Materia(String nombreMateria) {
        this.nombreMateria = nombreMateria;
        this.calificacion = calificacion;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
