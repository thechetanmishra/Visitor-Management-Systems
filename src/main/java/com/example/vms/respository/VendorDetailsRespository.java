package com.example.vms.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vms.entity.VendorDetails;
import com.example.vms.model.Visitors;

@Repository
public interface VendorDetailsRespository extends JpaRepository<VendorDetails, Integer> {
	//List<Visitors> findByLastnameIgnoreCase(String lastname);
	VendorDetails findByQrCode(String qrCode);
}
