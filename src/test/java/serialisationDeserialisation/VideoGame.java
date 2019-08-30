package serialisationDeserialisation;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class VideoGame implements Serializable{
	
	public int id=0;
	public String name;
	public String releaseDate;
	public int reviewScore=0;
	public String category;
	public String ratiing;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRatiing() {
		return ratiing;
	}
	public void setRatiing(String ratiing) {
		this.ratiing = ratiing;
	}
	@Override
	public String toString() {
		return "VideoGame [id=" + id + ", name=" + name + ", releaseDate=" + releaseDate + ", reviewScore="
				+ reviewScore + ", category=" + category + ", ratiing=" + ratiing + "]";
	}
	
	
	

}
