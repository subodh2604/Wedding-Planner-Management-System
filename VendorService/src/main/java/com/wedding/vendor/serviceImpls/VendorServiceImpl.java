package com.wedding.vendor.serviceImpls;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.vendor.dtos.VendorAvailabilityDto;
import com.wedding.vendor.dtos.VendorDto;
import com.wedding.vendor.entities.Vendor;
import com.wedding.vendor.repositories.VendorRepository;
import com.wedding.vendor.services.VendorService;
import com.wedding.vendor.services.VendorService;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public VendorDto register(VendorDto clientDto) {
		
		Vendor client=modelMapper.map(clientDto, Vendor.class);
		
		Vendor savedVendor=vendorRepository.save(client);
		
		VendorDto saveVendorDto=modelMapper.map(savedVendor, VendorDto.class);
		
		return saveVendorDto;
	}

	@Override
	public VendorDto findByVendorId(int vendorId) {
		Vendor vendor=vendorRepository.findById(vendorId).orElseThrow(()->new RuntimeException("Vendor not found!!!!"));
		
		VendorDto vendorDto=modelMapper.map(vendor, VendorDto.class);
		
		return vendorDto;
	}

	@Override
	public List<VendorDto> findByBudgetOrDate(LocalDate weddingDate, Double minBudget, Double maxBudget) {
		List<Vendor> filteredVendors=vendorRepository.findByBudgetRangeOrDate(weddingDate,minBudget,maxBudget);
		
		List<VendorDto> filteredVendorDtos=new ArrayList<>();
		
		filteredVendorDtos=filteredVendors.stream().map((x)->modelMapper.map(x,VendorDto.class)).collect(Collectors.toList());
		
		return filteredVendorDtos;
	}

	@Override
	public VendorDto updateAvailabilityStatus(int vendorId, VendorAvailabilityDto vendorAvailabilityDto) {
		
		Vendor vendor=vendorRepository.findById(vendorId).orElseThrow(()->new RuntimeException("Vendor not found!!!!"));
		
		vendor.setAvailableFrom(vendorAvailabilityDto.getAvailableFrom());
		
		vendor.setAvailableTo(vendorAvailabilityDto.getAvailableTo());
		
		vendor.setAvailabilityStatus(vendorAvailabilityDto.getAvailabilityStatus());
		
		vendorRepository.save(vendor);
		
		VendorDto updatedVendorDto=modelMapper.map(vendor, VendorDto.class);

		return updatedVendorDto;
	}

}
