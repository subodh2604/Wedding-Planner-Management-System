package com.wedding.vendor.services;

import java.time.LocalDate;
import java.util.List;

import com.wedding.vendor.dtos.VendorAvailabilityDto;
import com.wedding.vendor.dtos.VendorDto;

public interface VendorService {
	public VendorDto register(VendorDto VendorDto);

	public VendorDto findByVendorId(int vendorId);

	public List<VendorDto> findByBudgetOrDate(LocalDate weddingDate, Double minBudget, Double maxBudget);

	public VendorDto updateAvailabilityStatus(int vendorId, VendorAvailabilityDto vendorAvailabilityDto);
}
