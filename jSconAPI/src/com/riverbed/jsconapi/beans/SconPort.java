package com.riverbed.jsconapi.beans;

public class SconPort extends SconObject{
	

	  /**
	 * 
	 */
	private static final long serialVersionUID = -5952274237600444461L;
	  private String portId;
	  private String node;
	  private String tag;
	  private String type;
	  private String speeds;
	  private String speed;
	  private String patchlabel;
	  private String segment;
	  private String uplink;
	  private String portal;
	  private String mac;
	  private String virtualMac;
	  private String switchId;
	  private boolean autotrunk;
	  private String bridge_with;
	  private String ifname;
	  private String dcinterface;
	  private boolean auto;
	  private boolean autocfg;
	  private boolean tagged;
	  private boolean vsh_aux_enabled;
	  private boolean vsh_primary_enabled;
	  private boolean cluster_enabled;
	  private boolean data_enabled;
	  private boolean mgmt_enabled;
	  private String mgmt_config_type;
	  private String mgmt_ipv4;
	  private String mgmt_gw_ipv4;
	  private String mgmt_ipv6;
	  private String mgmt_gw_ipv6;
	  private String mgmt_dns_ipv4;
	  private boolean poe_disabled;
	  private boolean capab_multizone;
	  private boolean capab_vsh_aux;
	  private boolean capab_mgmt;
	  private boolean capab_lan;
	  private boolean capab_poe;
	  private boolean capab_uplink;
	  private boolean capab_cluster;
	  private boolean ha_mirrored_uplink;
	/**
	 * @return the portId
	 */
	public String getPortId() {
		return portId;
	}
	/**
	 * @param portId the portId to set
	 */
	public void setPortId(String portId) {
		this.portId = portId;
	}
	/**
	 * @return the node
	 */
	public String getNode() {
		return node;
	}
	/**
	 * @param node the node to set
	 */
	public void setNode(String node) {
		this.node = node;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the speeds
	 */
	public String getSpeeds() {
		return speeds;
	}
	/**
	 * @param speeds the speeds to set
	 */
	public void setSpeeds(String speeds) {
		this.speeds = speeds;
	}
	/**
	 * @return the speed
	 */
	public String getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	/**
	 * @return the patchlabel
	 */
	public String getPatchlabel() {
		return patchlabel;
	}
	/**
	 * @param patchlabel the patchlabel to set
	 */
	public void setPatchlabel(String patchlabel) {
		this.patchlabel = patchlabel;
	}
	/**
	 * @return the zone/segment
	 */
	public String getSegment() {
		return segment;
	}
	/**
	 * @param zone the zone/segment to set
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}
	/**
	 * @return the uplink
	 */
	public String getUplink() {
		return uplink;
	}
	/**
	 * @param uplink the uplink to set
	 */
	public void setUplink(String uplink) {
		this.uplink = uplink;
	}
	/**
	 * @return the portal
	 */
	public String getPortal() {
		return portal;
	}
	/**
	 * @param portal the portal to set
	 */
	public void setPortal(String portal) {
		this.portal = portal;
	}
	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}
	/**
	 * @param mac the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}
	/**
	 * @return the virtualMac
	 */
	public String getVirtualMac() {
		return virtualMac;
	}
	/**
	 * @param virtualMac the virtualMac to set
	 */
	public void setVirtualMac(String virtualMac) {
		this.virtualMac = virtualMac;
	}
	/**
	 * @return the switchId
	 */
	public String getSwitchId() {
		return switchId;
	}
	/**
	 * @param switchId the switchId to set
	 */
	public void setSwitchId(String switchId) {
		this.switchId = switchId;
	}
	/**
	 * @return the autotrunk
	 */
	public boolean isAutotrunk() {
		return autotrunk;
	}
	/**
	 * @param autotrunk the autotrunk to set
	 */
	public void setAutotrunk(boolean autotrunk) {
		this.autotrunk = autotrunk;
	}
	/**
	 * @return the bridge_with
	 */
	public String getBridge_with() {
		return bridge_with;
	}
	/**
	 * @param bridge_with the bridge_with to set
	 */
	public void setBridge_with(String bridge_with) {
		this.bridge_with = bridge_with;
	}
	/**
	 * @return the ifname
	 */
	public String getIfname() {
		return ifname;
	}
	/**
	 * @param ifname the ifname to set
	 */
	public void setIfname(String ifname) {
		this.ifname = ifname;
	}
	/**
	 * @return the dcinterface
	 */
	public String getDcinterface() {
		return dcinterface;
	}
	/**
	 * @param dcinterface the dcinterface to set
	 */
	public void setDcinterface(String dcinterface) {
		this.dcinterface = dcinterface;
	}
	/**
	 * @return the auto
	 */
	public boolean isAuto() {
		return auto;
	}
	/**
	 * @param auto the auto to set
	 */
	public void setAuto(boolean auto) {
		this.auto = auto;
	}
	/**
	 * @return the autocfg
	 */
	public boolean isAutocfg() {
		return autocfg;
	}
	/**
	 * @param autocfg the autocfg to set
	 */
	public void setAutocfg(boolean autocfg) {
		this.autocfg = autocfg;
	}
	/**
	 * @return the tagged
	 */
	public boolean isTagged() {
		return tagged;
	}
	/**
	 * @param tagged the tagged to set
	 */
	public void setTagged(boolean tagged) {
		this.tagged = tagged;
	}
	/**
	 * @return the vsh_aux_enabled
	 */
	public boolean isVsh_aux_enabled() {
		return vsh_aux_enabled;
	}
	/**
	 * @param vsh_aux_enabled the vsh_aux_enabled to set
	 */
	public void setVsh_aux_enabled(boolean vsh_aux_enabled) {
		this.vsh_aux_enabled = vsh_aux_enabled;
	}
	/**
	 * @return the vsh_primary_enabled
	 */
	public boolean isVsh_primary_enabled() {
		return vsh_primary_enabled;
	}
	/**
	 * @param vsh_primary_enabled the vsh_primary_enabled to set
	 */
	public void setVsh_primary_enabled(boolean vsh_primary_enabled) {
		this.vsh_primary_enabled = vsh_primary_enabled;
	}
	/**
	 * @return the cluster_enabled
	 */
	public boolean isCluster_enabled() {
		return cluster_enabled;
	}
	/**
	 * @param cluster_enabled the cluster_enabled to set
	 */
	public void setCluster_enabled(boolean cluster_enabled) {
		this.cluster_enabled = cluster_enabled;
	}
	/**
	 * @return the data_enabled
	 */
	public boolean isData_enabled() {
		return data_enabled;
	}
	/**
	 * @param data_enabled the data_enabled to set
	 */
	public void setData_enabled(boolean data_enabled) {
		this.data_enabled = data_enabled;
	}
	/**
	 * @return the mgmt_enabled
	 */
	public boolean isMgmt_enabled() {
		return mgmt_enabled;
	}
	/**
	 * @param mgmt_enabled the mgmt_enabled to set
	 */
	public void setMgmt_enabled(boolean mgmt_enabled) {
		this.mgmt_enabled = mgmt_enabled;
	}
	/**
	 * @return the mgmt_config_type
	 */
	public String getMgmt_config_type() {
		return mgmt_config_type;
	}
	/**
	 * @param mgmt_config_type the mgmt_config_type to set
	 */
	public void setMgmt_config_type(String mgmt_config_type) {
		this.mgmt_config_type = mgmt_config_type;
	}
	/**
	 * @return the mgmt_ipv4
	 */
	public String getMgmt_ipv4() {
		return mgmt_ipv4;
	}
	/**
	 * @param mgmt_ipv4 the mgmt_ipv4 to set
	 */
	public void setMgmt_ipv4(String mgmt_ipv4) {
		this.mgmt_ipv4 = mgmt_ipv4;
	}
	/**
	 * @return the mgmt_gw_ipv4
	 */
	public String getMgmt_gw_ipv4() {
		return mgmt_gw_ipv4;
	}
	/**
	 * @param mgmt_gw_ipv4 the mgmt_gw_ipv4 to set
	 */
	public void setMgmt_gw_ipv4(String mgmt_gw_ipv4) {
		this.mgmt_gw_ipv4 = mgmt_gw_ipv4;
	}
	/**
	 * @return the mgmt_ipv6
	 */
	public String getMgmt_ipv6() {
		return mgmt_ipv6;
	}
	/**
	 * @param mgmt_ipv6 the mgmt_ipv6 to set
	 */
	public void setMgmt_ipv6(String mgmt_ipv6) {
		this.mgmt_ipv6 = mgmt_ipv6;
	}
	/**
	 * @return the mgmt_gw_ipv6
	 */
	public String getMgmt_gw_ipv6() {
		return mgmt_gw_ipv6;
	}
	/**
	 * @param mgmt_gw_ipv6 the mgmt_gw_ipv6 to set
	 */
	public void setMgmt_gw_ipv6(String mgmt_gw_ipv6) {
		this.mgmt_gw_ipv6 = mgmt_gw_ipv6;
	}
	/**
	 * @return the mgmt_dns_ipv4
	 */
	public String getMgmt_dns_ipv4() {
		return mgmt_dns_ipv4;
	}
	/**
	 * @param mgmt_dns_ipv4 the mgmt_dns_ipv4 to set
	 */
	public void setMgmt_dns_ipv4(String mgmt_dns_ipv4) {
		this.mgmt_dns_ipv4 = mgmt_dns_ipv4;
	}
	/**
	 * @return the poe_disabled
	 */
	public boolean isPoe_disabled() {
		return poe_disabled;
	}
	/**
	 * @param poe_disabled the poe_disabled to set
	 */
	public void setPoe_disabled(boolean poe_disabled) {
		this.poe_disabled = poe_disabled;
	}
	/**
	 * @return the capab_multizone
	 */
	public boolean isCapab_multizone() {
		return capab_multizone;
	}
	/**
	 * @param capab_multizone the capab_multizone to set
	 */
	public void setCapab_multizone(boolean capab_multizone) {
		this.capab_multizone = capab_multizone;
	}
	/**
	 * @return the capab_vsh_aux
	 */
	public boolean isCapab_vsh_aux() {
		return capab_vsh_aux;
	}
	/**
	 * @param capab_vsh_aux the capab_vsh_aux to set
	 */
	public void setCapab_vsh_aux(boolean capab_vsh_aux) {
		this.capab_vsh_aux = capab_vsh_aux;
	}
	/**
	 * @return the capab_mgmt
	 */
	public boolean isCapab_mgmt() {
		return capab_mgmt;
	}
	/**
	 * @param capab_mgmt the capab_mgmt to set
	 */
	public void setCapab_mgmt(boolean capab_mgmt) {
		this.capab_mgmt = capab_mgmt;
	}
	/**
	 * @return the capab_lan
	 */
	public boolean isCapab_lan() {
		return capab_lan;
	}
	/**
	 * @param capab_lan the capab_lan to set
	 */
	public void setCapab_lan(boolean capab_lan) {
		this.capab_lan = capab_lan;
	}
	/**
	 * @return the capab_poe
	 */
	public boolean isCapab_poe() {
		return capab_poe;
	}
	/**
	 * @param capab_poe the capab_poe to set
	 */
	public void setCapab_poe(boolean capab_poe) {
		this.capab_poe = capab_poe;
	}
	/**
	 * @return the capab_uplink
	 */
	public boolean isCapab_uplink() {
		return capab_uplink;
	}
	/**
	 * @param capab_uplink the capab_uplink to set
	 */
	public void setCapab_uplink(boolean capab_uplink) {
		this.capab_uplink = capab_uplink;
	}
	/**
	 * @return the capab_cluster
	 */
	public boolean isCapab_cluster() {
		return capab_cluster;
	}
	/**
	 * @param capab_cluster the capab_cluster to set
	 */
	public void setCapab_cluster(boolean capab_cluster) {
		this.capab_cluster = capab_cluster;
	}
	/**
	 * @return the ha_mirrored_uplink
	 */
	public boolean isHa_mirrored_uplink() {
		return ha_mirrored_uplink;
	}
	/**
	 * @param ha_mirrored_uplink the ha_mirrored_uplink to set
	 */
	public void setHa_mirrored_uplink(boolean ha_mirrored_uplink) {
		this.ha_mirrored_uplink = ha_mirrored_uplink;
	}
	/**
	 * @param portId
	 * @param node
	 * @param tag
	 * @param type
	 * @param speeds
	 * @param speed
	 * @param patchlabel
	 * @param segment
	 * @param uplink
	 * @param portal
	 * @param mac
	 * @param virtualMac
	 * @param switchId
	 * @param autotrunk
	 * @param bridge_with
	 * @param ifname
	 * @param dcinterface
	 * @param auto
	 * @param autocfg
	 * @param tagged
	 * @param vsh_aux_enabled
	 * @param vsh_primary_enabled
	 * @param cluster_enabled
	 * @param data_enabled
	 * @param mgmt_enabled
	 * @param mgmt_config_type
	 * @param mgmt_ipv4
	 * @param mgmt_gw_ipv4
	 * @param mgmt_ipv6
	 * @param mgmt_gw_ipv6
	 * @param mgmt_dns_ipv4
	 * @param poe_disabled
	 * @param capab_multizone
	 * @param capab_vsh_aux
	 * @param capab_mgmt
	 * @param capab_lan
	 * @param capab_poe
	 * @param capab_uplink
	 * @param capab_cluster
	 * @param ha_mirrored_uplink
	 */
	public SconPort(String portId, String node, String tag, String type, String speeds, String speed, String patchlabel,
			String segment, String uplink, String portal, String mac, String virtualMac, String switchId,
			boolean autotrunk, String bridge_with, String ifname, String dcinterface, boolean auto, boolean autocfg,
			boolean tagged, boolean vsh_aux_enabled, boolean vsh_primary_enabled, boolean cluster_enabled,
			boolean data_enabled, boolean mgmt_enabled, String mgmt_config_type, String mgmt_ipv4, String mgmt_gw_ipv4,
			String mgmt_ipv6, String mgmt_gw_ipv6, String mgmt_dns_ipv4, boolean poe_disabled, boolean capab_multizone,
			boolean capab_vsh_aux, boolean capab_mgmt, boolean capab_lan, boolean capab_poe, boolean capab_uplink,
			boolean capab_cluster, boolean ha_mirrored_uplink) {
		super();
		this.portId = portId;
		this.node = node;
		this.tag = tag;
		this.type = type;
		this.speeds = speeds;
		this.speed = speed;
		this.patchlabel = patchlabel;
		this.segment = segment;
		this.uplink = uplink;
		this.portal = portal;
		this.mac = mac;
		this.virtualMac = virtualMac;
		this.switchId = switchId;
		this.autotrunk = autotrunk;
		this.bridge_with = bridge_with;
		this.ifname = ifname;
		this.dcinterface = dcinterface;
		this.auto = auto;
		this.autocfg = autocfg;
		this.tagged = tagged;
		this.vsh_aux_enabled = vsh_aux_enabled;
		this.vsh_primary_enabled = vsh_primary_enabled;
		this.cluster_enabled = cluster_enabled;
		this.data_enabled = data_enabled;
		this.mgmt_enabled = mgmt_enabled;
		this.mgmt_config_type = mgmt_config_type;
		this.mgmt_ipv4 = mgmt_ipv4;
		this.mgmt_gw_ipv4 = mgmt_gw_ipv4;
		this.mgmt_ipv6 = mgmt_ipv6;
		this.mgmt_gw_ipv6 = mgmt_gw_ipv6;
		this.mgmt_dns_ipv4 = mgmt_dns_ipv4;
		this.poe_disabled = poe_disabled;
		this.capab_multizone = capab_multizone;
		this.capab_vsh_aux = capab_vsh_aux;
		this.capab_mgmt = capab_mgmt;
		this.capab_lan = capab_lan;
		this.capab_poe = capab_poe;
		this.capab_uplink = capab_uplink;
		this.capab_cluster = capab_cluster;
		this.ha_mirrored_uplink = ha_mirrored_uplink;
	}
	/**
	 * 
	 */
	public SconPort() {
		super();
	}
	
	

}
