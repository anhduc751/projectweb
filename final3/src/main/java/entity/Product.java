package entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pid")
    private int pid;
    private String pname;
    private String pimage;
    private double pprice;
    private String ptitle;
    private String pdescription;

    public Product() {
    }

    public Product(int id, String name, String image, double price, String title, String description) {
        super();
    	this.pid = id;
        this.pname = name;
        this.pimage = image;
        this.pprice = price;
        this.ptitle = title;
        this.pdescription = description;
    }

    public int getId() {
        return pid;
    }

    public void setId(int id) {
        this.pid = id;
    }

    public String getName() {
        return pname;
    }

    public void setName(String name) {
        this.pname = name;
    }

    public String getImage() {
        return pimage;
    }

    public void setImage(String image) {
        this.pimage = image;
    }

    public double getPrice() {
        return pprice;
    }

    public void setPrice(double price) {
        this.pprice = price;
    }

    public String getTitle() {
        return ptitle;
    }

    public void setTitle(String title) {
        this.ptitle = title;
    }

    public String getDescription() {
        return pdescription;
    }

    public void setDescription(String description) {
        this.pdescription = description;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + pid + ", name=" + pname + ", image=" + pimage + ", price=" + pprice + ", title=" + ptitle + ", description=" + pdescription + '}';
    }
}