package fit.iuh.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Pattern(regexp = "^[A-Za-z0-9]{1,10}$", message = "Mã code chỉ được chứa chữ và số, không có khoảng trắng, tối đa 10 ký tự")
	private String code;

	@Pattern(regexp = "^[A-Za-z0-9]{1,50}$", message = "Tên sản phẩm chỉ được chứa chữ và số, không có khoảng trắng, tối đa 50 ký tự")
	private String name;

	@Positive(message = "Giá sản phẩm phải lớn hơn 0")
	private float price;

	@Size(max = 1000, message = "Mô tả tối đa 1000 ký tự")
	private String description;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	private String register;

	private LocalDate date;

	private Boolean isActive;

	public Product() {
		super();
	}

	public Product(int id,
			@Pattern(regexp = "^[A-Za-z0-9]{1,10}$", message = "Mã code chỉ được chứa chữ và số, không có khoảng trắng, tối đa 10 ký tự") String code,
			@Pattern(regexp = "^[A-Za-z0-9]{1,50}$", message = "Tên sản phẩm chỉ được chứa chữ và số, không có khoảng trắng, tối đa 50 ký tự") String name,
			@Positive(message = "Giá sản phẩm phải lớn hơn 0") float price,
			@Size(max = 1000, message = "Mô tả tối đa 1000 ký tự") String description, Category category,
			String register, LocalDate date, Boolean isActive) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.register = register;
		this.date = date;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}