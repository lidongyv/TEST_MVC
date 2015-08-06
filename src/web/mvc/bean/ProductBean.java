package web.mvc.bean;

public class ProductBean {

	private String id;
	private String cateid;
	private String name;
	private String publisher;
	private float price;
	private String desc;

	public ProductBean() {
	}

	public ProductBean(String id, String cateid, String name, String pub,
			float price, String desc) {
		this.id = id;
		this.cateid = cateid;
		this.name = name;
		this.publisher = pub;
		this.price = price;
		this.desc = desc;
	}

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
