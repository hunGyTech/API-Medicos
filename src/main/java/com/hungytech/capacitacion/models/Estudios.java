package com.hungytech.capacitacion.models;
import java.awt.image.BufferedImage;
public class Estudios {
    private TipoEstudio tipoEstudio;
    private String nombreEstudio;
    private String diagnostico;
    private Float precio;
    private BufferedImage imagen; //BufferedImage representa imagenes Raster (JPEG, PNG, BMP y TIFF) para manejar magenes vectoriales (SVG) se podria usar a biblioteca externa ApacheBatik
    //private String imagen; <<Almaceno la ruta de la imagen>>

    public Estudios(TipoEstudio tipoEstudio, String nombreEstudio, String diagnostico, Float precio, BufferedImage imagen) {
        this.tipoEstudio = tipoEstudio;
        this.nombreEstudio = nombreEstudio;
        this.diagnostico = diagnostico;
        this.precio = precio;
        this.imagen = imagen ;
    }


}