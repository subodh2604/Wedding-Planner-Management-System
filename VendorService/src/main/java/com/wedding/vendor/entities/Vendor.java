package com.wedding.vendor.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendorId;
	
	private String vendorName;
	
	private String email;
	
	private String phone;
	
	private String serviceType;
	
	@JsonFormat(pattern = "dd-mm-yyyy")
	private LocalDate availableFrom;
	
	@JsonFormat(pattern = "dd-mm-yyyy")
	private LocalDate availableTo;

	private String availabilityStatus;

}
