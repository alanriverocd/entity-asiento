package com.excursion.asiento.model;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private int codigo;
    private String mensaje;
    private String info;
    private LocalDateTime fechaHora;
    private String detalle;
    private T data;

    public ApiResponse() {
        this.info = "Sistema de Autobuses SSMA";
        this.fechaHora = LocalDateTime.now();
    }

    public ApiResponse(int codigo, String mensaje, String detalle, T data) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.info = "Sistema de Autobuses SSMA";
        this.fechaHora = LocalDateTime.now();
        this.detalle = detalle;
        this.data = data;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
