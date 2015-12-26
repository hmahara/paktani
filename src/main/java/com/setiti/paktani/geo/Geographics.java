package com.setiti.paktani.geo;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class Geographics implements Serializable{

	private MapModel draggableModel;
    
    private Marker marker;
     
    @PostConstruct
    public void init() {
        draggableModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(-7.5490000, 110.849000);
//        LatLng coord2 = new LatLng(36.883707, 30.689216);
//        LatLng coord3 = new LatLng(36.879703, 30.706707);
//        LatLng coord4 = new LatLng(36.885233, 30.702323);
//          
        //Draggable
        draggableModel.addOverlay(new Marker(coord1, "Omahe Minar Solo"));
//        draggableModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
//        draggableModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
//        draggableModel.addOverlay(new Marker(coord4, "Kaleici"));
//          
        for(Marker premarker : draggableModel.getMarkers()) {
            premarker.setDraggable(true);
        }
    }
      
    public MapModel getDraggableModel() {
        return draggableModel;
    }
      
    public void onMarkerDrag(MarkerDragEvent event) {
        marker = event.getMarker();
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Dragged", "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng()));
    }

	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

	public void setDraggableModel(MapModel draggableModel) {
		this.draggableModel = draggableModel;
	}
    
    
}
