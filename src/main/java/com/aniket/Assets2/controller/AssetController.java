package com.aniket.Assets2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniket.Assets2.entity.Assets;
import com.aniket.Assets2.service.AssetService;

@RestController
@RequestMapping("/asset")
public class AssetController {

	@Autowired
	AssetService service;

	@GetMapping
	public List<Assets> listAssets() {
		return service.listAllAsset();
	}

	@PostMapping
	public Assets addAsset(@RequestBody Assets a) {
		return service.addAsset(a);
	}

	@GetMapping(value = "{name}")
	public Assets listAsset(@PathVariable String name) {
		return service.findByName(name);
	}

	@PostMapping(value = "{id}")
	public Assets updateAsset(@PathVariable Long id, @RequestBody Assets a) {
		return service.updateAsset(id, a);
	}

	@PostMapping(value = "/assign/{id}")
	public Assets assignAssetToEmployee(@PathVariable Long id) {
		return service.assignEmployee(id);
	}

	@PostMapping(value = "/recover/{id}")
	public Assets recoverAsset(@PathVariable Long id) {
		return service.recoverAssign(id);
	}

	@PostMapping(value = "/delete/{id}")
	public Assets deleteAsset(@PathVariable Long id) {
		return service.delete(id);
	}

}
