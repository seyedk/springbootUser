/*
 * Copyright (c) 2018. Developed by Seyed Ketabchi on 9/9/18 2:13 PM. Last Modified 9/7/18 8:42 AM. Please use as is under your own discretion.
 */

package org.seyedk.repo;



import org.seyedk.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Inventory findByAssetNumberAndMovingDate(String assetNumber, String movingDate);
	
}
