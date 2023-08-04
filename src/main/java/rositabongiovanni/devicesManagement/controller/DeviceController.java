package rositabongiovanni.devicesManagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rositabongiovanni.devicesManagement.entities.Device;
import rositabongiovanni.devicesManagement.service.DeviceService;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

	@Autowired
	public DeviceService deviceService;

	@GetMapping("/{id}")
	public Device get(@PathVariable long id) {
		return deviceService.findById(id).get();
	}

		 @PutMapping("/{id}")
		    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Optional<Device> deviceDto) throws Exception{
		        Optional<Device> optDevice = deviceService.findById(id);
		        if (optDevice.isPresent()){
		            Device d = optDevice.get();
		            if(!deviceDto.get().getOwner().equals(null)){
		            d.setOwner(deviceDto.get().getOwner());
		            }
		            if(!deviceDto.get().getDvc_type().equals(null)){
		            d.setDvc_type((deviceDto.get().getDvc_type()));
		            }
		            deviceService.update(d);
		            System.out.println("updated device: "+ d.toString());
		            return ResponseEntity.ok().build();
		        } else {
		            return ResponseEntity.notFound().build();
		        }
		    }
		
			@PostMapping
			public String post(@RequestBody Device dvcDto) {
				Device dvc = deviceService.post(dvcDto.getOwner(), dvcDto.getDvc_type());
				return "added device: " + dvc.toString();
			}
		
			@DeleteMapping(value = "/{id}")
			public ResponseEntity<?> delete(@RequestBody Device e, @PathVariable long id) {
				Optional<Device> optDevice = deviceService.findById(id);
				if (optDevice.isPresent()) {
					System.out.println("deleted device: " + e.toString());
					deviceService.delete(e);
					return ResponseEntity.ok().build();
				} else {
					return ResponseEntity.notFound().build();
				}
			}
	}
