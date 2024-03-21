import javax.persistence.Entity;

@Entity
public enum TipoEstudio{
    BIOPSIA(100),
    COLONOSCOPIA(101),
    DENSITOMETRIA-OSEA(102),
    ECOCARDIOGRAMA(103),
    ECOGRAFIA(104),
    ELECTROCARDIOGRAMA(105),
    ENDOSCOPIA(106),
    ERGOMETRIA(107),
    HEMOGRAMA(108),
    MAMOGRAFIA(109),
    RADIOGRAFIA(110),
    RESONANCIA(111),
    TOMOGRAFIA(112);

    private final int codigo;
    TipoEstudio(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }

}