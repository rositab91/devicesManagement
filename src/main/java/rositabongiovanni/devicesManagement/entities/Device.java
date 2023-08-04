package rositabongiovanni.devicesManagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rositabongiovanni.devicesManagement.Common.dvc_status;
import rositabongiovanni.devicesManagement.Common.dvc_type;

@Entity
@Table(name = "devices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Device {
	@Id
	    @SequenceGenerator(name = "devices_ids", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "devices_ids")
	    private long device_id;
	    @ManyToOne
	    private Employee owner;
	    @Column(nullable = false)
	    private dvc_type dvc_type;
		private dvc_status status = dvc_status.ASSIGNED;

	    public Device(dvc_type dvc_type) {
	        this.dvc_type = dvc_type;
	    }
	    public Device(Employee owner, dvc_type dvc_type) {
	        this.owner = owner;
			this.dvc_type = dvc_type;
	    }

	    @Override
	    public String toString() {
	        return "[device_id=" + device_id + ", owner=" + owner + ", dvc_type=" + dvc_type + ", dvc_status="
	                + status + "]";
	    }      
	    
	}