package com.setiti.paktani.geo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.setiti.paktani.entity.Location;
import com.setiti.paktani.entity.LocationCommodity;
import com.setiti.paktani.entity.Product;
import com.setiti.paktani.entity.ProductVolume;
import com.setiti.paktani.web.util.BackingBeanUtility;


@ManagedBean
@ViewScoped
public class InfoWindowView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MapModel advancedModel;
	  
    private Marker marker;
    
    private List<Product> production;
    private TreeNode root;
    private TreeNode root1;
  
    @PostConstruct
    public void init() {
        advancedModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(-7.5490000, 110.849000);
        //LatLng coord2 = new LatLng(36.883707, 30.689216);
        //LatLng coord3 = new LatLng(36.879703, 30.706707);
        //LatLng coord4 = new LatLng(36.885233, 30.702323);
          
        //Icons and Data
        advancedModel.addOverlay(new Marker(coord1, "Surokarto", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
        //advancedModel.addOverlay(new Marker(coord2, "Ataturk Parki", "ataturkparki.png"));
        //advancedModel.addOverlay(new Marker(coord4, "Kaleici", "kaleici.png", "http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));
        //advancedModel.addOverlay(new Marker(coord3, "Karaalioglu Parki", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
        initDummyData();
        testTree();
        testTreeTable();
    }
    
    public void testTree() {
        root = new DefaultTreeNode("Root", null);
        TreeNode node0 = new DefaultTreeNode("Node 0", root);
        TreeNode node1 = new DefaultTreeNode("Node 1", root);
         
        TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
        TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);
         
        TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
         
        node1.getChildren().add(new DefaultTreeNode("Node 1.1"));
        node00.getChildren().add(new DefaultTreeNode("Node 0.0.0"));
        node00.getChildren().add(new DefaultTreeNode("Node 0.0.1"));
        node01.getChildren().add(new DefaultTreeNode("Node 0.1.0"));
        node10.getChildren().add(new DefaultTreeNode("Node 1.0.0"));
        root.getChildren().add(new DefaultTreeNode("Node 2"));
    }
    public void testTreeTable() {
    	LocationCommodity locCom = BackingBeanUtility.createDummyLocationCommodity();
    	root1 = BackingBeanUtility.constructNode(locCom);
    	System.out.println("children:"+root1.getChildCount());
    }
 
    
  
    public TreeNode getRoot1() {
		return root1;
	}

	public void setRoot1(TreeNode root1) {
		this.root1 = root1;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public MapModel getAdvancedModel() {
        return advancedModel;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
    	System.out.println("event happens");
        marker = (Marker) event.getOverlay();
    }
      
    public Marker getMarker() {
        return marker;
    }
    
    private void initDummyData(){
    	Product p1 = new Product();
    	p1.setProductName("Singkong");
    	p1.setProductCategory("Palawija");
    	p1.setQuantityPerUnit(1000000);
    	
    	Product p2 = new Product();
    	p2.setProductName("Ubi");
    	p2.setProductCategory("Palawija");
    	p2.setQuantityPerUnit(1200000);
    	
    	Product p3 = new Product();
    	p3.setProductName("Jagung");
    	p3.setProductCategory("Palawija");
    	p3.setQuantityPerUnit(900000);
    	
    	production = new ArrayList<Product>();
    	production.add(p1);
    	production.add(p2);
    	production.add(p3);
    }

	public List<Product> getProduction() {
		return production;
	}

	public void setProduction(List<Product> production) {
		this.production = production;
	}
    
    
    
}
