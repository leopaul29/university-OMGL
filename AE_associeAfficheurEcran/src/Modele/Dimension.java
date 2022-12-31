package Modele;

public class Dimension {
	private float height;
	private float width;
	private float rapport;
	
	public Dimension(float width, float height){
		this.height = height;
		this.width = width;
		this.rapport = width/height;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getRapport() {
		return rapport;
	}

	public void setRapport(float rapport) {
		this.rapport = rapport;
	}
	

	public boolean equals(Dimension d){
		if(this.rapport == d.rapport)
			return true;
		else return false;
	}

	@Override
	public String toString() {
		return "Dimension [height=" + height + ", width=" + width
				+ ", rapport=" + rapport + "]";
	}
	
}