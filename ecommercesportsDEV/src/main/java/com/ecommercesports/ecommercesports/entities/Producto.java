package com.ecommercesports.ecommercesports.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProducto;

    @Column(name = "precio")
    private double precio;

    @Column(name = "color")
    private String color;

    @Column(name = "descripcioncorta")
    private String descripcionCorta;

    @Column(name = "descipcionlarga")
    private String descripcionLarga;

    @Column(name = "sku")
    private String sku;

    @Column(name = "talle")
    private String talle;
    
    @OneToOne(cascade = CascadeType.MERGE)
	private Categoria categoria;
    
    @OneToOne(cascade = CascadeType.MERGE)
	private Marca marca;

    @OneToMany(mappedBy="producto")
    private List<Comentario> listaComentarios;
    
    @Column(name = "totalPuntaje")
    private double totalPuntaje;
    
    @Column(name = "cantidadValoraciones")
    private int cantidadValoraciones;

    @ManyToMany(mappedBy = "productos")
    private List<Tag> tags;
    
    @Column(name = "visible")
    private boolean visible;
    
    public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Producto() { }

    public Producto(long idProducto,double precio, String color, String descripcionCorta,
			String descripcionLarga, String sku, String talle, double totalPuntaje, int cantidadValoraciones,
                    List<Tag> tags,boolean visible) {
		super();
		this.idProducto = idProducto;
		this.precio = precio;
		this.color = color;
		this.descripcionCorta = descripcionCorta;
		this.descripcionLarga = descripcionLarga;
		this.sku = sku;
		this.talle = talle;
		this.totalPuntaje = totalPuntaje;
		this.cantidadValoraciones = cantidadValoraciones;
        this.tags = tags;
        this.visible = visible;
    }

	public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCantidadValoraciones() {
		return cantidadValoraciones;
	}

	public void setCantidadValoraciones(int cantidadValoraciones) {
		this.cantidadValoraciones = cantidadValoraciones;
	}

	public List<Comentario> getListaComentarios() {
		return listaComentarios;
	}

	public void setListaComentarios(List<Comentario> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}

	public double getTotalPuntaje() {
		return totalPuntaje;
	}

	public void setTotalPuntaje(double totalPuntaje) {
		this.totalPuntaje = (this.totalPuntaje + totalPuntaje) / this.cantidadValoraciones;
	}

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", precio=" + precio +
                ", color='" + color + '\'' +
                ", descripcionCorta='" + descripcionCorta + '\'' +
                ", descripcionLarga='" + descripcionLarga + '\'' +
                ", sku='" + sku + '\'' +
                ", talle='" + talle + '\'' +
                ", categoria=" + categoria +
                ", marca=" + marca +
                ", listaComentarios=" + listaComentarios +
                ", totalPuntaje=" + totalPuntaje +
                ", cantidadValoraciones=" + cantidadValoraciones +
                ", tags=" + tags +
                '}';
    }
}