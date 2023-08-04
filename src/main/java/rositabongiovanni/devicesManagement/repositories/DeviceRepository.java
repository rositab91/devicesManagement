package rositabongiovanni.devicesManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rositabongiovanni.devicesManagement.entities.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}