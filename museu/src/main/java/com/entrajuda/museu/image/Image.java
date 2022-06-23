package com.entrajuda.museu.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
	@Id
	@Column(name = "image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer image_id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "image")
	private byte[] image;

    public Image(){}

    public Image( String name, String type, byte[] image){
        this.name = name;
        this.type = type;
        this.image = image;
    }
    public Image(Integer image_id, String name, String type, byte[] image){
        this.image_id = image_id;
        this.name = name;
        this.type = type;
        this.image = image;
    }

    public Integer getImage_Id(){
        return image_id;
    }

    public void setImage_Id(Integer image_id){
        this.image_id = image_id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public byte[] getImage(){
        return image;
    }

    public void setImage(byte[] image){
        this.image = image;
    }


}