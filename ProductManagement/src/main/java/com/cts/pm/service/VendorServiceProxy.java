//package com.cts.pm.service;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.cts.pm.entities.Vendor;
//
//public interface VendorServiceProxy {
//	@RequestMapping(method=RequestMethod.GET ,value="/byId")
//	void getVendorById(@PathVariable Long vandor_Id);
//	
//	@RequestMapping(method=RequestMethod.GET,value="/all")
//	List<Vendor> getOrder(Vendor vendor);
//
//}
