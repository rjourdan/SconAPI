package com.riverbed.jsconapi.rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import com.riverbed.jsconapi.beans.SconBroadcast;
import com.riverbed.jsconapi.beans.SconNetwork;
import com.riverbed.jsconapi.beans.SconNode;
import com.riverbed.jsconapi.beans.SconObject;
import com.riverbed.jsconapi.beans.SconPort;
import com.riverbed.jsconapi.beans.SconSite;
import com.riverbed.jsconapi.beans.SconSsid;
import com.riverbed.jsconapi.beans.SconUplink;
import com.riverbed.jsconapi.beans.SconWan;
import com.riverbed.jsconapi.beans.SconZone;

public class SconJsonObjectBuilder {
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static JsonObject buildSconJsonObject(SconObject obj){
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		
		if(obj instanceof SconSite){
			SconSite site = (SconSite) obj;
			jsonBuilder
				.add("name", site.getName())
				.add("longname", site.getLongName())
				.add("street address",site.getAddress())
				.add("city", site.getCity())
				.add("country", site.getCountryCode());
		}
		
		if(obj instanceof SconWan){
			SconWan wan = (SconWan) obj;
			jsonBuilder
				.add("name", wan.getName())
				.add("longname", wan.getLongname())
				.add("internet", wan.isInternet());
		}
		
		if(obj instanceof SconUplink){
			SconUplink uplink = (SconUplink) obj;
			jsonBuilder
			.add("name", uplink.getName())
			.add("site",uplink.getSite())
			.add("wan",uplink.getWan());
		}
		
		if(obj instanceof SconNode){
			SconNode node = (SconNode) obj;
			jsonBuilder
			.add("site",node.getSite())
			.add("model", node.getModel())
			.add("simulated", JsonValue.TRUE)
			.add("serial",JsonValue.NULL);
		}
		
		if(obj instanceof SconZone){
			SconZone zone = (SconZone) obj;
			jsonBuilder
			.add("name", zone.getName())
			.add("site",zone.getSiteID());
			
		}
		
		if(obj instanceof SconPort){
					
		}
		
		if(obj instanceof SconNetwork){
						
		}
		
		if(obj instanceof SconBroadcast){
			SconBroadcast bdcast = (SconBroadcast) obj;
			jsonBuilder
			.add("site",bdcast.getSite())
			.add("zone", bdcast.getZone())
			.add("ssid", bdcast.getSsid());
		}
		
		if(obj instanceof SconSsid){
			SconSsid ssid = (SconSsid) obj;
			jsonBuilder
			.add("ssid",ssid.getSsid())
			.add("security",ssid.getSecurity())
			.add("key", ssid.getKey());
		}
		
		json = jsonBuilder.build();
		return json;
	}

}
