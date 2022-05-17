package com.jobiak.empapi.resources;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//import com.jobiak.empapi.Model;
import com.jobiak.empapi.model.Mobile;
import com.jobiak.empapi.service.MobileService;

@RestController
@RequestMapping("/catalog")
public class Product {

 @Autowired
 MobileService service;
	
	
 @GetMapping(value="/display",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Mobile>showAll(){
  return service.getAll();
 }
	
	
	
	
	
	
 @GetMapping(value="/mobile",produces=MediaType.APPLICATION_JSON_VALUE)
 public Mobile showCatalog()
 {
  Mobile mobile=new Mobile();
  mobile.setBrand("Samsung");
  mobile.setModel("E2FH,,Dual Camera,32GB Memory,I got you");
  mobile.setPrice(49999);
 return mobile;
 }
	
	
 @GetMapping("/intro")
 public String introduction() {
  return new String("The #1 Manfacture of Digital Mobiles in Asia");
 }
	
 @GetMapping("/search/{modelId}/brand/{brand}")
 public String searchModel(@PathVariable(value="modelId")String modelId,@PathVariable(value="brand")String brand) {
  return new String(modelId+brand+"currently not available for your location");
 }
	
 @PostMapping(value="/create",consumes =MediaType.APPLICATION_JSON_VALUE,
   produces=MediaType.APPLICATION_JSON_VALUE)
 public Mobile addProduct(@RequestBody Mobile mobile) {
  
  
  //System.out.println(mobile);
  //repo.save(mobile);
  Mobile ref= service.addMobile(mobile);
  return ref;
 }
	
 @PutMapping(value="/modify",consumes =MediaType.APPLICATION_JSON_VALUE,
   produces=MediaType.APPLICATION_JSON_VALUE)
 public Mobile modifyProduct(@RequestBody Mobile mobile) {
  Mobile ref =service.modifyMobile(mobile);
  return ref;
 }
	
 @DeleteMapping(value="/delete/{mid}")
 public void removeProduct(@PathVariable(value="mid")Long mid) {

  System.out.println(mid);
  service.removeProduct(mid);
  
 }
}
