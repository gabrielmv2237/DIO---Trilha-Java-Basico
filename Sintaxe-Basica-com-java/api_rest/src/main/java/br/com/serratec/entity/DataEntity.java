package br.com.serratec.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class DataEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "data", cascade = CascadeType.ALL)
	private List<UsuarioEntity> data;
	
	private String isSuccess;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<UsuarioEntity> getData() {
		return data;
	}

	public void setData(List<UsuarioEntity> data) {
		this.data = data;
	}

	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

	
	@Override
	public String toString() {
		return "DataEntity [entity=" + data + ", isSuccess=" + isSuccess + "]";
	}

	
	
}
