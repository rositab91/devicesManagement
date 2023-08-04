package rositabongiovanni.devicesManagement.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
	@Id
	@SequenceGenerator(name = "employees_ids", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_ids")
	private long employee_id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String fullname;
	@Column(nullable = false, unique = true)
	private String email;
	@OneToMany(mappedBy = "owner")
	private List<Device> employee_devices = new ArrayList<Device>();

	public Employee(String username, String fullname, String email) {
		this.username = username;
		this.fullname = fullname;
		this.email = email;
	}

	public Employee(String username, String fullname, String email, List<Device> employee_devices) {
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.employee_devices = employee_devices;
	}

	@Override
	public String toString() {
		return "[employee_id=" + employee_id + ", username=" + username + ", fullname=" + fullname + ", email=" + email
				+ ", employee_devices=" + employee_devices + "]";
	}
}