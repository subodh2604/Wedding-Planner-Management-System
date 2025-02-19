package com.wedding.vendor.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.vendor.dtos.VendorAvailabilityDto;
import com.wedding.vendor.dtos.VendorDto;
import com.wedding.vendor.services.VendorService;

@RestController
@RequestMapping("/vendors")
public class VendorController {
	
	@Autowired
	private VendorService vendorService;
	
	@PostMapping("/")
	public ResponseEntity<VendorDto> register(@RequestBody VendorDto VendorDto)
	{
		
		VendorDto savedVendorDto=vendorService.register(VendorDto);
		
		
		return new ResponseEntity<>(savedVendorDto,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{vendorId}")
	public ResponseEntity<VendorDto> findByvendorId(@PathVariable("vendorId") int vendorId)
	{
		
		VendorDto savedVendorDto=vendorService.findByVendorId(vendorId);
		
		
		return new ResponseEntity<>(savedVendorDto,HttpStatus.OK);
		
	}
	
	@PutMapping("/{vendorId}/updateAvailability")
	public ResponseEntity<VendorDto> updateAvailabilityStatus(@PathVariable("vendorId") int vendorId,@RequestBody VendorAvailabilityDto vendorAvailabilityDto)
	{
		
		VendorDto savedVendorDto=vendorService.updateAvailabilityStatus(vendorId,vendorAvailabilityDto);
		
		
		return new ResponseEntity<>(savedVendorDto,HttpStatus.OK);
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<VendorDto>> findByBudgetOrDate(@RequestParam(required = false,name = "weddingDate") @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate weddingDate,
			@RequestParam(required = false,name = "minBudget") Double minBudget,@RequestParam(required = false,name = "maxBudget") Double maxBudget)
	{
		
		List<VendorDto> savedVendorDtos=vendorService.findByBudgetOrDate(weddingDate,minBudget,maxBudget);
		
		
		return new ResponseEntity<>(savedVendorDtos,HttpStatus.OK);
		
	}
}
