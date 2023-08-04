package rositabongiovanni.devicesManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rositabongiovanni.devicesManagement.Common.dvc_type;
import rositabongiovanni.devicesManagement.entities.Device;
import rositabongiovanni.devicesManagement.entities.Employee;
import rositabongiovanni.devicesManagement.repositories.DeviceRepository;

@Service
public class DeviceService {
	 @Autowired public DeviceRepository deviceRepo;
	 
	  public void save(Device e){
	        deviceRepo.save(e);
	    }
	    public void saveAndFlush(Device e){
	        deviceRepo.saveAndFlush(e);
	    }
	    public void update(Device e){
	        deviceRepo.save(e);
	    }
	    public void delete(Device e){
	        deviceRepo.delete(e);
	    }
	    public Optional<Device> findById(long id){
	        return deviceRepo.findById(id);
	    }

		public Device post(Employee o, dvc_type dt) {
	        Device d = new Device(o, dt);
	        deviceRepo.saveAndFlush(d);
	        return d;
	    }
	}

