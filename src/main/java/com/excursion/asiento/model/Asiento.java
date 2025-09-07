package com.excursion.asiento.model;

public class Asiento {
    private Long idAsiento;
    private String numero;
    private Long idAutobus;
    private String disponible;

    public Long getIdAsiento() { return idAsiento; }
    public void setIdAsiento(Long idAsiento) { this.idAsiento = idAsiento; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public Long getIdAutobus() { return idAutobus; }
    public void setIdAutobus(Long idAutobus) { this.idAutobus = idAutobus; }

    public String getDisponible() { return disponible; }
    public void setDisponible(String disponible) { this.disponible = disponible; }
}