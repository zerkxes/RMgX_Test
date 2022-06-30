package com.aniket.Assets2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.Assets2.Repository.AssetsRepository;
import com.aniket.Assets2.entity.Assets;

@Service
public class AssetService {

	@Autowired
	AssetsRepository assetRepo;

	public Assets addAsset(Assets a) {
		assetRepo.save(a);
		return a;
	}

	public List<Assets> listAllAsset() {
		List<Assets> l = new ArrayList<>();
		for (Assets a : assetRepo.findAll()) {
			l.add(a);
		}
		return l;
	}

	public Assets findByName(String name) {
		return assetRepo.findByName(name);
	}

	public Assets updateAsset(Long id, Assets input) {
		Optional<Assets> a = assetRepo.findById(id);
		if (a.isPresent()) {
			a.get().setName(input.getName());
			a.get().setCondition(input.getCondition());
			a.get().setPurchaseDate(input.getPurchaseDate());
			a.get().setCat(input.getCat());
			a.get().setAssignmentStatus(input.getAssignmentStatus());
			return a.get();
		} else
			return null;
	}

	public Assets assignEmployee(Long id) {
		Optional<Assets> a = assetRepo.findById(id);
		if (a.isPresent()) {
			a.get().setAssignmentStatus("Assigned");
			return a.get();
		} else
			return null;
	}

	public Assets recoverAssign(Long id) {
		Optional<Assets> a = assetRepo.findById(id);
		if (a.isPresent()) {
			a.get().setAssignmentStatus("Recovered");
			return a.get();
		} else
			return null;
	}

	public Assets delete(Long id) {
		Optional<Assets> a = assetRepo.findById(id);
		if (a.isPresent()) {
			if (!a.get().getAssignmentStatus().equals("Assigned")) {
				assetRepo.delete(a.get());
				return a.get();
			}
			return null;
		} else
			return null;
	}

}
