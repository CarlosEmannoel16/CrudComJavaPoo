package Model;

public class Curso {
	private Integer id;
	private String nome;
	private Area area;
	private String cargaHoraria;

 
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

  
    public void setNome(String nome) {
        this.nome = nome;
    }

 
    public Area getArea() {
        return area;
    }

 
    public void setArea(Area area) {
        this.area = area;
    }

   
    public String getCargaHoraria() {
        return cargaHoraria;
    }

 
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
	

}
