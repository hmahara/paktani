package com.setiti.paktani.web.util;

import java.util.List;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.setiti.paktani.entity.Location;
import com.setiti.paktani.entity.LocationCommodity;
import com.setiti.paktani.entity.Product;
import com.setiti.paktani.entity.ProductVolume;
import com.setiti.paktani.geo.GeoConstants;

public class BackingBeanUtility {

	public static LocationCommodity createDummyLocationCommodity(){
		LocationCommodity klatenC = new LocationCommodity();
		Location klaten = new Location();
		klaten.setLocationName("Klaten");
		klaten.setLocationLevel(GeoConstants.LOCATION_LEVEL_KABUPATEN);
		klaten.setLocationLevelString(GeoConstants.LOCATION_NAME_KABUPATEN);
		klatenC.setLocation(klaten);
		ProductVolume pvKlaten = new ProductVolume(new Product("Jagung", "palawija"), 40);
		klatenC.setProductVolume(pvKlaten);
		
		LocationCommodity polanC = new LocationCommodity();
		Location polan = new Location();
		polan.setLocationName("Polanharjo");
		polan.setLocationLevel(GeoConstants.LOCATION_LEVEL_KECAMATAN);
		polan.setLocationLevelString(GeoConstants.LOCATION_NAME_KECAMATAN);
		polanC.setLocation(polan);
		ProductVolume pvPolan = new ProductVolume(new Product("Jagung", "palawija"), 30);
		polanC.setProductVolume(pvPolan);
		
		LocationCommodity delangC = new LocationCommodity();
		Location delang = new Location();
		delang.setLocationName("Delanggu");
		delang.setLocationLevel(GeoConstants.LOCATION_LEVEL_KECAMATAN);
		delang.setLocationLevelString(GeoConstants.LOCATION_NAME_KECAMATAN);
		delangC.setLocation(delang);
		ProductVolume pvDelang = new ProductVolume(new Product("Jagung", "palawija"), 10);
		delangC.setProductVolume(pvDelang);
		
		LocationCommodity kaumanC = new LocationCommodity();
		Location kauman = new Location();
		kauman.setLocationName("Kauman");
		kauman.setLocationLevel(GeoConstants.LOCATION_LEVEL_KALURAHAN);
		kauman.setLocationLevelString(GeoConstants.LOCATION_NAME_KALURAHAN);
		kaumanC.setLocation(kauman);
		ProductVolume pvKauman = new ProductVolume(new Product("Jagung", "palawija"), 25);
		kaumanC.setProductVolume(pvKauman);
		
		LocationCommodity turusC = new LocationCommodity();
		Location turus = new Location();
		turus.setLocationName("Kauman2");
		turus.setLocationLevel(GeoConstants.LOCATION_LEVEL_KALURAHAN);
		turus.setLocationLevelString(GeoConstants.LOCATION_NAME_KALURAHAN);
		turusC.setLocation(turus);
		ProductVolume pvTurus = new ProductVolume(new Product("Jagung", "palawija"), 5);
		turusC.setProductVolume(pvTurus);
		
		polanC.addLocationCommodityChild(kaumanC);
		polanC.addLocationCommodityChild(turusC);
		
		
		klatenC.addLocationCommodityChild(polanC);
		klatenC.addLocationCommodityChild(delangC);
		
		return klatenC;
	}
	
	public static TreeNode constructNode(LocationCommodity locCom){
		TreeNode root = new DefaultTreeNode("root", null);
		//TreeNode current = new DefaultTreeNode(locCom, root);
		recurseThis(root, locCom);
		
		return root;
	}
	
	private static void recurseThis(TreeNode node, LocationCommodity locCom){
		TreeNode current = new DefaultTreeNode(locCom, node);
		System.out.println("Adding "+locCom.getLocation().getLocationName());
		if (locCom.getChildren()!=null && locCom.getChildren().size()>0){
			List<LocationCommodity> children = locCom.getChildren();
			for (LocationCommodity child : children){
				
				//if (child.getChildren()!=null && child.getChildren().size()>0){
					recurseThis(current, child);
				//}
			}
		} else {
			//TreeNode justOne = new DefaultTreeNode(locCom, node);
			//return justOne;
		}
		//return node;
	}
}
