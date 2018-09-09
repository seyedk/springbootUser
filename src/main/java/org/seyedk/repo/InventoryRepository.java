package org.seyedk.repo;



import org.seyedk.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Inventory findByAssetNumberAndMovingDate(String assetNumber, String movingDate);
	
}
